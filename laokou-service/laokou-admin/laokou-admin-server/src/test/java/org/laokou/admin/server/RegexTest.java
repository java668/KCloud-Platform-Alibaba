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

package org.laokou.admin.server;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.laokou.common.i18n.utils.ValidatorUtil;
import org.laokou.common.tenant.dto.SysSourceDTO;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author laokou
 */
@Slf4j
@SpringBootTest(classes = AdminApplication.class)
public class RegexTest {

    @Test
    public void test() {
        SysSourceDTO dto = new SysSourceDTO();
        dto.setName("啊啊啊1");
        dto.setDriverClassName("ee");
        dto.setUrl("ww");
        dto.setUsername("ddd");
        dto.setPassword("33");
        ValidatorUtil.validateEntity(dto);
    }

}
