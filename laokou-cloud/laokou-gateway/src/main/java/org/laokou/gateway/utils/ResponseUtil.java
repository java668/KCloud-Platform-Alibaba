/**
 * Copyright (c) 2022 KCloud-Platform-Alibaba Authors. All Rights Reserved.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.laokou.gateway.utils;
import org.laokou.common.core.constant.Constant;
import org.laokou.common.core.utils.JacksonUtil;
import org.laokou.common.i18n.utils.StringUtil;
import org.laokou.common.i18n.core.HttpResult;
import org.laokou.gateway.constant.GatewayConstant;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.nio.charset.StandardCharsets;
import java.util.Set;

/**
 * 响应工具
 * @author laokou
 */
public class ResponseUtil {

    /**
     * 拥有uri匹配
     */
    private static final AntPathMatcher ANT_PATH_MATCHER = new AntPathMatcher();

    /**
     * 前端响应
     * @param exchange exchange对象
     * @param data 数据
     */
    public static Mono<Void> response(ServerWebExchange exchange, Object data){
        DataBuffer buffer = exchange.getResponse().bufferFactory().wrap(JacksonUtil.toJsonStr(data).getBytes(StandardCharsets.UTF_8));
        ServerHttpResponse response = exchange.getResponse();
        response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
        response.setStatusCode(HttpStatus.OK);
        return response.writeWith(Flux.just(buffer));
    }

    /**
     * map响应体
     * @param code 响应编码
     * @param msg 响应信息
     */
    public static HttpResult<?> response(int code,String msg) {
       return new HttpResult<>().error(code,msg);
    }

    /**
     * 获取错误map集合
     * @param code 错误码
     */
    public static HttpResult<?> error(int code) {
        return new HttpResult<>().error(code);
    }

    /**
     * 获取token
     * @param request 请求对象
     */
    public static String getToken(ServerHttpRequest request){
        //从header中获取token
        String token = request.getHeaders().getFirst(Constant.AUTHORIZATION_HEAD);
        //如果header中不存在Authorization，则从参数中获取Authorization
        if(StringUtil.isEmpty(token)){
            token = request.getQueryParams().getFirst(Constant.AUTHORIZATION_HEAD);
        }
        return StringUtil.isEmpty(token) ? "" : token.trim();
    }

    /**
     * 获取userId
     * @param request 请求对象
     */
    public static String getUserId(ServerHttpRequest request){
        //从header中获取userId
        String userId = request.getHeaders().getFirst(GatewayConstant.REQUEST_USER_ID);
        //如果header中不存在userId，则从参数中获取userId
        if(StringUtil.isEmpty(userId)){
            userId = request.getQueryParams().getFirst(GatewayConstant.REQUEST_USER_ID);
        }
        return StringUtil.isEmpty(userId) ? "" : userId.trim();
    }


    /**
     * 获取username
     * @param request 请求对象
     */
    public static String getUsername(ServerHttpRequest request){
        // 从header中获取username
        String username = request.getHeaders().getFirst(GatewayConstant.REQUEST_USER_NAME);
        // 如果header中不存在username，则从参数中获取username
        if(StringUtil.isEmpty(username)){
            username = request.getQueryParams().getFirst(GatewayConstant.REQUEST_USER_NAME);
        }
        return StringUtil.isEmpty(username) ? "" : username.trim();
    }

    /**
     * 获取tenantId
     * @param request 请求对象
     */
    public static String getTenantId(ServerHttpRequest request){
        // 从header中获取tenantId
        String tenantId = request.getHeaders().getFirst(GatewayConstant.REQUEST_TENANT_ID);
        // 如果header中不存在tenantId，则从参数中获取tenantId
        if(StringUtil.isEmpty(tenantId)){
            tenantId = request.getQueryParams().getFirst(GatewayConstant.REQUEST_TENANT_ID);
        }
        return StringUtil.isEmpty(tenantId) ? "" : tenantId.trim();
    }

    /**
     * uri匹配
     * @param requestUri 请求uri
     * @param uris 忽略uris
     */
    public static boolean pathMatcher(String requestUri, Set<String> uris) {
        for (String url : uris) {
            if (ANT_PATH_MATCHER.match(url, requestUri)) {
                return true;
            }
        }
        return false;
    }

}
