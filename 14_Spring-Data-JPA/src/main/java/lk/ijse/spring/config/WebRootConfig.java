package lk.ijse.spring.config;

import lk.ijse.spring.service.CustomerServiceImpl;
import lk.ijse.spring.service.ItemServiceImpl;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({JPAConfig.class})
@ComponentScan(basePackageClasses = {CustomerServiceImpl.class, ItemServiceImpl.class})
public class WebRootConfig {
}
