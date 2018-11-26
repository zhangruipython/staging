package controller;

import entity.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author 张睿
 * @date 2018/11/26 10:25
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {
    //创建线程安全的map
    static Map<Long, User> users= Collections.synchronizedMap(new HashMap<>());
    @ApiOperation(value = "获取用户列表",notes = " ")
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<User> getUserList(){
        //用于处理/users/的get请求,获取用户列表
        List<User> r=new ArrayList<>(users.values());
        return r;
    }
    @ApiOperation(value = "创建用户",notes = "根据User对象创建用户")
    @ApiImplicitParam(name = "user",value = "用户详细实体user",required = true,dataType = "User")
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public String postUser(@ModelAttribute User user){
        //处理/users/的post请求，用来创建用户
        users.put(user.getId(),user);
        return "success";
    }
    @ApiOperation(value = "获取用户详细信息",notes = "根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id",value = "用户ID",required = true,dataType = "Long")
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User getUser(@PathVariable Long id){
        //处理"/users/{id}"中的GET请求，用来获取url中id值的User
        return users.get(id);
    }
    @ApiOperation(value="更新用户详细信息", notes="根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    })
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public String putUser(@PathVariable Long id,@ModelAttribute User user){
        //处理"/users/{id}"中的PUT请求，用来更新user信息
        User u=users.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        users.put(id,u);
        return "success";
    }
    @ApiOperation(value="删除用户", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id){
        //处理“/users/{id}”的DELETE请求，用来删除用户
        users.remove(id);
        return "success";
    }
}
