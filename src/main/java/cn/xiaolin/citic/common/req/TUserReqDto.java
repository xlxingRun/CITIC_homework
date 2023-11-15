package cn.xiaolin.citic.common.req;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

/**
 * @author xingxiaolin xlxing@bupt.edu.cn
 * @Description
 * @create 2023/11/15
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TUserReqDto {
    private Long id;
    private String username;
    @Email(message = "请填写正确的邮箱地址")
    private String email;
    @Length(min = 11, max = 11, message = "手机号只能是11位")
    @Pattern(regexp = "^1[3456789]\\d{9}$", message = "手机号格式有误")
    private String phone;
    private String password;
    @Length(min = 18, max = 18, message = "身份证号只能是18位")
    @Pattern(regexp = "^(\\d{15}$|^\\d{18}$|^\\d{17}(\\d|X|x))$")
    private String idCard;
}
