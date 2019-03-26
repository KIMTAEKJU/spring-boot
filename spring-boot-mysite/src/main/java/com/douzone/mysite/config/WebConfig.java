package com.douzone.mysite.config;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.douzone.mysite.security.AuthInterceptor;
import com.douzone.mysite.security.AuthLoginInterceptor;
import com.douzone.mysite.security.AuthLogoutInterceptor;
import com.douzone.mysite.security.AuthUserHandlerMethodArgumentResolver;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

/*
 * WebConfig == spring-servlet.xml 
 * 메세지 컨버터, 뷰 리절브 다 여기서 설정
 */

@Configuration
//@EnableWebMvc // == <mvc:annotation-driven/>
//@ComponentScan(value = { "com.douzone.mysite.controller", "com.douzone.mysite.exception" } )
//@EnableAspectJAutoProxy 이 설정은 application.properties에서 한다
//@Import(value = {InterceptorConfig.class, MVCConfig.class, MessagesConfig.class, FileUploadConfig.class})
//@PropertySource("classpath:fileUpload/multipart.properties")
public class WebConfig implements WebMvcConfigurer 
// 인터페이스가 람다메소드가하나있는 인터페이스들때문에 조금 바뀌어서 그래서 이젠 WebMvcConfigurer를 사용 디폴트 메소드가 구현되어있는 
{
	@Autowired
	private AuthLoginInterceptor authLoginInterceptor;
	
	@Autowired
	private AuthLogoutInterceptor authLogoutInterceptor;
	
	@Autowired
	private AuthInterceptor authInterceptor;
	
	@Autowired
	private AuthUserHandlerMethodArgumentResolver authUserHandlerMethodArgumentResolver;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(authLoginInterceptor)
				.addPathPatterns("/user/auth");
		
		registry.addInterceptor(authLogoutInterceptor)
				.addPathPatterns("/user/logout");
		
		registry.addInterceptor(authInterceptor)
				.addPathPatterns( "/**" )
				.excludePathPatterns( "/user/auth")
				.excludePathPatterns( "/user/logout")
				.excludePathPatterns( "/assets/*");
		
	}
	
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) 
	{
		argumentResolvers.add(authUserHandlerMethodArgumentResolver);
	}
	
	/////////////////////////////////////////////////////////////////////////
	
	@Autowired
	private Environment env;
	
	// Resources Mapping to URL
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		registry.addResourceHandler( "/uploads/images/**" )
		.addResourceLocations( "file:/duzon/uploads/" );
	}
	
	////////////////////////////////////////////////////////////////////////////////////
	
//	@Override
//	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) 
//	{
//		configurer.enable();
//	}

	// Message Converters http://wonwoo.ml/index.php/post/889 참조
	
	@Bean
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter()
	{
		Jackson2ObjectMapperBuilder builder = 
				new Jackson2ObjectMapperBuilder()
					.indentOutput(true)
						.dateFormat(new SimpleDateFormat("yyyy-MM-dd"))
							.modulesToInstall(new ParameterNamesModule());
			
		MappingJackson2HttpMessageConverter converter = 
				new MappingJackson2HttpMessageConverter(builder.build());
		converter.setSupportedMediaTypes( Arrays.asList( new MediaType( "application", "json", Charset.forName("utf-8") ) ) );
		return converter;
	}
	
	@Bean
	public StringHttpMessageConverter stringHttpMessageConverter()
	{
		StringHttpMessageConverter converter = new StringHttpMessageConverter();
		// mediaType으로 값을 넣는건 string으로 발생할수있는 에러를 막기위해
		converter.setSupportedMediaTypes( Arrays.asList( new MediaType( "text", "html", Charset.forName("utf-8") ) ) );
		return converter;
	}
	
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) 
	{
		// 오버라이딩 메소드라서 빈을 여기다가 와이어링할수없음
		// 그래서 메소드를 만들어서 여기에 호출
		converters.add(stringHttpMessageConverter());
		converters.add(mappingJackson2HttpMessageConverter()); // 안에 컨버터을 넣어줌 
		
	}
}
