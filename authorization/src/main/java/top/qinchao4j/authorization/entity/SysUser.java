package top.qinchao4j.authorization.entity;

import lombok.Getter;
import lombok.Setter;
import top.qinchao4j.common.mybatisplus.BaseEntity;

/**
 * Description
 *
 * @author djdgt
 * @since 2023/3/28 11:02
 */
@Getter
@Setter
public class SysUser extends BaseEntity {

    private String username;
    private String password;
    private String realName;
    private String phoneNumber;
    private Boolean enabled;

}
