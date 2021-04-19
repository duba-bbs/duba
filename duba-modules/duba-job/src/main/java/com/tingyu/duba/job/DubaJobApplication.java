package com.tingyu.duba.job;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import com.tingyu.duba.common.security.annotation.EnableCustomConfig;
import com.tingyu.duba.common.security.annotation.EnableDubaFeignClients;
import com.tingyu.duba.common.swagger.annotation.EnableCustomSwagger2;

/**
 * 定时任务
 */
@EnableCustomConfig
@EnableCustomSwagger2
@EnableDubaFeignClients
@SpringCloudApplication
public class DubaJobApplication {
    public static void main(String[] args) {
        SpringApplication.run(DubaJobApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  定时任务模块启动成功   ლ(´ڡ`ლ)ﾞ  \n" + " .-------.       ____     __        \n"
                + " |  _ _   \\      \\   \\   /  /    \n" + " | ( ' )  |       \\  _. /  '       \n"
                + " |(_ o _) /        _( )_ .'         \n" + " | (_,_).' __  ___(_ o _)'          \n"
                + " |  |\\ \\  |  ||   |(_,_)'         \n" + " |  | \\ `'   /|   `-'  /           \n"
                + " |  |  \\    /  \\      /           \n" + " ''-'   `'-'    `-..-'              ");
    }
}
