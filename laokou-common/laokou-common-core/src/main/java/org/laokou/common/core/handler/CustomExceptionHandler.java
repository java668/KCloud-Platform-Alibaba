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
package org.laokou.common.core.handler;
import org.laokou.common.i18n.core.CustomException;
import org.laokou.common.i18n.core.HttpResult;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author laokou
 */
@RestControllerAdvice
@ResponseBody
@Component
public class CustomExceptionHandler {
	/**
	 *
	 * 处理自定义异常
	 */
	@ExceptionHandler({CustomException.class})
	public HttpResult<?> handleRenException(CustomException ex){
		return new HttpResult<>().error(ex.getCode(),ex.getMsg());
	}

}
