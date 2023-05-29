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

package org.dromara.hertzbeat.common.entity.manager;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dromara.hertzbeat.common.support.valid.HostValid;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDateTime;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;
import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_WRITE;


/**
 * Collector Entity
 * 采集实体
 * @author donnasky
 *
 */
@Entity
@Table(name = "hzb_collector")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Collector Entity | 采集实体")
@EntityListeners(AuditingEntityListener.class)
public class Collector
{

    /**
     * Collector ID
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(title = "Tag主键索引ID", example = "87584674384", accessMode = READ_ONLY)
    private Long id;

    /**
     * Collector Name
     * 采集的名称
     */
    @Schema(title = "采集名称", example = "40内网采集", accessMode = READ_WRITE)
    @Length(max = 100)
    private String name;


    /**
     * Collector peer host: ipv4, ipv6, domain name
     * 监控的对端host:ipv4,ipv6,域名
     */
    @Schema(title = "采集端host", example = "192.167.25.11", accessMode = READ_WRITE)
    @Length(max = 100)
    @HostValid
    private String host;

    /**
     * Collector  port: i
     * 采集端口
     */
    @Schema(title = "采集端port", example = "1158", accessMode = READ_WRITE)
    private Short port;


    /**
     * Collector status 1: Available, 2: Unavailable
     * 采集程序状态 1:可用,2:不可用
     */
    @Schema(title = "采集程序状态 1:可用,2:不可用", accessMode = READ_WRITE)
    @Min(0)
    @Max(4)
    private byte status;

    /**
     * Collector note description
     * 采集备注描述
     */
    @Schema(title = "采集备注描述", example = "对公司内网进行监控", accessMode = READ_WRITE)
    @Length(max = 255)
    private String description;

    /**
     * The creator of this record
     * 此条记录创建者
     */
    @Schema(title = "此条记录创建者", example = "tom", accessMode = READ_ONLY)
    @CreatedBy
    private String creator;

    /**
     * This record was last modified by
     * 此条记录最新修改者
     */
    @Schema(title = "此条记录最新修改者", example = "tom", accessMode = READ_ONLY)
    @LastModifiedBy
    private String modifier;

    /**
     * record creation time (millisecond timestamp)
     * 记录创建时间
     */
    @Schema(title = "记录创建时间", example = "1612198922000", accessMode = READ_ONLY)
    @CreatedDate
    private LocalDateTime gmtCreate;

    /**
     * Record the latest modification time (timestamp in milliseconds)
     * 记录最新修改时间
     */
    @Schema(title = "记录最新修改时间", example = "1612198444000", accessMode = READ_ONLY)
    @LastModifiedDate
    private LocalDateTime gmtUpdate;

}
