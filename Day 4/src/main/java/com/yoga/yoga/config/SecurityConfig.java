package com.yoga.yoga.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.authentication.AuthenticationProvider;

// import org.springframework.web.cors.CorsConfiguration;
// import org.springframework.web.cors.CorsConfigurationSource;
// import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

// import com.yoga.yoga.constant.Api;

// import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
// import springfox.documentation.swagger2.annotations.EnableSwagger2;
import lombok.RequiredArgsConstructor;
import com.yoga.yoga.constant.Api;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

	private final JwtAuthenticationFilter jwtAuthenticationFilter;
	private final AuthenticationProvider authenticationProvider;

	private static final String[] PublicEndPoints = {
			// "/api/web/",
			// "/api/sample/",
			// "/v3/api-docs/",
			// "/swagger-resources",
			// "/swagger-resources/",
			// "configuration/ui",
			// "/configuration/security",
			// "/v2/api-docs",
			// "/swagger-ui/",
			// "/swagger-ui.html/",
			"/v3/api-docs/",
            "/swagger-ui.html",
			"/swagger-ui/"
	};

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
				.cors(corsConfirguarationSource -> corsConfirguarationSource
						.configurationSource(corsConfigurationSource()))
				.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(authorize -> authorize
						.requestMatchers(PublicEndPoints).permitAll()
						.requestMatchers(Api.AUTH + "/", Api.USER + "/", Api.COURSES + "/", Api.ACADEMIES + "/","/v3/api-docs/",
						"/swagger-ui.html/",
						"/swagger-ui/","/error","/**")
						.permitAll()
						// "/user/","/admin/","/academy/addacademy"
						.anyRequest().authenticated())
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authenticationProvider(authenticationProvider)
				.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
		return httpSecurity.build();
	}

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedHeaders(Api.HEADERS);
		configuration.setAllowCredentials(true);
		configuration.setAllowedMethods(Api.METHODS);
		configuration.setAllowedOrigins(Api.ORIGINS);
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/", configuration);
		return source;
	}
}