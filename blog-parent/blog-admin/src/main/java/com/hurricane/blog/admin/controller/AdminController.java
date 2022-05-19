package com.hurricane.blog.admin.controller;

import com.hurricane.blog.admin.model.params.PageParam;
import com.hurricane.blog.admin.pojo.Category;
import com.hurricane.blog.admin.pojo.Permission;
import com.hurricane.blog.admin.pojo.SysUser;
import com.hurricane.blog.admin.pojo.Tag;
import com.hurricane.blog.admin.service.*;
import com.hurricane.blog.admin.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private PermissionService permissionService;
    @PostMapping("permission/permissionList")
    public Result permissionList(@RequestBody PageParam pageParam){
        return permissionService.listPermission(pageParam);
    }
    @PostMapping("permission/add")
    public Result add(@RequestBody Permission permission){
        return permissionService.add(permission);
    }

    @PostMapping("permission/update")
    public Result update(@RequestBody Permission permission){
        return permissionService.update(permission);
    }

    @GetMapping("permission/delete/{id}")
    public Result delete(@PathVariable("id") Long id){
        return permissionService.delete(id);
    }


    @Autowired
    private SysUserService sysuserService;
    @PostMapping("sysuser/sysuserList")
    public Result sysuserList(@RequestBody PageParam pageParam){
        return sysuserService.listSysusers(pageParam);
    }

    @PostMapping("sysuser/updateuser")
    public Result updateuser(@RequestBody SysUser sysuser){
        return sysuserService.updateuser(sysuser);
    }

    @GetMapping("sysuser/deleteuser/{id}")
    public Result deleteuser(@PathVariable("id") Long id){
        return sysuserService.deleteuser(id);
    }



    @Autowired
    private CommentService commentService;
    @PostMapping("comment/commentList")
    public Result commentList(@RequestBody PageParam pageParam){
        return commentService.listComments(pageParam);
    }


    @GetMapping("comment/deletecomment/{id}")
    public Result deletecomment(@PathVariable("id") Long id){
        return commentService.deletecomment(id);
    }



    @Autowired
    private TagService tagService;
    @PostMapping("tag/tagList")
    public Result tagList(@RequestBody PageParam pageParam){
        return tagService.listTag(pageParam);
    }
    @PostMapping("tag/addtag")
    public Result addtag(@RequestBody Tag tag){
        return tagService.addtag(tag);
    }

    @PostMapping("tag/updatetag")
    public Result updatetag(@RequestBody Tag tag){
        return tagService.updatetag(tag);
    }

    @GetMapping("tag/deletetag/{id}")
    public Result deletetag(@PathVariable("id") Long id){
        return tagService.deletetag(id);
    }




    @Autowired
    private CategoryService categoryService;
    @PostMapping("category/categoryList")
    public Result categoryList(@RequestBody PageParam pageParam){
        return categoryService.listCategory(pageParam);
    }
    @PostMapping("category/addcategory")
    public Result addcategory(@RequestBody Category category){
        return categoryService.addcategory(category);
    }

    @PostMapping("category/updatecategory")
    public Result updatecategory(@RequestBody Category category){
        return categoryService.updatecategory(category);
    }

    @GetMapping("category/deletecategory/{id}")
    public Result deletecategory(@PathVariable("id") Long id){
        return categoryService.deletecategory(id);
    }

}


