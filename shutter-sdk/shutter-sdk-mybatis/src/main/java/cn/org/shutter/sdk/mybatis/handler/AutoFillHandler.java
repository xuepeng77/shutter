package cn.org.shutter.sdk.mybatis.handler;

import cn.org.shutter.sdk.mybatis.consts.ColumnConst;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * ORM自动填充的处理类。
 *
 * @author xuepeng
 */
@Component
@Slf4j
public class AutoFillHandler implements MetaObjectHandler {

    /**
     * 新增时的自动填充逻辑。
     *
     * @param metaObject 元数据。
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        if (log.isDebugEnabled()) {
            log.debug("执行MybatisPlus的insertFill功能。");
        }
        this.strictInsertFill(metaObject, ColumnConst.CREATE_TIME, LocalDateTime::now, LocalDateTime.class);
    }

    /**
     * 修改时的自动填充逻辑。
     *
     * @param metaObject 元数据。
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        if (log.isDebugEnabled()) {
            log.debug("执行MybatisPlus的updateFill功能。");
        }
        this.strictUpdateFill(metaObject, ColumnConst.MODIFY_TIME, LocalDateTime::now, LocalDateTime.class);
    }

}
