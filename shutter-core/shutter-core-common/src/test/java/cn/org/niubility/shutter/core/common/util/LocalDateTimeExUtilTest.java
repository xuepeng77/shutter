package cn.org.niubility.shutter.core.common.util;


import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Duration;

/**
 * LocalDateTimeExUtilTest的单元测试类。
 *
 * @author xuepeng
 */
@RunWith(SpringRunner.class)
@SpringBootTest()
@Slf4j
public class LocalDateTimeExUtilTest {

    @Test
    public void test_nowToMidnight_success() {
        Duration duration = LocalDateTimeExUtil.nowToMidnight();
        Assert.assertTrue(duration.getSeconds() > 0);
    }

}
