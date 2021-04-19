package com.tingyu.duba.system;

import com.tingyu.duba.common.security.annotation.EnableCustomConfig;
import com.tingyu.duba.common.security.annotation.EnableDubaFeignClients;
import com.tingyu.duba.common.swagger.annotation.EnableCustomSwagger2;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 系统模块
 */
@EnableCustomConfig
@EnableCustomSwagger2
@EnableDubaFeignClients
@SpringCloudApplication
@ComponentScan(basePackages = { "com.tingyu.duba.common" })
public class DubaSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(DubaSystemApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  系统模块启动成功   ლ(´ڡ`ლ)ﾞ  \n" + " .-------.       ____     __        \n"
                + " |  _ _   \\      \\   \\   /  /    \n" + " | ( ' )  |       \\  _. /  '       \n"
                + " |(_ o _) /        _( )_ .'         \n" + " | (_,_).' __  ___(_ o _)'          \n"
                + " |  |\\ \\  |  ||   |(_,_)'         \n" + " |  | \\ `'   /|   `-'  /           \n"
                + " |  |  \\    /  \\      /           \n" + " ''-'   `'-'    `-..-'              ");
    }
}
