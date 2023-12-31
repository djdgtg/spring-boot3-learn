package top.qinchao4j.integration.entity;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "系统用户")
public class SysUser extends BaseEntity {

    @Schema(description = "用户名")
    private String username;
    @Schema(description = "用户密码")
    private String password;
    @Schema(description = "真实姓名")
    private String realName;
    @Schema(description = "手机号码")
    private String phoneNumber;
    @Schema(description = "是否启用")
    private Boolean enabled;

}
