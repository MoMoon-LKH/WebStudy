package kr.or.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({DBConfig.class})
@ComponentScan(basePackages = {"kr.or.dao"})
public class ApplicationConfig {

}
