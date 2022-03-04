package cn.org.niubility.shutter.app.console;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Shutter Console 工程的启动类。
 *
 * @author xuepeng
 */
@SpringBootApplication
@ComponentScan("cn.org.niubility.*")
public class ConsoleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsoleApplication.class, args);
    }

}
