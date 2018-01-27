package com.example.demo.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationManager;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

@Configuration
@EnableWebSecurity
public class ResourceConfiguration extends WebSecurityConfigurerAdapter {

    @Bean
    public RemoteTokenServices tokenService() {

        RemoteTokenServices tokenService = new RemoteTokenServices();

        tokenService.setCheckTokenEndpointUrl(
                "http://localhost:9000/oauth/check_token");
        tokenService.setClientId("clientapp");
        tokenService.setClientSecret("123456");

        return tokenService;
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        OAuth2AuthenticationManager authenticationManager = new OAuth2AuthenticationManager();
        authenticationManager.setTokenServices(tokenService());
        return authenticationManager;
    }
}
