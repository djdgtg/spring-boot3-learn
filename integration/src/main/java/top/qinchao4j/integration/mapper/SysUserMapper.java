package top.qinchao4j.integration.mapper;


import top.qinchao4j.common.mybatisplus.MpBaseMapper;
import top.qinchao4j.integration.entity.SysUser;

import java.util.List;

/**
 * Description
 *
 * @author djdgt
 * @since 2023/3/28 11:03
 */
public interface SysUserMapper extends MpBaseMapper<SysUser> {
    List<String> getRolesById(Integer id);
}
