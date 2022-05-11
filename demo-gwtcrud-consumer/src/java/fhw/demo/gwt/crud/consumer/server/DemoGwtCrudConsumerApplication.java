package fhw.demo.gwt.crud.consumer.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author fhw
 * @version 1.0
 * @date 2022-05-07 09:04
 */
@SpringBootApplication
@ImportResource("classpath:META-INF/dubbo/dubbo.xml")
public class DemoGwtCrudConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoGwtCrudConsumerApplication.class, args);
    }

}
