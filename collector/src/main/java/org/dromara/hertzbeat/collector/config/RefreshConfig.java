package org.dromara.hertzbeat.collector.config;

import org.dromara.hertzbeat.common.util.HttpUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


/**
 * @name :  RefreshConfig
 * @description: 启动时从平台加载采集配置
 * @author: donnasky
 * @createDate: 2023/5/25
 */
@Component
public class RefreshConfig implements CommandLineRunner
{
    @Value("${refreshUrl}")
    private String url;

    @Override
    public void run(String... args)
        throws Exception
    {
        HttpUtils.sendGet(url);
    }
}
