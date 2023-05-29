package org.dromara.hertzbeat.manager.service;

import org.dromara.hertzbeat.common.entity.manager.Collector;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * 采集服务
 * @author donnasky
 */
public interface CollectorService
{
    /**
     * 新增采集程序
     * @param collectors collectors
     */
    void addCollectors(List<Collector> collectors);


    /**
     * update Collector
     *
     * @param collector collector
     */
    void modifyCollector(Collector collector);

    /**
     * get Collector page list
     *
     * @param specification 查询条件
     * @param pageRequest   分页条件
     * @return Collectors
     */
    Page<Collector> getCollectors(Specification<Collector> specification, PageRequest pageRequest);

    /**
     * delete Collectors
     *
     * @param ids Collector id list
     */
    void deleteCollectors(HashSet<Long> ids);

    /**
     * list Collectors
     *
     * @param ids Collector id list
     * @return Collector list
     */
    List<Collector> listCollector(Set<Long> ids);

    /**
     * 根据id查询采集信息
     * @param id
     * @return
     */
    Collector getById(long id);

}
