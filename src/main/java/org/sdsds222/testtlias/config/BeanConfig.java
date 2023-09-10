package org.sdsds222.testtlias.config;

import org.dom4j.io.SAXReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration//配置类
public class BeanConfig {
    //声明第三方Bean，可通过Bean的默认注解指定Bean的名称，否则名称为方法名，自己定义的类用@Component注解即可
    @Bean
    public SAXReader saxReader() {
        return new SAXReader();
    }
}
