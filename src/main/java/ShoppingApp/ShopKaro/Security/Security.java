package ShoppingApp.ShopKaro.Security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class Security {
/*
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(
                config ->
                        config.
                                requestMatchers(HttpMethod.GET,"/api/shopkaro/*").permitAll().requestMatchers(HttpMethod.GET,"/api/shopkaro/admin").permitAll();
        http.csrf( obj -> obj.disable());
                return http.build();
    }*/
}
