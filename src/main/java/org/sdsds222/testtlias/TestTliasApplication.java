package org.sdsds222.testtlias;

import org.dom4j.io.SAXReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;


@ServletComponentScan
@SpringBootApplication
public class TestTliasApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestTliasApplication.class, args);
    }
}
