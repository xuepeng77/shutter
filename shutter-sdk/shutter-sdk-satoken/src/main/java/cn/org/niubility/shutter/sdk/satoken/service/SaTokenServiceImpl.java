package cn.org.niubility.shutter.sdk.satoken.service;

import cn.dev33.satoken.stp.StpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * SaToken的业务处理实现类。
 * 实现了AuthService接口，为ApiLog提供获取登录用户能力。
 */
@Component
@Slf4j
public class SaTokenServiceImpl implements SaTokenService {

    /**
     * @return 判断是否登录。
     */
    @Override
    public boolean isLogin() {
        return StpUtil.isLogin();
    }

    /**
     * @return 获取当前登录人主键。
     */
    @Override
    public long getCurrentUserId() {
        return StpUtil.getLoginIdAsLong();
    }

}
