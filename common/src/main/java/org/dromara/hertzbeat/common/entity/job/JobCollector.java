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

package org.dromara.hertzbeat.common.entity.job;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.dromara.hertzbeat.common.entity.manager.ParamDefine;
import org.dromara.hertzbeat.common.entity.message.CollectRep;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * Collect task details
 * 采集任务详情
 *
 * @author tomsun28
 *
 */
@Data
@Slf4j
public class JobCollector
{

    /**
     * Task id      任务ID
     */
    private long id;
    /**
     * Monitoring ID Application ID
     * 监控ID 应用ID
     */
    private long monitorId;
    /**
     * Large categories of monitoring       监控的大类别
     * service-application service monitoring db-database monitoring custom-custom monitoring os-operating system monitoring
     * service-应用服务监控 db-数据库监控 custom-自定义监控 os-操作系统监控
     */
    private String category;
    /**
     * Type of monitoring eg: linux | mysql | jvm
     * 监控的类型 eg: linux | mysql | jvm
     */
    private String app;
    /**
     * The internationalized name of the monitoring type    监控类型的国际化名称
     * zh-CN: PING连通性
     * en-US: PING CONNECT
     */
    private Map<String, String> name;
    /**
     * Task dispatch start timestamp
     * 任务派发开始时间戳
     */
    private long timestamp;
    /**
     * Task collection time interval (unit: second) eg: 30,60,600
     * 任务采集时间间隔(单位秒) eg: 30,60,600
     */
    private long interval = 600L;
    /**
     * Whether it is a recurring periodic task true is yes, false is no
     * 是否是循环周期性任务 true为是,false为否
     */
    private boolean isCyclic = false;
    /**
     * monitor input need params
     */
    private List<ParamDefine> params;
    /**
     * Indicator group configuration eg: cpu memory
     * 指标组配置 eg: cpu memory
     */
    private List<Metrics> metrics;
    /**
     * Monitoring configuration parameter properties and values eg: username password timeout host
     * 监控配置参数属性及值 eg: username password timeout host
     */
    private List<Configmap> configmap;

    /**
     * collector use - timestamp when the task was scheduled by the time wheel
     * collector使用 - 任务被时间轮开始调度的时间戳
     */
    private  transient  long dispatchTime;

    /**
     * collector use - task version, this field is not stored in etcd
     * collector使用 - 任务版本,此字段不存储于etcd
     */
    private   transient long version;
    /**
     * collector usage - metric group task execution priority view
     * collector使用 - 指标组任务执行优先级视图
     * 0 - availability
     * 1 - cpu | memory
     * 2 - health
     * 3 - otherMetrics
     * ....
     * 126 - otherMetrics
     * 127 - lastPriorMetrics
     */
    private  transient  LinkedList<Set<Metrics>> priorMetrics;

    /**
     * collector use - Temporarily store one-time task indicator group response data
     * collector使用 - 临时存储一次性任务指标组响应数据
     */
    private  transient  List<CollectRep.MetricsData> responseDataTemp;
}
