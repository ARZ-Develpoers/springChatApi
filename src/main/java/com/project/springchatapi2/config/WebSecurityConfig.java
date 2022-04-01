package com.project.springchatapi2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * @author  sym
     * @Date  2022-04-01
     * @Description  /chat url 접근은 USER 만 가능하도록 처리 
    **/
    
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
            .csrf().disable()
                .headers()
                .frameOptions().sameOrigin()
                .and()
                .formLogin()
                .and()
                .authorizeRequests()
                .antMatchers("/chat/**").hasRole("USER")
                .anyRequest().permitAll();
    }

    /**
     * @author  sym
     * @Date  2022-04-01
     * @Description 메모리 방식으로 로그인 인증 처리
    **/
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("root")
                .password("{noop}1234")
                .roles("USER")
                .and()
                .withUser("root2")
                .password("{noop}1234")
                .roles("USER")
                .and()
                .withUser("jeongeun")
                .password("{noop}1234")
                .roles("USER")
                .and()
                .withUser("guest")
                .password("{noop}1234")
                .roles("GUEST");
    }
}
