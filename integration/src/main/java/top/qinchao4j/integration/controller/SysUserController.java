package top.qinchao4j.integration.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.qinchao4j.base.bean.CustomException;
import top.qinchao4j.integration.entity.SysUser;
import top.qinchao4j.integration.mapper.SysUserMapper;

/**
 * Description
 *
 * @author djdgt
 * @since 2023/3/28 10:56
 */
@RestController
@RequestMapping("user")
@AllArgsConstructor
public class SysUserController {

    private final SysUserMapper userMapper;

    @GetMapping("{id}")
    public SysUser getById(@PathVariable Integer id) {
        if (id > 100 || id < 1) {
            throw new CustomException("请输入合适用户id");
        }
        return userMapper.selectById(id);
    }
}
