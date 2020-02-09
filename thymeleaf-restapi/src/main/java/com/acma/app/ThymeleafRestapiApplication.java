package com.acma.app;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.acma.app.domain.Board;
import com.acma.app.repository.BoardRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class ThymeleafRestapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThymeleafRestapiApplication.class, args);
		log.info("========= Thymeleaf Back End Start(Rest Api Server) =========");
	}
	
	// config class 로 이동
//	@Configuration
//	@EnableGlobalMethodSecurity(prePostEnabled = true)
//	@EnableWebSecurity
//	static class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//		
//		@Override
//		protected void configure(HttpSecurity http) throws Exception {
//			CorsConfiguration configuration = new CorsConfiguration();
//			// CORS 요청을 허용할 사이트
//			configuration.addAllowedOrigin(CorsConfiguration.ALL);
//			// CORS 요청을 허용할 Http Method들 (ex. GET,PUT,POST)
//			configuration.addAllowedMethod(CorsConfiguration.ALL);
//			// 특정 헤더를 가진 경우에만 CORS 요청을 허용할 경우
//			configuration.addAllowedHeader(CorsConfiguration.ALL);
//			// 자격증명과 함께 요청을 할 수 있는지 여부(해당 서버에서 Authorization로 사용자 인증도 서비스할 것이라면 true로 응답)
//			configuration.setAllowCredentials(false);
//			// preflight 요청의 캐시 시간
//			configuration.setMaxAge(3600L);
//			
//			UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//			source.registerCorsConfiguration("/**", configuration);
//			
//			http.httpBasic()
//				.and().authorizeRequests()
//				.anyRequest().permitAll()
//				.and().cors().configurationSource(source)
//				.and().csrf().disable();
//		}
//	}
	
	@Bean
	public CommandLineRunner runner(BoardRepository boardRepository) throws Exception {
		return (args) -> {
			IntStream.rangeClosed(1, 50).forEach(index -> boardRepository.save(Board.builder()
					.title("Thymeleaf 게시글" + index)
					.content("Thymeleaf 내용" + index)
					.createdDate(LocalDateTime.now())
					.updatedDate(LocalDateTime.now())
					.build())
			);
		};
	}

}
