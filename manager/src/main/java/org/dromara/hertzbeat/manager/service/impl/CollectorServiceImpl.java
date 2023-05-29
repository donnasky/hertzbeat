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

package org.dromara.hertzbeat.manager.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.dromara.hertzbeat.common.entity.manager.Collector;
import org.dromara.hertzbeat.manager.dao.CollectorDao;
import org.dromara.hertzbeat.manager.service.CollectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


/**
 * @author donnasky
 */
@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class CollectorServiceImpl implements CollectorService
{

    @Autowired
    private CollectorDao collectorDao;
    @Override
    public void addCollectors(List<Collector> collectors)
    {
        collectorDao.saveAll(collectors);
    }

    @Override
    public void modifyCollector(Collector collector)
    {
        Optional<Collector> collectorOptional = collectorDao.findById(collector.getId());
        if (collectorOptional.isPresent())
        {
            collectorDao.save(collector);
        }
        else
        {
            throw new IllegalArgumentException("The collector is not existed");
        }
    }

    @Override
    public Page<Collector> getCollectors(Specification<Collector> specification,
                                         PageRequest pageRequest)
    {
        return collectorDao.findAll(specification, pageRequest);
    }

    @Override
    public void deleteCollectors(HashSet<Long> ids)
    {
        collectorDao.deleteAllByIdInBatch(ids);
    }

    @Override
    public List<Collector> listCollector(Set<Long> ids)
    {
        return collectorDao.findAllById(ids);
    }

    @Override
    public Collector getById(long id)
    {
        Optional<Collector> collectorOptional = collectorDao.findById(id);
        return collectorOptional.orElse(null);
    }
}
