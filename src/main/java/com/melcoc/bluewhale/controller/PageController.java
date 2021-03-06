package com.melcoc.bluewhale.controller;

import com.melcoc.bluewhale.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.ExecutionException;

@Controller
public class PageController {
    @Autowired
    UserService userService;
    /**
     * 登录页
     * @return
     */
    @GetMapping("Login")
    public  String landing(){
        return "LandingPage";
    }
    /**
     * 首页
     */
    @RequestMapping("/")
    public String index() {
        return "MainPage";
    }
    /**
     * 个人页
     */
    @RequestMapping("/u/{username}")
    public String profilePage(@PathVariable String username, Model model) throws ExecutionException, InterruptedException {
        if (userService.selectUserByName(username).get()!=null) {
            System.out.println(userService.selectUserByName(username).get());
            model.addAttribute("username", username);
            return "ProfilePage";
        }else {
            return "redirect:/";
        }
    }
    /**
     * 修改密码页
     */
    @RequestMapping("/changePassword")
    public String changePassword() {
        return "ChangePassword";
    }
    /**
     * 个人信息页
     */
    @RequestMapping("/userInfo")
    public String personalInformation() {
        return "PersonalInformation";
    }



}
