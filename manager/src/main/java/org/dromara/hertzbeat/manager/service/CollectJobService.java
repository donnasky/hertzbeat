/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.dromara.hertzbeat.manager.service;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.dromara.hertzbeat.common.entity.job.Job;
import org.dromara.hertzbeat.common.entity.manager.Collector;
import org.dromara.hertzbeat.common.entity.message.CollectRep;
import org.dromara.hertzbeat.common.util.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * Collection job management provides api interface
 * 采集job管理提供api接口
 *
 * @author tomsun28
 */
@Service
@Slf4j
public class CollectJobService
{

    // TODO: 拆分collector  2023/5/23 修改为用http方式访问collector模块

    @Autowired
    private CollectorService collectorService;
    /**
     * Execute a one-time collection task and get the collected data response
     * 执行一次性采集任务,获取采集数据响应
     *
     * @param job Collect task details  采集任务详情
     * @return Collection results       采集结果
     */
    public List<CollectRep.MetricsData> collectSyncJobData(Long collectorId, Job job)
    {
        Collector collector = collectorService.getById(collectorId);

        if (null == collector)
        {
            return null;
        }

        List<CollectRep.MetricsData> list = new ArrayList<>();
        try
        {
            String rsp = HttpUtils.sendPost(
                "http://" + collector.getHost() + ":" + collector.getPort() +
                "/collect/collectSyncJobData",
                JSON.toJSONString(job));

            list = JSON.parseArray(rsp, CollectRep.MetricsData.class);
        }
        catch (Exception e)
        {
            log.error("collectSyncJobData 失败！", e);
        }

        return list;
    }

    /**
     * Issue periodic asynchronous collection tasks
     * 下发周期性异步采集任务
     *
     * @param job Collect task details      采集任务详情
     * @return long Job ID      任务ID
     */
    public long addAsyncCollectJob(Long collectorId, Job job)
    {

        Collector collector = collectorService.getById(collectorId);

        if (null == collector)
        {
            return 0;
        }

        long resp = 0;

        try
        {
            String rsp = HttpUtils.sendPost(
                "http://" + collector.getHost() + ":" + collector.getPort() +
                "/collect/addAsyncCollectJob",
                JSON.toJSONString(job));

            resp = Long.parseLong(rsp);
        }
        catch (Exception e)
        {
            log.error("addAsyncCollectJob 失败！", e);
        }
        return resp;
    }

    /**
     * Update the periodic asynchronous collection tasks that have been delivered
     * 更新已经下发的周期性异步采集任务
     *
     * @param modifyJob Collect task details        采集任务详情
     * @return long Job ID      新任务ID
     */
    public long updateAsyncCollectJob(Long collectorId, Job modifyJob)
    {
        Collector collector = collectorService.getById(collectorId);

        if (null == collector)
        {
            return 0;
        }

        long resp = 0;
        try
        {
            String rsp = HttpUtils.sendPost(
                "http://" + collector.getHost() + ":" + collector.getPort() +
                "/collect/updateAsyncCollectJob",
                JSON.toJSONString(modifyJob));

            resp = Long.parseLong(rsp);
        }
        catch (Exception e)
        {
            log.error("updateAsyncCollectJob 失败！", e);
        }
        return resp;
    }

    /**
     * Cancel periodic asynchronous collection tasks
     * 取消周期性异步采集任务
     *
     * @param jobId Job ID      任务ID
     */
    public void cancelAsyncCollectJob(Long collectorId, Long jobId)
    {
        Collector collector = collectorService.getById(collectorId);

        if (null == collector)
        {
            return;
        }

        try
        {
            String rsp = HttpUtils.sendGet(
                "http://" + collector.getHost() + ":" + collector.getPort() +
                "/collect/cancelAsyncCollectJob?jobId=" + jobId);

            if (StringUtils.isBlank(rsp) || !String.valueOf(HttpStatus.OK.value()).equals(rsp))
            {
                throw new Exception("取消采集任务失败！");
            }
        }
        catch (Exception e)
        {
            log.error("cancelAsyncCollectJob 失败！", e);
        }
    }

}
