package cn.org.niubility.shutter.core.web.log;

/**
 * API日志类型的枚举。
 *
 * @author xuepeng
 */
public enum ApiLogAction {

    /**
     * 其它
     */
    OTHER,
    /**
     * 创建
     */
    CREATE,
    /**
     * 修改
     */
    UPDATE,
    /**
     * 删除
     */
    DELETE,
    /**
     * 查询
     */
    QUERY,
    /**
     * 详情
     */
    DETAIL,
    /**
     * 树
     */
    TREE,
    /**
     * 导入
     */
    IMPORT,
    /**
     * 导出
     */
    EXPORT,
    /**
     * 授权
     */
    GRANT,
    /**
     * 强退
     */
    FORCE,
    /**
     * 修改状态
     */
    CHANGE,
    /**
     * 登录
     */
    LOGIN,
    /**
     * 登出
     */
    LOGOUT

}
