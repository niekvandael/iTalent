package be.italent.security;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
 /*       http
                .httpBasic().disable()
                .csrf().disable()
                .authorizeRequests()
                .anyRequest().permitAll();
*/        
        // Disable CSRF explicitly
        http.authorizeRequests().antMatchers("/**").permitAll().and().csrf().disable();

        // @formatter:on
    }
}
