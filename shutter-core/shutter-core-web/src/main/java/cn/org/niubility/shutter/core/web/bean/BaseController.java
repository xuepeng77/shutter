package cn.org.niubility.shutter.core.web.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Controller的基类。
 * 封装了Controller中常用的方法。
 *
 * @author xuepeng
 */
@RestController
public class BaseController {

    /**
     * @return 获取HttpServletRequest对象。
     */
    public HttpServletRequest getHttpServletRequest() {
        return httpServletRequest;
    }

    /**
     * 自动装配HttpServletRequest对象。
     *
     * @param httpServletRequest HttpServletRequest对象。
     */
    @Autowired
    public void setHttpServletRequest(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }

    /**
     * HttpServletRequest对象。
     */
    private HttpServletRequest httpServletRequest;


}
