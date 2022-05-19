package NHLStore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import NHLStore.interceptor.AdminAuthenticationInterceptor;
import NHLStore.interceptor.CustomerAuthenticationInterceptor;

@Configuration
public class AuthenticationInterceptorConfig implements WebMvcConfigurer{
	@Autowired
	AdminAuthenticationInterceptor adminAuthenticationInterceptor;
	@Autowired
	CustomerAuthenticationInterceptor authenticationInterceptor;
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(adminAuthenticationInterceptor)
			.addPathPatterns("/admin/**");
		registry.addInterceptor(adminAuthenticationInterceptor).addPathPatterns("/customer/cart/**");
	}

}
