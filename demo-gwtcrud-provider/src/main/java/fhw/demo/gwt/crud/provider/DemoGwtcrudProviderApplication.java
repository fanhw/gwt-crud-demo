package fhw.demo.gwt.crud.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:dubbo.xml")
@MapperScan("fhw.demo.gwt.crud.provider.mapper")
public class DemoGwtcrudProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoGwtcrudProviderApplication.class, args);
    }

}
