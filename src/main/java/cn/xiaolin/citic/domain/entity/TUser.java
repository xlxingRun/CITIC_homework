package cn.xiaolin.citic.domain.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

/**
 * 用户信息
 * @TableName t_user
 */
@TableName(value ="t_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TUser implements Serializable {
    /**
     * 主键
     */
    @TableId
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 邮箱
     */
    @Email(message = "请填写正确的邮箱地址")
    private String email;

    /**
     * 手机号
     */
    @Length(min = 11, max = 11, message = "手机号只能是11位")
    @Pattern(regexp = "^1[3456789]\\d{9}$", message = "手机号格式有误")
    private String phone;

    /**
     * 身份证号
     */
    @TableField(value = "id_card")
    @Length(min = 18, max = 18, message = "身份证号只能是18位")
    @Pattern(regexp = "^(\\d{15}$|^\\d{18}$|^\\d{17}(\\d|X|x))$")
    private String idCard;

    /**
     * 密码
     */
    @JsonIgnore
    private String password;


    /**
     * 准入权限，默认为true
     */
    @JsonIgnore
    private Boolean admission;

    /**
     * 乐观锁
     */
    @JsonIgnore
    @Version
    private Integer revision;

    /**
     * 逻辑删除
     */
    @TableLogic
    @JsonIgnore
    private Boolean deleted;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT_UPDATE)
    @JsonIgnore
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time", fill = FieldFill.INSERT)
    @JsonIgnore
    private LocalDateTime updateTime;

    /**
     * 创建人
     */
    @TableField(value = "created_by", fill = FieldFill.INSERT_UPDATE)
    @JsonIgnore
    private String createdBy;

    /**
     * 更新人
     */
    @TableField(value = "updated_by", fill = FieldFill.INSERT)
    @JsonIgnore
    private String updatedBy;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}