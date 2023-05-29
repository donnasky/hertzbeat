package org.dromara.hertzbeat.alert.calculate;

import lombok.extern.slf4j.Slf4j;
import org.dromara.hertzbeat.common.constants.CommonConstants;
import org.dromara.hertzbeat.common.entity.alerter.Alert;
import org.dromara.hertzbeat.common.entity.manager.Monitor;
import org.dromara.hertzbeat.common.entity.message.CollectRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @name :  NoMessageAlarm
 * @description: 用于判断监控项长时间未收到数据
 * @author: pg
 * @createDate: 2023/5/29
 */
@Slf4j
@Component
public class NoMessageAlarm
{

    /**
     * 所有监测项
     */
    public static Map<Long, Monitor> ALL_MONITORS = new ConcurrentHashMap<>();

    /**
     * 监测项的最新一次数据接收时间
     */
    public static Map<Long, Long> LATEST_METRICS = new ConcurrentHashMap<>();

    /**
     * 上一次告警时间
     */
    public static Map<Long, Long> LATEST_ALARM_TIME = new ConcurrentHashMap<>();

    /**
     * 无消息的监测列表
     */
    public static Set<Long> NO_MESSAEG_MONITORS = new HashSet<>();

    @Autowired
    private SilenceAlarm silenceAlarm;

    /**
     * 计数器
     */
    public static int count = 0;

    /**
     * 无告警计算
     */
    @SuppressWarnings("PMD")
    @Scheduled(cron = "*/10 * * * * ?")
    public void noMsgCalcuAlarm()
    {
        //初始等待一段时间，待采集初始化完毕后开始判断
        if (count <= 8)
        {
            count++;
            return;
        }

        Long now = System.currentTimeMillis();
        ALL_MONITORS.forEach((monitorId, monitor) -> {

            Long lastReceive = LATEST_METRICS.get(monitorId);

            //没有接到数据或者上一次收到数据间隔超过采集频率的2倍则触发告警
            if (null == lastReceive || now - lastReceive > monitor.getIntervals() * 1000L * 2L)
            {
                //新启动的monitor不判断告警
                if (null != monitor.getGmtUpdate() && now - monitor.getGmtUpdate().atZone(
                    ZoneId.systemDefault()).toInstant().toEpochMilli() <
                                                      monitor.getIntervals() * 1000L * 2L)
                {
                    return;
                }
                //600秒以内有相同的告警则认为是重复告警
                if (null != LATEST_ALARM_TIME.get(monitorId) &&
                    now - LATEST_ALARM_TIME.get(monitorId) < 1000 * 600L)
                {
                    log.warn("重复告警，过滤掉：" + monitor);
                    return;
                }

                LATEST_ALARM_TIME.put(monitorId, now);
                NO_MESSAEG_MONITORS.add(monitorId);
                addAlarm(monitor, now);
            }
            else
            {
                LATEST_ALARM_TIME.remove(monitorId);
                //若此监控之前不可用，则发送恢复可用性通知
                boolean isRestartNoMsg = NO_MESSAEG_MONITORS.remove(monitorId);
                if (isRestartNoMsg)
                {
                    // Sending an alarm Restore
                    Map<String, String> tags = new HashMap<>(6);
                    tags.put(CommonConstants.TAG_MONITOR_ID, String.valueOf(monitorId));
                    tags.put("host", monitor.getHost());
                    tags.put("collectorId", monitor.getCollectorId().toString());

                    String content =
                        "接收到指标信息，告警恢复：" + monitor.getApp() + "," + monitor.getName() + "," +
                        monitor.getHost();
                    long currentTimeMilli = System.currentTimeMillis();
                    Alert resumeAlert = Alert.builder()
                        .tags(tags)
                        .target(CommonConstants.AVAILABILITY)
                        .content(content)
                        .priority(CommonConstants.ALERT_PRIORITY_CODE_WARNING)
                        .status(CommonConstants.ALERT_STATUS_CODE_RESTORED)
                        .firstTriggerTime(currentTimeMilli)
                        .lastTriggerTime(currentTimeMilli)
                        .times(1)
                        .build();
                    silenceAlarm.filterSilenceAndSendData(resumeAlert);
                }
            }
        });
    }

    /**
     * 生成告警
     *
     * @param monitor
     * @param currentTimeMill
     */
    public void addAlarm(Monitor monitor, Long currentTimeMill)
    {

        Map<String, String> tags = new HashMap<>(6);
        tags.put(CommonConstants.TAG_MONITOR_ID, String.valueOf(monitor.getId()));
        tags.put("metrics", CommonConstants.AVAILABILITY);
        tags.put("code", CollectRep.Code.UN_AVAILABLE.name());
        tags.put("host", monitor.getHost());
        tags.put("collectorId", monitor.getCollectorId().toString());

        Alert.AlertBuilder alertBuilder = Alert.builder()
            .tags(tags)
            .priority(CommonConstants.ALERT_PRIORITY_CODE_EMERGENCY)
            .status(CommonConstants.ALERT_STATUS_CODE_PENDING)
            .target(CommonConstants.AVAILABILITY)
            .content("长时间未接收到指标信息：" + monitor.getApp() + "," + monitor.getName() + "," +
                     monitor.getHost())
            .firstTriggerTime(currentTimeMill)
            .lastTriggerTime(currentTimeMill)
            .times(1);
        silenceAlarm.filterSilenceAndSendData(alertBuilder.build());
    }
}
