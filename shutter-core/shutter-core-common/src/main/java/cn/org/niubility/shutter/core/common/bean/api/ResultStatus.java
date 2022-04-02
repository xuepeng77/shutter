package cn.org.niubility.shutter.core.common.bean.api;

/**
 * Result状态接口。
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
