package com.atguigu.springcloud;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 服务监控
 * 访问路径：http://localhost:9002/hystrix
 * 查看每个服务的监控：http://hystrix-app:port/hystrix.stream，如8001：http://localhost:8001/hystrix.stream
 */
@SpringBootApplication
@EnableHystrixDashboard
public class DeptConsumer_DashBoard_App
{
	public static void main(String[] args)
	{
		SpringApplication.run(DeptConsumer_DashBoard_App.class, args);
	}
}
