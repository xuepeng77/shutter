package cn.org.niubility.shutter.sdk.orm.handler;

import cn.org.niubility.shutter.sdk.orm.consts.ColumnConst;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * ORM自动填充的处理类。
 *
 * @author xuepeng
 */
@Component
public class AutoFillHandler implements MetaObjectHandler {

    /**
     * 新增时的自动填充逻辑。
     *
     * @param metaObject 元数据。
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, ColumnConst.CREATE_TIME, LocalDateTime::now, LocalDateTime.class);
    }

    /**
     * 修改时的自动填充逻辑。
     *
     * @param metaObject 元数据。
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, ColumnConst.MODIFY_TIME, LocalDateTime::now, LocalDateTime.class);
    }

}
