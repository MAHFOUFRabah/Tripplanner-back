package org.sid.sec;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//	http.authorizeRequests().antMatchers(HttpMethod.GET, "/categories/**").permitAll();
//	http.authorizeRequests().antMatchers(HttpMethod.GET, "/products/**").permitAll();
//	http.authorizeRequests().antMatchers("/categories/***").hasAnyAuthority("ADMIN");
//	http.authorizeRequests().antMatchers("/products/***").hasAnyAuthority("USER");
        http.authorizeRequests().antMatchers("/allTrips/***").hasAnyAuthority("USER");
        http.authorizeRequests().antMatchers("/allItems/***").hasAnyAuthority("USER");
        http.authorizeRequests().antMatchers("/oneTrip/***").hasAnyAuthority("USER");
        http.authorizeRequests().antMatchers("/oneItem/***").hasAnyAuthority("USER");

        http.authorizeRequests().anyRequest().authenticated();
        http.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

    }

}
