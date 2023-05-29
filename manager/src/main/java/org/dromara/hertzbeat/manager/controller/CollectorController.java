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

package org.dromara.hertzbeat.manager.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.dromara.hertzbeat.common.entity.dto.Message;
import org.dromara.hertzbeat.common.entity.manager.Collector;
import org.dromara.hertzbeat.manager.service.CollectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.Predicate;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


/**
 * Collector Manage API
 * 采集程序管理API
 *
 * @author donnasky
 */
@Tag(name = "Collector Manage API | 采集程序管理API")
@RestController
@RequestMapping(path = "/api/collector", produces = {APPLICATION_JSON_VALUE})
public class CollectorController
{
    @Autowired
    private CollectorService collectorService;

    @Autowired
    private org.dromara.hertzbeat.manager.service.JobSchedulerInit jobSchedulerInit;

    @PostMapping
    @Operation(summary = "Add Collector", description = "新增采集程序")
    public ResponseEntity<Message<Void>> addNewCollectors(
        @Valid @RequestBody List<Collector> collectors)
    {
        // Verify request data  校验请求数据 去重
        collectors = collectors.stream().peek(collector -> {
            collector.setId(null);
        }).distinct().collect(Collectors.toList());

        collectorService.addCollectors(collectors);

        return ResponseEntity.ok(new Message<>("Add success"));
    }

    @PutMapping
    @Operation(summary = "Modify an existing collector", description = "修改一个已存在采集程序")
    public ResponseEntity<Message<Void>> modifyMonitor(@Valid @RequestBody Collector collector)
    {
        // Verify request data  校验请求数据
        if (collector.getId() == null || collector.getName() == null)
        {
            throw new IllegalArgumentException("The collector not exist.");
        }
        collectorService.modifyCollector(collector);
        return ResponseEntity.ok(new Message<>("Modify success"));
    }

    @GetMapping()
    @Operation(summary = "Get collectors information", description = "根据条件获取采集程序信息")
    public ResponseEntity<Message<Page<Collector>>> getcollectors(
        @Parameter(description = "collector content search | 采集程序内容模糊查询", example = "status") @RequestParam(required = false) String search,
        @Parameter(description = "List current page | 列表当前分页", example = "0") @RequestParam(defaultValue = "0") int pageIndex,
        @Parameter(description = "Number of list pagination | 列表分页数量", example = "8") @RequestParam(defaultValue = "8") int pageSize)
    {
        // Get collector information
        Specification<Collector> specification = (root, query, criteriaBuilder) -> {
            List<Predicate> andList = new ArrayList<>();
            Predicate[] andPredicates = new Predicate[andList.size()];
            Predicate andPredicate = criteriaBuilder.and(andList.toArray(andPredicates));

            List<Predicate> orList = new ArrayList<>();
            if (search != null && !"".equals(search))
            {
                Predicate predicateName = criteriaBuilder.like(root.get("name"),
                    "%" + search + "%");
                orList.add(predicateName);
                Predicate predicateValue = criteriaBuilder.like(root.get("host"),
                    "%" + search + "%");
                orList.add(predicateValue);
            }
            Predicate[] orPredicates = new Predicate[orList.size()];
            Predicate orPredicate = criteriaBuilder.or(orList.toArray(orPredicates));

            if (andPredicate.getExpressions().isEmpty() && orPredicate.getExpressions().isEmpty())
            {
                return query.where().getRestriction();
            }
            else if (andPredicate.getExpressions().isEmpty())
            {
                return query.where(orPredicate).getRestriction();
            }
            else if (orPredicate.getExpressions().isEmpty())
            {
                return query.where(andPredicate).getRestriction();
            }
            else
            {
                return query.where(andPredicate, orPredicate).getRestriction();
            }
        };
        PageRequest pageRequest = PageRequest.of(pageIndex, pageSize);
        Page<Collector> alertPage = collectorService.getCollectors(specification, pageRequest);
        Message<Page<Collector>> message = new Message<>(alertPage);
        return ResponseEntity.ok(message);
    }

    @DeleteMapping()
    @Operation(summary = "Delete collectors based on ID", description = "根据collector ID删除collector")
    public ResponseEntity<Message<Void>> deletecollectors(
        @Parameter(description = "collector IDs | 监控ID列表", example = "6565463543") @RequestParam(required = false) List<Long> ids)
    {
        if (ids != null && !ids.isEmpty())
        {
            collectorService.deleteCollectors(new HashSet<>(ids));
        }
        return ResponseEntity.ok(new Message<>("Delete success"));
    }

    @GetMapping("getConfig")
    @Operation(summary = "Get collectors config", description = "采集程序获取配置信息")
    public Integer getConfig(
        @Parameter(description = "collector get config | 采集程序获取配置", example = "0") @RequestParam() Long collectorId)
    {
        jobSchedulerInit.addJobByCollectorId(collectorId);
        return HttpStatus.OK.value();
    }
}
