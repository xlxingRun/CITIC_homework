package cn.xiaolin.citic.service.impl;

import cn.xiaolin.citic.common.req.TUserReqDto;
import cn.xiaolin.citic.service.TUserService;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.xiaolin.citic.domain.entity.TUser;
import cn.xiaolin.citic.domain.mapper.TUserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
* @author xlxing
* @description 针对表【t_user(用户信息)】的数据库操作Service实现
* @createDate 2023-11-15 21:10:41
*/
@Service
@RequiredArgsConstructor
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser>
    implements TUserService {

    private final PasswordEncoder passwordEncoder;

    @Override
    public Optional<TUser> findItemById(Long id) {
        return Optional.ofNullable(getById(id));
    }

    /**
     * 保存并返回
     *
     * @param dto
     * @return
     */
    @Override
    public Optional<TUser> saveAndReturn(TUserReqDto dto) {
        TUser tUser = TUser.builder()
                .id(dto.getId())
                .username(dto.getUsername())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .idCard(dto.getIdCard())
                .password(passwordEncoder.encode(dto.getPassword()))
                .build();
        boolean saved = false;
        try {
            saved = this.save(tUser);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return saved ? Optional.of(tUser) : Optional.empty();
    }

    /**
     * 更新并返回
     *
     * @param dto
     * @return
     */
    @Override
    public Optional<TUser> updateAndReturn(TUserReqDto dto) {
        if (Objects.isNull(dto.getId())) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        LambdaUpdateWrapper<TUser> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.set(Objects.nonNull(dto.getIdCard()), TUser::getIdCard, dto.getIdCard())
                .set(Objects.nonNull(dto.getEmail()), TUser::getEmail, dto.getEmail())
                .set(Objects.nonNull(dto.getPhone()), TUser::getPhone, dto.getPhone())
                .set(Objects.nonNull(dto.getPassword()), TUser::getPassword, passwordEncoder.encode(dto.getPassword()))
                .set(Objects.nonNull(dto.getUsername()), TUser::getUsername, dto.getUsername())
                .eq(TUser::getId, dto.getId());
        boolean updated = update(updateWrapper);
        return updated ? findItemById(dto.getId()) : Optional.empty();
    }

    /**
     * 删除并返回
     *
     * @param id
     * @return
     */
    @Override
    public Optional<TUser> deleteAndReturnById(Long id) {
        Optional<TUser> resp = findItemById(id);
        if (resp.isEmpty()) {
            throw new IllegalArgumentException("删除失败，用户不存在");
        }
        this.removeById(resp.get());
        return resp;
    }

    @Override
    public List<TUser> listUsers() {
        return this.list();
    }


}




