package com.dw.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dw.controller.common.model.PagingVO;
import com.dw.controller.common.model.Result;
import com.dw.controller.converter.UserEntityVoConverter;
import com.dw.controller.model.UserVo;
import com.dw.entity.UserEntity;
import com.dw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * (User)表控制层
 *
 * @author yangjunxiong
 * @since 2019-12-15 12:47:40
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 条件分页查询数据
     *
     * @param pagingVO 分页参数
     * @param vo 查询实体
     * @return 分页数据
     */
    @GetMapping
    public Result selectPage(PagingVO pagingVO, UserVo vo) {
        IPage<UserEntity> page = this.userService.page(new Page<>(pagingVO.getPage(),pagingVO.getLimit()), new LambdaQueryWrapper<UserEntity>()
//                .likeLeft(StringUtils.isNotEmpty(vo.getHierarchy()),UserEntity::getHierarchy,vo.getHierarchy())
        );
        return Result.ok().put("data",page.getRecords()).put("count",page.getPages());
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    public Result selectOne(@PathVariable Serializable id) {
        UserEntity byId = this.userService.getById(id);
        return Result.ok().put("data", UserEntityVoConverter.MAPPER.toVoPlus(byId));
    }

    /**
     * 新增数据
     *
     * @param vo 实体对象
     * @return 新增结果
     */
    @PostMapping
    public Result insert(@RequestBody UserVo vo) {
        vo.verify();
        int count = this.userService.count(new LambdaQueryWrapper<UserEntity>()
//                    .eq(StringUtils.isNotEmpty(vo.getPassword()), UserEntity::getPassword, vo.getPassword())
        );
        if (count>= 1) {
            return Result.error("该数据已存在");
        }
        UserEntity entity = UserEntityVoConverter.MAPPER.toEntity(vo);

        return this.userService.save(entity) ? Result.ok().put("id",entity.getId()) : Result.error("保存失败");
    }

    /**
     * 修改数据
     *
     * @param vo 实体对象
     * @return 修改结果
     */
    @PutMapping
    public Result update(@RequestBody UserVo vo) {
        vo.verify();
        UserEntity byId = this.userService.getById(vo.getId());
        if (Objects.isNull(byId)) {
            return Result.error("修改的数据不存在");
        }
        UserEntity entity = UserEntityVoConverter.MAPPER.toEntity(vo);

        return this.userService.updateById(entity) ? Result.ok().put("id",entity.getId()) : Result.error("保存失败");
    }

    /**
     * 批量删除数据
     *
     * @param ids 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public Result delete(@RequestParam("ids") List<Long> ids) {
        return this.userService.removeByIds(ids) ? Result.ok() : Result.error("删除失败");
    }

     /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除结果
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable("id") Long id) {
        return this.userService.removeById(id) ? Result.ok() : Result.error("删除失败");
    }
}