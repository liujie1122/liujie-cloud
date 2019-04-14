package com.liujie;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableEurekaClient
@SpringBootApplication
//@Configuration
@EnableAutoConfiguration
@EnableAdminServer
public class AdminClient2Application {

	public static void main(String[] args) {
		SpringApplication.run(AdminClient2Application.class, args);
	}

//	@Configuration
//	public static class SecuritySecureConfig extends WebSecurityConfigurerAdapter {
//		private final String adminContextPath;
//
//		public SecuritySecureConfig(AdminServerProperties adminServerProperties) {
//			this.adminContextPath = adminServerProperties.getContextPath();
//		}
//
//		@Override
//		protected void configure(HttpSecurity http) throws Exception {
//			// @formatter:off
//			SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
//			successHandler.setTargetUrlParameter("redirectTo");
//
//			http.authorizeRequests()
//					.antMatchers(adminContextPath + "/assets/**").permitAll()
//					.antMatchers(adminContextPath + "/login").permitAll()
//					.anyRequest().authenticated()
//					.and()
//					.formLogin().loginPage(adminContextPath + "/login").successHandler(successHandler).and()
//					.logout().logoutUrl(adminContextPath + "/logout").and()
//					.httpBasic().and()
//					.csrf().disable();
//			// @formatter:on
//		}
//	}
}
