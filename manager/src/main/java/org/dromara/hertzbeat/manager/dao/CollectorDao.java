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

package org.dromara.hertzbeat.manager.dao;

import org.dromara.hertzbeat.common.entity.manager.Collector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


/**
 * AuthResources 数据库操作
 *
 * @author donnasky
 *
 */
public interface CollectorDao extends JpaRepository<Collector, Long>, JpaSpecificationExecutor<Collector> {

    /**
     * 初始化本地采集器，暂时未用
     */
    @Transactional
    @Modifying
    @Query(value = " REPLACE INTO `hzb_collector` (`id`, `creator`, `description`, `gmt_create`, `gmt_update`, `host`, `modifier`, `name`, `port`, `status`) VALUES (1, 'admin', NULL, null, null, '127.0.0.1', null, '默认采集程序', 1158,0)" , nativeQuery = true)
    void initLocalCollector();
}
