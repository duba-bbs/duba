package com.tingyu.duba.gen;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import com.tingyu.duba.common.security.annotation.EnableCustomConfig;
import com.tingyu.duba.common.security.annotation.EnableDubaFeignClients;
import com.tingyu.duba.common.swagger.annotation.EnableCustomSwagger2;

/**
 * 代码生成
 */
@EnableCustomConfig
@EnableCustomSwagger2
@EnableDubaFeignClients
@SpringCloudApplication
public class DubaGenApplication {
    public static void main(String[] args) {
        SpringApplication.run(DubaGenApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  代码生成模块启动成功   ლ(´ڡ`ლ)ﾞ  \n" + " .-------.       ____     __        \n"
                + " |  _ _   \\      \\   \\   /  /    \n" + " | ( ' )  |       \\  _. /  '       \n"
                + " |(_ o _) /        _( )_ .'         \n" + " | (_,_).' __  ___(_ o _)'          \n"
                + " |  |\\ \\  |  ||   |(_,_)'         \n" + " |  | \\ `'   /|   `-'  /           \n"
                + " |  |  \\    /  \\      /           \n" + " ''-'   `'-'    `-..-'              ");
    }
}
