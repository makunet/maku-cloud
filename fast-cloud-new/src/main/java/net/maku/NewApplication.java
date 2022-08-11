package net.maku;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 新增模块演示
 *
 * @author 阿沐 babamu@126.com
 */
@EnableDiscoveryClient
@SpringBootApplication
public class NewApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewApplication.class, args);
	}

}