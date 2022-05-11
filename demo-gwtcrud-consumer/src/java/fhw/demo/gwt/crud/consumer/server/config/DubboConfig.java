//package fhw.demo.gwt.crud.consumer.server.config;
//
//import fhw.demo.crud.api.HandleService;
//import org.apache.dubbo.config.ApplicationConfig;
//import org.apache.dubbo.config.ConsumerConfig;
//import org.apache.dubbo.config.ReferenceConfig;
//import org.apache.dubbo.config.RegistryConfig;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @author fhw
// * @version 1.0
// * @date 2022-05-07 16:39
// */
//
//@Configuration
//public class DubboConfig {
//    @Bean
//    public RegistryConfig registryConfig() {
//        RegistryConfig registryConfig = new RegistryConfig();
//        registryConfig.setAddress("zookeeper://127.0.0.1:2181");
//        return registryConfig;
//    }
//
//    @Bean
//    public ConsumerConfig consumerConfig() {
//        ConsumerConfig consumerConfig = new ConsumerConfig();
//        consumerConfig.setTimeout(1000);
//        return consumerConfig;
//    }
//
//    @Bean
//    public ApplicationConfig applicationConfig() {
//        ApplicationConfig applicationConfig = new ApplicationConfig();
//        applicationConfig.setName("demo-gwtcrud-consumer");
//        return applicationConfig;
//    }
//
//    @Bean("referenceConfig")
//    public ReferenceConfig referenceConfig() {
//        ReferenceConfig<HandleService> referenceConfig = new ReferenceConfig<>();
//        referenceConfig.setVersion("1.0.0");
//        referenceConfig.setInterface(HandleService.class);
//        referenceConfig.setApplication(applicationConfig());
//        referenceConfig.setRegistry(registryConfig());
//        referenceConfig.setConsumer(consumerConfig());
//        return referenceConfig;
//    }
//
//}
