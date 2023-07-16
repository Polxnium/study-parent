package com.stu.spring;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDemoApplication implements ApplicationRunner, CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringDemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("ioc初始化后执行 ApplicationRunner.run(ApplicationArguments args)");
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("ioc初始化后执行 CommandLineRunner.run(String... args)");
    }
}
