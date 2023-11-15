package cn.xiaolin.citic.domain.mapper;

import cn.xiaolin.citic.domain.entity.TUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author xlxing
* @description 针对表[t_user(用户信息)] 的数据库操作Mapper
* @createDate 2023-11-15 21:10:41
* @Entity cn.xiaolin.citic.domain.entity.TUser
*/
@Mapper
public interface TUserMapper extends BaseMapper<TUser> {

}




