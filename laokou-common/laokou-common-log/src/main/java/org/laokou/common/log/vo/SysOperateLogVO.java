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
public class SysOperateLogVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1872256681096135224L;
    private Long id;
    /**
     * 模块名称，如：系统菜单
     */
    private String module;

    /**
     * 操作名称
     */
    private String operation;

    /**
     * 请求URI
     */
    private String requestUri;

    /**
     * 请求方式
     */
    private String requestMethod;

    /**
     * 请求参数
     */
    private String requestParams;

    /**
     * 浏览器版本
     */
    private String userAgent;

    /**
     * IP地址
     */
    private String requestIp;

    /**
     * 归属地
     */
    private String requestAddress;

    /**
     * 状态  0：成功   1：失败
     */
    private Integer requestStatus;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 错误信息
     */
    private String errorMsg;

    /**
     * 方法名称
     */
    private String methodName;

    /**
     * 操作时间
     */
    private LocalDateTime createDate;

    /**
     * 耗时（毫秒）
     */
    private Long takeTime;

}
