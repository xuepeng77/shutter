package cn.org.niubility.shutter.core.web.util;

import cn.org.niubility.shutter.core.common.consts.PunctuationConst;
import cn.org.niubility.shutter.core.web.consts.IPConst;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Web的工具类。
 *
 * @author xuepeng
 */
public class IPUtil {

    /**
     * 构造函数。
     */
    private IPUtil() {
    }

    /**
     * 获取真实IP。
     *
     * @param request HttpServletRequest。
     * @return 真实IP。
     */
    public static String getIPAddress(final HttpServletRequest request) {
        String ip = request.getHeader(IPConst.X_FORWARDED_FOR);
        if (StringUtils.isNotEmpty(ip)
                && !IPConst.UNKNOWN.equalsIgnoreCase(ip)) {
            // 多次反向代理后会有多个ip值，第一个ip才是真实ip
            ip = ip.split(PunctuationConst.COMMA)[0].split(PunctuationConst.COLON)[0];
        }
        return doGetIPAddress(ip, request);
    }

    /**
     * 获取真实IP。
     *
     * @param ip      IP地址。
     * @param request HttpServletRequest。
     * @return 真实IP。
     */
    private static String doGetIPAddress(String ip, final HttpServletRequest request) {
        if (StringUtils.isEmpty(ip) || IPConst.UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader(IPConst.PROXY_CLIENT_IP);
        }
        if (StringUtils.isEmpty(ip) || IPConst.UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader(IPConst.WL_PROXY_CLIENT_IP);
        }
        if (StringUtils.isEmpty(ip) || IPConst.UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader(IPConst.HTTP_CLIENT_IP);
        }
        if (StringUtils.isEmpty(ip) || IPConst.UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader(IPConst.HTTP_X_FORWARDED_FOR);
        }
        if (StringUtils.isEmpty(ip) || IPConst.UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader(IPConst.X_REAL_IP);
        }
        if (StringUtils.isEmpty(ip) || IPConst.UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (StringUtils.equalsAny(
                ip,
                IPConst.LOCALHOST,
                IPConst.LOCALHOST_IP,
                IPConst.LOCALHOST_IPV6)
        ) {
            try {
                ip = InetAddress.getLocalHost().getHostAddress();
            } catch (UnknownHostException e) {
                return ip;
            }
        }
        return ip;
    }

}
