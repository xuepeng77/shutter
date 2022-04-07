package cn.org.shutter.app.console;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Shutter Console 工程的启动类。
 *
 * @author xuepeng
 */
@SpringBootApplication
@ComponentScan("cn.org.shutter.*")
public class ConsoleApplication {

    /**
     * 启动Shutter Console工程。
     *
     * @param args 启动参数。
     */
    public static void main(String[] args) {
        SpringApplication.run(ConsoleApplication.class, args);
    }

}
