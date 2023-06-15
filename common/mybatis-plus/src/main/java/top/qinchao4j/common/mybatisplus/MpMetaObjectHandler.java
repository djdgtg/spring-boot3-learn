package top.qinchao4j.common.mybatisplus;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.AllArgsConstructor;
import org.apache.ibatis.reflection.MetaObject;
import top.qinchao4j.base.service.LoginUserService;

import java.time.LocalDateTime;

@AllArgsConstructor
public class MpMetaObjectHandler implements MetaObjectHandler {

    private final LoginUserService loginUserService;

    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createTime", LocalDateTime.now(), metaObject);
        this.setFieldValByName("createBy", loginUserService.getCurrentUserId(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
        this.setFieldValByName("updateBy", loginUserService.getCurrentUserId(), metaObject);
    }
}
