package com.ziyou.server;

import com.ziyou.core.constants.SafConstant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author libo
 * @date 2023/10/27
 */

@SpringBootApplication(scanBasePackages = SafConstant.BASE_COMPONENT_SCAN_PATH)
@ServletComponentScan(basePackages = SafConstant.BASE_COMPONENT_SCAN_PATH)
@RestController
public class SafServerLauncher {
    public static void main(String[] args) {
        SpringApplication.run(SafServerLauncher.class);
    }

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}
