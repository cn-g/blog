package com.example.blog.controller.user;

import com.example.blog.dto.user.request.*;
import com.example.blog.dto.user.response.QueryRoleResDto;
import com.example.blog.service.user.RoleService;
import com.gcp.basicproject.base.IdAndNameDto;
import com.gcp.basicproject.base.IdRequestDto;
import com.gcp.basicproject.response.CommonException;
import com.gcp.basicproject.response.PageableResponseModelDto;
import com.gcp.basicproject.response.ResponseModelDto;
import com.gcp.basicproject.response.ResponseModels;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Admin
 */
@RestController
@Api(value = "角色信息接口",tags = "角色信息接口")
@RequestMapping("/role")
public class RoleController {

    @Resource
    private RoleService roleService;

    @PostMapping("/addRole")
    @ApiOperation("添加角色信息接口")
    public ResponseModelDto addRole(@RequestBody AddRoleReqDto reqDto){
        if(roleService.addRole(reqDto)){
            return ResponseModels.ok();
        }else{
            throw new CommonException("添加角色失败");
        }
    }

    @PostMapping("/deleteRole")
    @ApiOperation("删除角色接口")
    public ResponseModelDto deleteRole(@RequestBody IdRequestDto reqDto){
        if(roleService.deleteRole(reqDto)){
            return ResponseModels.ok();
        }else{
            throw new CommonException("删除角色失败");
        }
    }

    @GetMapping("/getRolePage")
    @ApiOperation("分页查询角色信息接口")
    public PageableResponseModelDto<QueryRoleResDto> queryRolePage(QueryRoleReqDto reqDto){
        return ResponseModels.page2ResponseModel(roleService.queryRolePage(reqDto));
    }

    @PostMapping("/updateRole")
    @ApiOperation("修改角色信息")
    public ResponseModelDto updateRole(@RequestBody UpdateRoleReqDto reqDto){
        if(roleService.updateRole(reqDto)){
            return ResponseModels.ok();
        }else{
            throw new CommonException("修改角色失败");
        }
    }

    @GetMapping("/getRoleData")
    @ApiOperation("获取角色信息接口")
    public ResponseModelDto<List<IdAndNameDto>> queryRoleData(String name){
        return ResponseModels.ok(roleService.getRoleData(name));
    }

}
