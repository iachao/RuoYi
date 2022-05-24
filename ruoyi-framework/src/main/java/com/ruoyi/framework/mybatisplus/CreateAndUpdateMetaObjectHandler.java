package com.ruoyi.framework.mybatisplus;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.ruoyi.common.utils.ShiroUtils;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.util.ObjectUtils;

import java.util.Date;

/**
 * MP注入处理器
 *
 **/
public class CreateAndUpdateMetaObjectHandler implements MetaObjectHandler {
    
    @Override
    public void insertFill(MetaObject metaObject) {
        //根据属性名字设置要填充的值
        if (metaObject.hasGetter("createTime")) {
            if (ObjectUtils.isEmpty(metaObject.getValue("createTime"))) {
                this.setFieldValByName("createTime", new Date(), metaObject);
            }
        }
        if (metaObject.hasGetter("createBy")) {
            if (ObjectUtils.isEmpty(metaObject.getValue("createBy"))) {
                this.setFieldValByName("createBy", ShiroUtils.getLoginName(), metaObject);
            }
        }
    }
    
    @Override
    public void updateFill(MetaObject metaObject) {
        if (metaObject.hasGetter("updateBy")) {
            if (ObjectUtils.isEmpty(metaObject.getValue("updateBy"))) {
                this.setFieldValByName("updateBy", ShiroUtils.getLoginName(), metaObject);
            }
        }
        if (metaObject.hasGetter("updateTime")) {
            if (ObjectUtils.isEmpty(metaObject.getValue("updateTime"))) {
                this.setFieldValByName("updateTime", new Date(), metaObject);
            }
        }
    }
}
