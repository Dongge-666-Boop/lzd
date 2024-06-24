package com.southwind.controller;

import com.southwind.entity.User;
import com.southwind.entity.UserVO;
import com.southwind.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/user")
public class UserHandler {

    @Autowired
    private UserRepository userRepository;

    /**
     * 根据分页参数 进行分页查询 返回用户列表
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/findAll/{page}/{limit}")
    public UserVO findAll(@PathVariable("page") int page, @PathVariable("limit") int limit){
        UserVO userVO = new UserVO();
        userVO.setCode(0);
        userVO.setMsg("");
        userVO.setCount(userRepository.count());
        userVO.setData(userRepository.findAll((page-1)*limit,limit));
        return userVO;
    }

    /**
     * 添加用户
     *
     * @param user
     */
    @PostMapping("/save")
    public void save(@RequestBody User user){
        // 接受前端传来的json格式的数据 转换为User对象
        // 给user对象填充时间字段  然后保存到数据库
        user.setRegisterdate(new Date());
        userRepository.save(user);
    }

    /**
     * 根据id删除用户
     * @param id
     */
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id){
        userRepository.deleteById(id);
    }
}
