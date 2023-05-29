package org.dromara.hertzbeat.collector;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;


/*
 * @name :  Test
 * @description:  描述
 * @author:  pg
 * @createDate:  2023/5/24
 */
public class Test
{

    public static String json = "{\n" +
                                "    \"code\": 200,\n" +
                                "    \"msg\": \"success\",\n" +
                                "    \"data\": {\n" +
                                "        \"device_list\": [\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02AA-0000-A120-C2E703554697\",\n" +
                                "                        \"channel_name\": \"S101\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.30.53\",\n" +
                                "                \"device_name\": \"S101\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02AA-0000-977C-0C6860FC0FBE\",\n" +
                                "                        \"channel_name\": \"S102\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.30.52\",\n" +
                                "                \"device_name\": \"S102\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02AB-0000-B348-A553DDEDD95B\",\n" +
                                "                        \"channel_name\": \"S106\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.30.56\",\n" +
                                "                \"device_name\": \"S106\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02AB-0000-A921-75F0273C03C3\",\n" +
                                "                        \"channel_name\": \"S107\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.30.59\",\n" +
                                "                \"device_name\": \"S107\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02AB-0000-918F-555DB0A9CD42\",\n" +
                                "                        \"channel_name\": \"S104\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.30.50\",\n" +
                                "                \"device_name\": \"S104\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02AC-0000-A184-43439BEB0F45\",\n" +
                                "                        \"channel_name\": \"S109\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.30.66\",\n" +
                                "                \"device_name\": \"S109\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02AC-0000-904D-4D2CE6FECF60\",\n" +
                                "                        \"channel_name\": \"S108\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.30.60\",\n" +
                                "                \"device_name\": \"S108\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02AD-0000-A5B3-81358171B233\",\n" +
                                "                        \"channel_name\": \"S110\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.30.67\",\n" +
                                "                \"device_name\": \"S110\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02AD-0000-8840-D560C86189B2\",\n" +
                                "                        \"channel_name\": \"S111\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.30.70\",\n" +
                                "                \"device_name\": \"S111\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02AD-0000-8359-8B4582070C25\",\n" +
                                "                        \"channel_name\": \"S112\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.30.71\",\n" +
                                "                \"device_name\": \"S112\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02AE-0000-9E5E-9ED10E369484\",\n" +
                                "                        \"channel_name\": \"S114\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.30.75\",\n" +
                                "                \"device_name\": \"S114\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02AE-0000-B6B8-39BD11EF6DE8\",\n" +
                                "                        \"channel_name\": \"S113\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.30.76\",\n" +
                                "                \"device_name\": \"S113\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02AF-0000-9357-2F1BA9DD8CC5\",\n" +
                                "                        \"channel_name\": \"S118\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.30.81\",\n" +
                                "                \"device_name\": \"S118\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02AF-0000-8B4C-9F860BB5533C\",\n" +
                                "                        \"channel_name\": \"S116\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.30.79\",\n" +
                                "                \"device_name\": \"S116\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02AF-0000-BB70-057AD15C5C3A\",\n" +
                                "                        \"channel_name\": \"S115\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.30.77\",\n" +
                                "                \"device_name\": \"S115\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02AF-0000-9874-0FEA9B111A11\",\n" +
                                "                        \"channel_name\": \"S117\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.30.80\",\n" +
                                "                \"device_name\": \"S117\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02B0-0000-9B33-39DED2838FFD\",\n" +
                                "                        \"channel_name\": \"S119\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.30.84\",\n" +
                                "                \"device_name\": \"S119\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02B0-0000-BE62-A16E5C144FB9\",\n" +
                                "                        \"channel_name\": \"S121\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.30.86\",\n" +
                                "                \"device_name\": \"S121\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02B0-0000-A250-6114EB4339CE\",\n" +
                                "                        \"channel_name\": \"S120\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.30.85\",\n" +
                                "                \"device_name\": \"S120\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02B1-0000-840C-2C3EC651553E\",\n" +
                                "                        \"channel_name\": \"S122\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.30.83\",\n" +
                                "                \"device_name\": \"S122\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02B2-0000-943D-B20E4E1CA0E5\",\n" +
                                "                        \"channel_name\": \"S127\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.30.103\",\n" +
                                "                \"device_name\": \"S127\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02B2-0000-BA5E-9C388BF30929\",\n" +
                                "                        \"channel_name\": \"S128\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.30.105\",\n" +
                                "                \"device_name\": \"S128\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02B3-0000-8D79-31D5C09CB9AC\",\n" +
                                "                        \"channel_name\": \"S130\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.30.58\",\n" +
                                "                \"device_name\": \"S130\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02B5-0000-A744-3CBE4BBEEC91\",\n" +
                                "                        \"channel_name\": \"办公楼左侧S723\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.30.31\",\n" +
                                "                \"device_name\": \"办公楼左侧S723\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02B5-0000-99CA-B916B40FB95B\",\n" +
                                "                        \"channel_name\": \"办公楼厨房旁S709\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.30.47\",\n" +
                                "                \"device_name\": \"办公楼厨房旁S709\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02B6-0000-B5EE-F37D131C321B\",\n" +
                                "                        \"channel_name\": \"办公楼后水泵房\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.30.49\",\n" +
                                "                \"device_name\": \"办公楼后水泵房\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02B6-0000-A8FA-2A7B4CDF7411\",\n" +
                                "                        \"channel_name\": \"办公楼后门S708\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.30.46\",\n" +
                                "                \"device_name\": \"办公楼后门S708\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02B6-0000-A957-2C9A8E9578D8\",\n" +
                                "                        \"channel_name\": \"办公楼右侧S724\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.30.32\",\n" +
                                "                \"device_name\": \"办公楼右侧S724\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02B7-0000-A13B-F0B0AE8AAA83\",\n" +
                                "                        \"channel_name\": \"低位水池水泵房枪机\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.31.97\",\n" +
                                "                \"device_name\": \"低位水池水泵房枪机\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02B7-0000-BC1A-D9540F6E42CD\",\n" +
                                "                        \"channel_name\": \"办公楼道路东门岗S722\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.30.30\",\n" +
                                "                \"device_name\": \"办公楼道路东门岗S722\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02B7-0000-8327-3FD2DA1C7512\",\n" +
                                "                        \"channel_name\": \"低位消防水池S711\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.31.96\",\n" +
                                "                \"device_name\": \"低位消防水池S711\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02B8-0000-84CA-6EF160C1628F\",\n" +
                                "                        \"channel_name\": \"地磅房入口S216\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.31.95\",\n" +
                                "                \"device_name\": \"地磅房入口S216\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02B9-0000-9C0A-C51C0E9DCF54\",\n" +
                                "                        \"channel_name\": \"堆体二期集气站IPC\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.32.118\",\n" +
                                "                \"device_name\": \"堆体二期集气站IPC\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02BA-0000-993A-4BE0A251A4F3\",\n" +
                                "                        \"channel_name\": \"二号污泥坑S210\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.31.74\",\n" +
                                "                \"device_name\": \"二号污泥坑S210\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02BA-0000-BFBF-A8EBBECDF728\",\n" +
                                "                        \"channel_name\": \"二号污泥坑西侧S220\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.31.108\",\n" +
                                "                \"device_name\": \"二号污泥坑西侧S220\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02BA-0000-ABE7-CD85BA0CFD66\",\n" +
                                "                        \"channel_name\": \"二号污泥坑S207\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.31.67\",\n" +
                                "                \"device_name\": \"二号污泥坑S207\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02BB-0000-96EB-1BFBB52CEB93\",\n" +
                                "                        \"channel_name\": \"二期填埋区S304\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.32.60\",\n" +
                                "                \"device_name\": \"二期填埋区S304\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02BB-0000-8A71-07E58E1E4554\",\n" +
                                "                        \"channel_name\": \"二期填埋区S301\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.32.50\",\n" +
                                "                \"device_name\": \"二期填埋区S301\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02BC-0000-8BBA-77C52CF4FC48\",\n" +
                                "                        \"channel_name\": \"二期填埋区S312\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.32.82\",\n" +
                                "                \"device_name\": \"二期填埋区S312\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02BC-0000-931C-85EE3E106CF3\",\n" +
                                "                        \"channel_name\": \"二期填埋区S311\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.32.79\",\n" +
                                "                \"device_name\": \"二期填埋区S311\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02BC-0000-AF9D-C83BE92B9A17\",\n" +
                                "                        \"channel_name\": \"二期填埋区S306\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.32.66\",\n" +
                                "                \"device_name\": \"二期填埋区S306\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02BC-0000-9AE7-68247AE1218F\",\n" +
                                "                        \"channel_name\": \"二期填埋区S307\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.32.67\",\n" +
                                "                \"device_name\": \"二期填埋区S307\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02BD-0000-92DB-0A33F9E9B29A\",\n" +
                                "                        \"channel_name\": \"二期填埋区S313\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.32.87\",\n" +
                                "                \"device_name\": \"二期填埋区S313\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02BD-0000-868E-0FC698B4A38E\",\n" +
                                "                        \"channel_name\": \"二期填埋区S315\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.32.96\",\n" +
                                "                \"device_name\": \"二期填埋区S315\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02BD-0000-A2B0-92984552AC26\",\n" +
                                "                        \"channel_name\": \"二期填埋区S314\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.32.92\",\n" +
                                "                \"device_name\": \"二期填埋区S314\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02BE-0000-9D96-6B91A9B52AD6\",\n" +
                                "                        \"channel_name\": \"二期填埋区S316\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.32.100\",\n" +
                                "                \"device_name\": \"二期填埋区S316\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02BF-0000-B4A6-4DCCC02DEF32\",\n" +
                                "                        \"channel_name\": \"二期填埋区S406\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.32.101\",\n" +
                                "                \"device_name\": \"二期填埋区S406\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02C1-0000-8252-03B06D5DC41D\",\n" +
                                "                        \"channel_name\": \"灰飞二期填埋区S308\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.32.72\",\n" +
                                "                \"device_name\": \"灰飞二期填埋区S308\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02C1-0000-9BB2-5EE632241A03\",\n" +
                                "                        \"channel_name\": \"观景台二期填埋区S317\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.32.104\",\n" +
                                "                \"device_name\": \"观景台二期填埋区S317\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02C1-0000-B92C-84F1ED85AADA\",\n" +
                                "                        \"channel_name\": \"灰飞二期填埋区S309\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.32.75\",\n" +
                                "                \"device_name\": \"灰飞二期填埋区S309\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02C2-0000-94A2-F04315639FE1\",\n" +
                                "                        \"channel_name\": \"机修楼西北三叉路口S221\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.31.111\",\n" +
                                "                \"device_name\": \"机修楼西北三叉路口S221\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02C2-0000-87BD-57576939185A\",\n" +
                                "                        \"channel_name\": \"机修楼后S231\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.31.114\",\n" +
                                "                \"device_name\": \"机修楼后S231\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02C2-0000-AD82-96F0B4B0B717\",\n" +
                                "                        \"channel_name\": \"机修楼前S230\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.31.115\",\n" +
                                "                \"device_name\": \"机修楼前S230\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02C3-0000-A0EF-573773DBA476\",\n" +
                                "                        \"channel_name\": \"接水处S241\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.31.92\",\n" +
                                "                \"device_name\": \"接水处S241\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02C3-0000-B832-D299BEC89C96\",\n" +
                                "                        \"channel_name\": \"进出口道路S208\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.31.68\",\n" +
                                "                \"device_name\": \"进出口道路S208\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02C3-0000-A2E1-F570CD39D968\",\n" +
                                "                        \"channel_name\": \"192.168.31.80_80_CAM001\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.31.80\",\n" +
                                "                \"device_name\": \"192.168.31.80_80\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02C4-0000-BF70-DAB660AFF093\",\n" +
                                "                        \"channel_name\": \"排洪沟二期填埋区S713\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.32.131\",\n" +
                                "                \"device_name\": \"排洪沟二期填埋区S713\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02C4-0000-8D8F-0E36DF738CB6\",\n" +
                                "                        \"channel_name\": \"排洪沟二期填埋区S712\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.32.128\",\n" +
                                "                \"device_name\": \"排洪沟二期填埋区S712\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02C5-0000-AC44-E4BF56110066\",\n" +
                                "                        \"channel_name\": \"排洪沟二期填埋区S715\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.32.133\",\n" +
                                "                \"device_name\": \"排洪沟二期填埋区S715\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02C5-0000-BA25-F5684D58F74B\",\n" +
                                "                        \"channel_name\": \"排洪沟二期填埋区S714\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.32.132\",\n" +
                                "                \"device_name\": \"排洪沟二期填埋区S714\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02C6-0000-9D12-37C96BA3085B\",\n" +
                                "                        \"channel_name\": \"排洪隧道S602\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.33.51\",\n" +
                                "                \"device_name\": \"排洪隧道S602\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02C6-0000-A903-D0867F65F09E\",\n" +
                                "                        \"channel_name\": \"排洪隧道S603\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.33.52\",\n" +
                                "                \"device_name\": \"排洪隧道S603\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02C6-0000-8BBD-1C66B8B09070\",\n" +
                                "                        \"channel_name\": \"排洪隧道S601\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.33.50\",\n" +
                                "                \"device_name\": \"排洪隧道S601\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02C6-0000-A23C-BF44BEE4E2D7\",\n" +
                                "                        \"channel_name\": \"排洪沟二期填埋区S717\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.32.135\",\n" +
                                "                \"device_name\": \"排洪沟二期填埋区S717\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02C7-0000-B701-D7F75DE3E7DC\",\n" +
                                "                        \"channel_name\": \"排洪隧道S604\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.33.54\",\n" +
                                "                \"device_name\": \"排洪隧道S604\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02C7-0000-B4BD-64FE1624B029\",\n" +
                                "                        \"channel_name\": \"排洪隧道S605\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.33.55\",\n" +
                                "                \"device_name\": \"排洪隧道S605\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02C7-0000-ACD4-406C50413557\",\n" +
                                "                        \"channel_name\": \"排洪隧道S606\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.33.56\",\n" +
                                "                \"device_name\": \"排洪隧道S606\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02C8-0000-A39E-EA260E3B0822\",\n" +
                                "                        \"channel_name\": \"排洪隧道S607\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.33.58\",\n" +
                                "                \"device_name\": \"排洪隧道S607\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02C8-0000-AD79-36D158AA3FA0\",\n" +
                                "                        \"channel_name\": \"排洪隧道S608\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.33.59\",\n" +
                                "                \"device_name\": \"排洪隧道S608\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02C9-0000-9670-F511B2CBF85C\",\n" +
                                "                        \"channel_name\": \"排洪隧道S609\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.33.60\",\n" +
                                "                \"device_name\": \"排洪隧道S609\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02C9-0000-8D38-E0D6A2CA1B32\",\n" +
                                "                        \"channel_name\": \"排洪隧道S610\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.33.61\",\n" +
                                "                \"device_name\": \"排洪隧道S610\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02CA-0000-84D5-7DAD72D3944F\",\n" +
                                "                        \"channel_name\": \"排洪隧道S611\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.33.62\",\n" +
                                "                \"device_name\": \"排洪隧道S611\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02CA-0000-BC1B-067BC58681DE\",\n" +
                                "                        \"channel_name\": \"排洪隧道S612\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.33.63\",\n" +
                                "                \"device_name\": \"排洪隧道S612\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02CA-0000-BB7C-C5DF8D72282C\",\n" +
                                "                        \"channel_name\": \"排洪隧道S614\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.33.67\",\n" +
                                "                \"device_name\": \"排洪隧道S614\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02CA-0000-B159-164C4533FF9B\",\n" +
                                "                        \"channel_name\": \"排洪隧道S613\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.33.66\",\n" +
                                "                \"device_name\": \"排洪隧道S613\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02CB-0000-B55E-B74261E8CDEB\",\n" +
                                "                        \"channel_name\": \"排洪隧道S616\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.33.69\",\n" +
                                "                \"device_name\": \"排洪隧道S616\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02CB-0000-8D73-158B41F9C1ED\",\n" +
                                "                        \"channel_name\": \"排洪隧道S615\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.33.68\",\n" +
                                "                \"device_name\": \"排洪隧道S615\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02CC-0000-BB51-192BC697418A\",\n" +
                                "                        \"channel_name\": \"排洪隧道S619\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.33.74\",\n" +
                                "                \"device_name\": \"排洪隧道S619\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02CC-0000-B3A8-999663F59A1F\",\n" +
                                "                        \"channel_name\": \"排洪隧道S617\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.33.70\",\n" +
                                "                \"device_name\": \"排洪隧道S617\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02CC-0000-86F9-FE630BC05C4F\",\n" +
                                "                        \"channel_name\": \"排洪隧道S618\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.33.71\",\n" +
                                "                \"device_name\": \"排洪隧道S618\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02CD-0000-861A-DBB30A8CB38C\",\n" +
                                "                        \"channel_name\": \"排洪隧道S622\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.33.77\",\n" +
                                "                \"device_name\": \"排洪隧道S622\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02CD-0000-9EED-8DB49D510E96\",\n" +
                                "                        \"channel_name\": \"排洪隧道S621\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.33.76\",\n" +
                                "                \"device_name\": \"排洪隧道S621\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02CD-0000-82E3-7366409AC6B7\",\n" +
                                "                        \"channel_name\": \"排洪隧道S620\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.33.75\",\n" +
                                "                \"device_name\": \"排洪隧道S620\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02CE-0000-BE80-E90A6E156A81\",\n" +
                                "                        \"channel_name\": \"排洪隧道S623\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.33.78\",\n" +
                                "                \"device_name\": \"排洪隧道S623\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02D0-0000-B9A3-84516F7647D2\",\n" +
                                "                        \"channel_name\": \"三叉路口S201\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.31.54\",\n" +
                                "                \"device_name\": \"三叉路口S201\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02D0-0000-8BF7-1A0AEB30C70D\",\n" +
                                "                        \"channel_name\": \"山上地磅岗亭后S212\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.31.78\",\n" +
                                "                \"device_name\": \"山上地磅岗亭后S212\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02D1-0000-AAFB-5A2CF85F6223\",\n" +
                                "                        \"channel_name\": \"山上地磅岗亭前S721\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.31.99\",\n" +
                                "                \"device_name\": \"山上地磅岗亭前S721\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02D1-0000-8569-84C02277F4F2\",\n" +
                                "                        \"channel_name\": \"渗滤液处理二厂门口S140\",\n" +
                                "                        \"status\": \"offline\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.30.120\",\n" +
                                "                \"device_name\": \"渗滤液处理二厂门口S140\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02D2-0000-B772-CC10BB7AD29D\",\n" +
                                "                        \"channel_name\": \"一厂中控楼门口\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.30.162\",\n" +
                                "                \"device_name\": \"一厂中控楼门口\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02D2-0000-BF48-1932F39710E4\",\n" +
                                "                        \"channel_name\": \"一厂污泥浓缩池\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.30.161\",\n" +
                                "                \"device_name\": \"一厂污泥浓缩池\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02D3-0000-918D-049722ABD2CF\",\n" +
                                "                        \"channel_name\": \"一厂预处理反应池\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.30.154\",\n" +
                                "                \"device_name\": \"一厂预处理反应池\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02D3-0000-BDF2-8D116B1B57D5\",\n" +
                                "                        \"channel_name\": \"一厂硫酸罐及吹脱塔\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.30.163\",\n" +
                                "                \"device_name\": \"一厂硫酸罐及吹脱塔\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02D4-0000-A26C-D24F8871C71F\",\n" +
                                "                        \"channel_name\": \"一厂内部调节池\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.30.158\",\n" +
                                "                \"device_name\": \"一厂内部调节池\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02D4-0000-839B-2C28433D87CF\",\n" +
                                "                        \"channel_name\": \"一厂硝酸储存间\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.30.155\",\n" +
                                "                \"device_name\": \"一厂硝酸储存间\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02D5-0000-8A41-C452211C199A\",\n" +
                                "                        \"channel_name\": \"渗滤液一厂道路拐弯处前S105\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.30.150\",\n" +
                                "                \"device_name\": \"渗滤液一厂道路拐弯处前S105\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02D5-0000-B19D-6227B7EDBDDB\",\n" +
                                "                        \"channel_name\": \"一厂内部道路\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.30.159\",\n" +
                                "                \"device_name\": \"一厂内部道路\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02D6-0000-9159-590285EAEFE8\",\n" +
                                "                        \"channel_name\": \"隧道口二期填埋区S303\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.32.54\",\n" +
                                "                \"device_name\": \"隧道口二期填埋区S303\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02D6-0000-BEB4-C529BD9A5F09\",\n" +
                                "                        \"channel_name\": \"隧道口二期填埋区S302\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.32.53\",\n" +
                                "                \"device_name\": \"隧道口二期填埋区S302\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02D7-0000-ACF2-C0AEE0443508\",\n" +
                                "                        \"channel_name\": \"隧道口上坡后S233\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.31.117\",\n" +
                                "                \"device_name\": \"隧道口上坡后S233\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02D7-0000-B96E-10F5AC76A139\",\n" +
                                "                        \"channel_name\": \"隧道口上坡S234\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.31.119\",\n" +
                                "                \"device_name\": \"隧道口上坡S234\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02D8-0000-8331-FC52AE350E84\",\n" +
                                "                        \"channel_name\": \"提纯站到2号污泥坑中断S401\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.31.51\",\n" +
                                "                \"device_name\": \"提纯站到2号污泥坑中断S401\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02D8-0000-B2CA-1CF30363EC66\",\n" +
                                "                        \"channel_name\": \"提纯站到2号污泥坑中断S202\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.31.50\",\n" +
                                "                \"device_name\": \"提纯站到2号污泥坑中断S202\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02D8-0000-83E7-57A93D228877\",\n" +
                                "                        \"channel_name\": \"提纯厂上坡S232\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.31.118\",\n" +
                                "                \"device_name\": \"提纯厂上坡S232\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02D9-0000-8729-B2ACA1A46BA9\",\n" +
                                "                        \"channel_name\": \"提纯站三叉路口2号S222\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.31.112\",\n" +
                                "                \"device_name\": \"提纯站三叉路口2号S222\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02D9-0000-8897-A47F850EF520\",\n" +
                                "                        \"channel_name\": \"往污水处理三厂路首端S219\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.31.107\",\n" +
                                "                \"device_name\": \"往污水处理三厂路首端S219\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02DA-0000-92FC-0F374123A996\",\n" +
                                "                        \"channel_name\": \"往污水处理三厂路中段S218\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.31.101\",\n" +
                                "                \"device_name\": \"往污水处理三厂路中段S218\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02DA-0000-87BA-FA8D6A9A741C\",\n" +
                                "                        \"channel_name\": \"新地磅房枪机\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.31.100\",\n" +
                                "                \"device_name\": \"新地磅房枪机\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02DB-0000-8BCE-51765543814B\",\n" +
                                "                        \"channel_name\": \"新集气站S318\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.32.105\",\n" +
                                "                \"device_name\": \"新集气站S318\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02DB-0000-86EC-E76B9B72CFC9\",\n" +
                                "                        \"channel_name\": \"新集气站S319\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.32.115\",\n" +
                                "                \"device_name\": \"新集气站S319\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02DC-0000-91F2-DF09697513F8\",\n" +
                                "                        \"channel_name\": \"新建北侧截洪沟S703\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.31.131\",\n" +
                                "                \"device_name\": \"新建北侧截洪沟S703\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02DC-0000-9700-9F388101E0CE\",\n" +
                                "                        \"channel_name\": \"新建北侧截洪沟S704\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.31.132\",\n" +
                                "                \"device_name\": \"新建北侧截洪沟S704\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02DC-0000-92FD-5F7CDA1B9B35\",\n" +
                                "                        \"channel_name\": \"新集气站S320\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.32.114\",\n" +
                                "                \"device_name\": \"新集气站S320\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02DD-0000-BA10-1AE8868D037A\",\n" +
                                "                        \"channel_name\": \"新建北侧截洪沟S705\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.31.133\",\n" +
                                "                \"device_name\": \"新建北侧截洪沟S705\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02DD-0000-8962-7FF3C035D3C9\",\n" +
                                "                        \"channel_name\": \"新建北侧截洪沟S706\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.31.134\",\n" +
                                "                \"device_name\": \"新建北侧截洪沟S706\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02DE-0000-8B9F-8973AC98C135\",\n" +
                                "                        \"channel_name\": \"新建进出场2号道路S213\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.31.84\",\n" +
                                "                \"device_name\": \"新建进出场2号道路S213\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02DE-0000-A67B-922D647E6CBE\",\n" +
                                "                        \"channel_name\": \"新建进出场1号道路S408\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.31.79\",\n" +
                                "                \"device_name\": \"新建进出场1号道路S408\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02DF-0000-9CF9-C798352EF179\",\n" +
                                "                        \"channel_name\": \"新建进出场3号道路S236\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.31.88\",\n" +
                                "                \"device_name\": \"新建进出场3号道路S236\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02DF-0000-B516-3665B2535AA7\",\n" +
                                "                        \"channel_name\": \"新建进出场2号道路S235\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.31.86\",\n" +
                                "                \"device_name\": \"新建进出场2号道路S235\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02E0-0000-91DE-15A4671FD87B\",\n" +
                                "                        \"channel_name\": \"新建进出场3号道路S237\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.31.87\",\n" +
                                "                \"device_name\": \"新建进出场3号道路S237\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02E0-0000-BFB7-8B8417E8E134\",\n" +
                                "                        \"channel_name\": \"新建进出场3号道路S238\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.31.89\",\n" +
                                "                \"device_name\": \"新建进出场3号道路S238\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02E1-0000-B0D1-10846F699F24\",\n" +
                                "                        \"channel_name\": \"新建进出口3号道路S240\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.31.93\",\n" +
                                "                \"device_name\": \"新建进出口3号道路S240\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02E1-0000-8752-2AA124039481\",\n" +
                                "                        \"channel_name\": \"新建进出口3号道路S242\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.31.91\",\n" +
                                "                \"device_name\": \"新建进出口3号道路S242\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02E2-0000-8439-0D1828131569\",\n" +
                                "                        \"channel_name\": \"新建进出口3号道路S243\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.31.94\",\n" +
                                "                \"device_name\": \"新建进出口3号道路S243\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02E2-0000-B932-E357665D082D\",\n" +
                                "                        \"channel_name\": \"新路下坡2S215\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.31.85\",\n" +
                                "                \"device_name\": \"新路下坡2S215\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02E2-0000-824A-E32E953306B1\",\n" +
                                "                        \"channel_name\": \"新路下坡（一）S214\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.31.83\",\n" +
                                "                \"device_name\": \"新路下坡（一）S214\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02E3-0000-A424-762277611DA0\",\n" +
                                "                        \"channel_name\": \"一号截洪沟起点S701\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.31.135\",\n" +
                                "                \"device_name\": \"一号截洪沟起点S701\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02E3-0000-BD2D-C50C5C21BBAE\",\n" +
                                "                        \"channel_name\": \"一号截洪沟垃圾挡坝北侧S702\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.31.130\",\n" +
                                "                \"device_name\": \"一号截洪沟垃圾挡坝北侧S702\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02E4-0000-83B3-A046DD123452\",\n" +
                                "                        \"channel_name\": \"一号污泥坑S205\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.31.58\",\n" +
                                "                \"device_name\": \"一号污泥坑S205\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02E4-0000-9EA8-9713E120D525\",\n" +
                                "                        \"channel_name\": \"一号截洪沟首端平台S217\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.31.102\",\n" +
                                "                \"device_name\": \"一号截洪沟首端平台S217\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02E5-0000-912B-942FAFC174B6\",\n" +
                                "                        \"channel_name\": \"一期封场区南侧S204\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.31.53\",\n" +
                                "                \"device_name\": \"一期封场区南侧S204\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02E5-0000-966E-A407D5BC0126\",\n" +
                                "                        \"channel_name\": \"一号污泥坑西北三叉路口S206\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.31.63\",\n" +
                                "                \"device_name\": \"一号污泥坑西北三叉路口S206\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02E6-0000-84EC-273BE9174A63\",\n" +
                                "                        \"channel_name\": \"主干道路S126\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.30.104\",\n" +
                                "                \"device_name\": \"主干道路S126\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02E7-0000-ACCC-0D3F1C6F2C6E\",\n" +
                                "                        \"channel_name\": \"主干道路S142\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.30.122\",\n" +
                                "                \"device_name\": \"主干道路S142\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02E7-0000-989D-CAD1B4B55E97\",\n" +
                                "                        \"channel_name\": \"主干道路S143\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.30.123\",\n" +
                                "                \"device_name\": \"主干道路S143\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA441-02E8-0000-9F56-CC7C636BAD64\",\n" +
                                "                        \"channel_name\": \"主路末端前三叉路口S203\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.31.52\",\n" +
                                "                \"device_name\": \"主路末端前三叉路口S203\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"channel_list\": [\n" +
                                "                    {\n" +
                                "                        \"channel_code\": \"646CA4C4-00E0-0000-9C52-61B6E1406ECA\",\n" +
                                "                        \"channel_name\": \"3号竖井前s103\",\n" +
                                "                        \"status\": \"online\"\n" +
                                "                    }\n" +
                                "                ],\n" +
                                "                \"device_ip\": \"192.168.30.51\",\n" +
                                "                \"device_name\": \"3号竖井前s103\"\n" +
                                "            }\n" +
                                "        ]\n" +
                                "    }\n" +
                                "}";



    @Data
    public static  class Channel
    {
        private String channel_code;

        private String  channel_name;

        private String status;
    }

    @Data
    public static class Device
    {
        private String device_ip;

        private String device_name;

        private List<Channel> channel_list;
    }

//    public static void main(String[] args)
//    {
//        JSONArray jrr =  JSON.parseObject(json).getJSONObject("data").getJSONArray("device_list");
//        System.out.println(jrr);
//
//        List<Device> list = jrr.toJavaList(Device.class);
//        System.out.println(list);
//
//    }

        public static void main(String[] args)
        {
            LocalDateTime n = LocalDateTime.now();
            long b=  n.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
            System.out.println("n:"+System.currentTimeMillis());
            System.out.println("b："+b);
        }

}
