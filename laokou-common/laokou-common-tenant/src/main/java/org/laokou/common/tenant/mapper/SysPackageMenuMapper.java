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
package org.laokou.common.tenant.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.laokou.common.mybatisplus.mapper.BatchMapper;
import org.laokou.common.tenant.entity.SysPackageMenuDO;
import org.springframework.stereotype.Repository;
/**
 * @author laokou
 */
@Mapper
@Repository
public interface SysPackageMenuMapper extends BaseMapper<SysPackageMenuDO>, BatchMapper<SysPackageMenuDO> {

}
