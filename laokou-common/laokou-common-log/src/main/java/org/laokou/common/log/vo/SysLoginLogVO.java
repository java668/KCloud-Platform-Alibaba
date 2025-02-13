/**
 * Copyright (c) 2022 KCloud-Platform-Alibaba Authors. All Rights Reserved.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 *   http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.laokou.common.log.vo;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
/**
 * @author laokou
 */
@Data
public class SysLoginLogVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 4351525994459806638L;
    private Long id;
    /**
     * 登录用户
     */
    private String loginName;

    /**
     * IP地址
     */
    private String requestIp;
    /**
     * 归属地
     */
    private String requestAddress;

    /**
     * 浏览器版本
     */
    private String browser;

    /**
     * 操作系统
     */
    private String os;

    /**
     * 状态  0：成功   1：失败
     */
    private Integer requestStatus;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 登录时间
     */
    private LocalDateTime createDate;
}
