package com.example.hello.shiro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author zhangjinpei at 2021/01/25 10:20:21
 * bootstrap tutorial: https://www.runoob.com/bootstrap/bootstrap-tables.html
 * Twitter quick start: https://getbootstrap.com/
 * Bootstrat 可视化布局 : https://www.runoob.com/try/bootstrap/layoutit/
 */
@SpringBootApplication
public class HelloShiroApplication extends WebMvcConfigurationSupport {

    public static void main(String[] args) {
        SpringApplication.run(HelloShiroApplication.class, args);
    }

	/**
	 * 这里配置静态资源文件的路径导包都是默认的直接导入就可以
	 * @param registry object
	 */
	@Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/static/");
        super.addResourceHandlers(registry);
    }
}
