package top.qinchao4j.integration.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
@Slf4j
public class DefaultSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(matcherRegistry ->
                        matcherRegistry
                                // 测试权限：api/test为TEST角色权限，api/system为SYSTEM角色权限
                                .requestMatchers("/api/test").hasAnyRole("TEST")
                                .requestMatchers("/api/system").hasAnyRole("SYSTEM")
                                // 静态资源放行
                                .requestMatchers("/assets/**").permitAll()
                                // 其他资源要认证
                                .anyRequest()
                                .authenticated())
                .formLogin(configurer ->
                        configurer
                                // 自定义登录页面地址
                                .loginPage("/login.html")
                                // 登录接口（后端不用实现）
                                .loginProcessingUrl("/login")
                                // 成功后跳转页面
                                .successForwardUrl("/loginSuccess")
                                // 登录相关的请求放行
                                .permitAll())
                .logout(configurer -> configurer.logoutUrl("/logout"))
                .csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }

}
