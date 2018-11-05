package com.cnw.traffic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cnw.traffic.dao")//对应项目中mapper（dao）所对应的包路径
public class TrafficApplication {

	public static void main(String[] args) {

		SpringApplication.run(TrafficApplication.class, args);
	}
}
