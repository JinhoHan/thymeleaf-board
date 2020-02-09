package com.acma.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic()
			.and().authorizeRequests().anyRequest().permitAll()
			.and().cors().configurationSource(this.corsConfigurationSource())
			.and().csrf().disable();
	}
	
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		// CORS 요청을 허용할 사이트
		configuration.addAllowedOrigin(CorsConfiguration.ALL);
		// CORS 요청을 허용할 Http Method들 (ex. GET,PUT,POST)
		configuration.addAllowedMethod(CorsConfiguration.ALL);
		// 특정 헤더를 가진 경우에만 CORS 요청을 허용할 경우
		configuration.addAllowedHeader(CorsConfiguration.ALL);
		// 자격증명과 함께 요청을 할 수 있는지 여부(해당 서버에서 Authorization로 사용자 인증도 서비스할 것이라면 true로 응답)
		configuration.setAllowCredentials(false);
		// preflight 요청의 캐시 시간
		configuration.setMaxAge(3600L);
		
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		
		return source;
	}
}