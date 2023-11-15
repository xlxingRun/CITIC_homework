package cn.xiaolin.citic.service;

import cn.xiaolin.citic.common.req.TUserReqDto;
import cn.xiaolin.citic.domain.entity.TUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Optional;

/**
* @author xlxing
* @description 针对表【t_user(用户信息)】的数据库操作Service
* @createDate 2023-11-15 21:10:41
*/
public interface TUserService extends IService<TUser> {

    Optional<TUser> findItemById(Long id);

    /**
     * 保存并返回
     * @param dto
     * @return
     */
    Optional<TUser> saveAndReturn(TUserReqDto dto);

    /**
     * 更新并返回
     * @param dto
     * @return
     */
    Optional<TUser> updateAndReturn(TUserReqDto dto);

    /**
     * 删除并返回
     * @param id
     * @return
     */
    Optional<TUser> deleteAndReturnById(Long id);
}
