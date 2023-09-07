package ShoppingApp.ShopKaro.Security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class Security {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select username,password,status from users where username=?"
        );
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select username,role from roles where username=?"
        );
        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity https) throws Exception {
        https.authorizeHttpRequests(configurer ->
                       configurer
                               .antMatchers(HttpMethod.GET, "/shopkaro/").permitAll()
                               .antMatchers(HttpMethod.POST,"/shopkaro/signup").permitAll()
                               .antMatchers(HttpMethod.GET, "/admin/shopkaro/**").hasRole("ADMIN")
                               .antMatchers(HttpMethod.DELETE,"/admin/shopkaro/**").hasRole("ADMIN")
                               .antMatchers(HttpMethod.PUT,"/admin/shopkaro/**").hasRole("ADMIN")
                               .antMatchers(HttpMethod.POST,"/admin/shopkaro/**").hasRole("ADMIN")
                               .antMatchers(HttpMethod.GET, "/shopkaro/**").hasAnyRole("CUSTOMER","ADMIN")
                               .antMatchers(HttpMethod.DELETE,"/shopkaro/**").hasAnyRole("CUSTOMER","ADMIN")
                               .antMatchers(HttpMethod.PUT,"/shopkaro/**").hasAnyRole("CUSTOMER","ADMIN")
                               .antMatchers(HttpMethod.POST,"/shopkaro/**").hasAnyRole("CUSTOMER","ADMIN")

        );

        https.httpBasic(Customizer.withDefaults());
        https.csrf(csrf -> csrf.disable());
        return https.build();
    }
}
