package dapeng;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@MapperScan("dapeng.mapper")
@EnableDiscoveryClient
@SpringBootApplication
public class ContactProvider8081Application {

	public static void main(String[] args) {
		SpringApplication.run(ContactProvider8081Application.class, args);
	}

}
