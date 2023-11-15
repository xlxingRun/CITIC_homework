package cn.xiaolin.citic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"cn.xiaolin.citic.domain.mapper"})
public class CiticApplication {

    public static void main(String[] args) {
        SpringApplication.run(CiticApplication.class, args);
    }

}
