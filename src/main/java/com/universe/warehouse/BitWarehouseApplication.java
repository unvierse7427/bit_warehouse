package com.universe.warehouse;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication(scanBasePackages = {"com.universe.warehouse"})
@MapperScan({"com.universe.warehouse"})
public class BitWarehouseApplication {

    public static void main(String[] args) {
        SpringApplication.run(BitWarehouseApplication.class, args);
    }

}
