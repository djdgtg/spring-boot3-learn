package top.qinchao4j.authorization.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import top.qinchao4j.authorization.entity.SysUser;
import top.qinchao4j.authorization.mapper.SysUserMapper;

import java.util.List;

/**
 * Description
 *
 * @author djdgt
 * @since 2023/5/10 15:22
 */
@Service
@AllArgsConstructor
public class SysUserServiceImpl implements UserDetailsService {

    private final SysUserMapper sysUserMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = sysUserMapper.selectOne(new LambdaQueryWrapper<SysUser>().eq(SysUser::getUsername, username));
        if (sysUser == null) {
            throw new UsernameNotFoundException("用户名或者密码不正确");
        }
        List<String> roles = sysUserMapper.getRolesById(sysUser.getId());
        return User.withUsername(username).password(sysUser.getPassword()).roles(roles.toArray(new String[]{})).build();
    }
}
