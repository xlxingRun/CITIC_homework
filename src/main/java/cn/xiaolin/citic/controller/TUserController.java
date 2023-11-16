package cn.xiaolin.citic.controller;

import cn.xiaolin.citic.common.req.TUserReqDto;
import cn.xiaolin.citic.domain.entity.TUser;
import cn.xiaolin.citic.common.resp.Result;
import cn.xiaolin.citic.service.TUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author xingxiaolin xlxing@bupt.edu.cn
 * @Description 用户信息增删改查
 * @create 2023/11/15
 */

@Tag(name = "用户信息")
@RestController
@RequiredArgsConstructor
public class TUserController {
    private final TUserService tUserService;

    @Operation(summary = "查询用户")
    @GetMapping("/user/{id}")
    public Result<TUser> one(@PathVariable Long id) {
        Optional<TUser> item = tUserService.findItemById(id);
        return item.map(Result::ok).orElseGet(Result::notFound);
    }

    @Operation(summary = "新增系统用户")
    @PostMapping("/user")
    public Result<TUser> insertOne(@Validated @RequestBody TUserReqDto dto) {
        Optional<TUser> item = tUserService.saveAndReturn(dto);
        return item.map(Result::ok).orElseGet(Result::badRequest);
    }

    @Operation(summary = "更新系统用户")
    @PutMapping("/user")
    public Result<TUser> updateOne(@Validated @RequestBody TUserReqDto dto) {
        Optional<TUser> item = tUserService.updateAndReturn(dto);
        return item.map(Result::ok).orElseGet(Result::badRequest);
    }

    @Operation(summary = "删除系统用户")
    @DeleteMapping("/user/{id}")
    public Result<TUser> deleteOne(@PathVariable Long id) {
        Optional<TUser> item = tUserService.deleteAndReturnById(id);
        return item.map(Result::ok).orElseGet(Result::badRequest);
    }

    @Operation(summary = "查询所有用户")
    @GetMapping("/user/all")
    public Result<List<TUser>> listUsers() {
        List<TUser> userList = tUserService.listUsers();
        return Result.ok(userList);
    }
}
