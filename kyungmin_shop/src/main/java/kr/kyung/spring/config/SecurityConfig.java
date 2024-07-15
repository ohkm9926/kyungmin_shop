package kr.kyung.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import jakarta.annotation.security.PermitAll;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain fillerChain(HttpSecurity http ) throws Exception{
		  http
		  .formLogin(login -> login
                  .loginPage("/member/login")	// [A] 커스텀 로그인 페이지 지정
                  .defaultSuccessUrl("/")
                  .usernameParameter("email")// [C] submit할 아이디
                 .failureUrl("/member/login/error")
                
                
                  );
		  
		 http	
		 .logout((logout) -> logout
                 .logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
                 .logoutSuccessUrl("/")
                 .invalidateHttpSession(true));
		 
		 http.authorizeHttpRequests(auth -> auth
				 .requestMatchers("/css/**" , "/js/**").permitAll()
		         .requestMatchers("/" , "/member/**", "/item/**").permitAll()
		         .requestMatchers("/admin/**" ).hasRole("ADMIN")
		         .anyRequest().authenticated()
		 );
		 
		 http.exceptionHandling((exceptionConfig) ->
			exceptionConfig.authenticationEntryPoint(new CustomEntryPoint())
			);
         return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
