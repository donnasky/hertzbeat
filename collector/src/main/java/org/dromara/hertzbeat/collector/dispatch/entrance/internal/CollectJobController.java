package org.dromara.hertzbeat.collector.dispatch.entrance.internal;

import com.alibaba.fastjson.JSON;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.dromara.hertzbeat.common.entity.job.Job;
import org.dromara.hertzbeat.common.entity.message.CollectRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @name :  CollectJobController
 * @description:  描述
 * @author:  donnasky
 * @createDate:  2023/5/23
 */
@Tag(name = "Collector receive API | 采集管理API")
@RestController
@RequestMapping(path = "/collect")
public class CollectJobController
{
    @Autowired
    private CollectJobService collectJobService;

    /**
     * 根据HttpServletRequest获取job
     * @param httpReq
     * @return
     */
    private Job getJobByHttpServertReq(HttpServletRequest httpReq)
    {
        Job jb = new Job();
        try
        {
            String  req = httpReq.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

            jb=JSON.parseObject(req,Job.class);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return jb;
    }


    @PostMapping("/addAsyncCollectJob")
    @Operation(summary = "addAsyncCollectJob", description = "新增异步采集任务")
    public long addAsyncCollectJob(HttpServletRequest httpReq)
    {
        Job jb = getJobByHttpServertReq(httpReq);
        return collectJobService.addAsyncCollectJob(jb);
    }

    @PostMapping("/collectSyncJobData")
    @Operation(summary = "collectSyncJobData", description = "查询同步采集任务信息")
    public List<CollectRep.MetricsData> collectSyncJobData(HttpServletRequest httpReq)
    {
        Job jb = getJobByHttpServertReq(httpReq);
        return collectJobService.collectSyncJobData(jb);
    }

    @PostMapping("/updateAsyncCollectJob")
    @Operation(summary = "updateAsyncCollectJob", description = "更新异步采集任务列表")
    public long updateAsyncCollectJob(HttpServletRequest httpReq)
    {
        Job jb = getJobByHttpServertReq(httpReq);
        return collectJobService.updateAsyncCollectJob(jb);
    }

    @GetMapping("/cancelAsyncCollectJob")
    @Operation(summary = "cancelAsyncCollectJob", description = "删除异步异步采集任务")
    public Integer cancelAsyncCollectJob(Long jobId)
    {
        collectJobService.cancelAsyncCollectJob(jobId);
        return HttpStatus.OK.value();
    }

    @GetMapping("/status")
    @Operation(summary = "status", description = "获取采集状态")
    public Integer status()
    {
        return HttpStatus.OK.value();
    }
}
