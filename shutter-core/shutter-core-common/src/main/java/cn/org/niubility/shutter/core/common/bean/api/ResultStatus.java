package cn.org.niubility.shutter.core.common.bean.api;

/**
 * Http请求的响应状态接口。
 *
 * @author xuepeng
 */

public interface ResultStatus {

    /**
     * @return 获得状态编码。
     */
    int getCode();

    /**
     * @return 获得状态描述。
     */
    String getDesc();

}
