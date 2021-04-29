package controller;

import dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @RequestMapping(path = "/userForm", method = RequestMethod.GET)
    public String userForm(){
        return "userForm";
    }

    @PostMapping(path = "regist")
    public String userResult(@ModelAttribute User user){
        System.out.println("사용자가 입력한 user 정보입니다. 해당 정보를 이용하는 코드가 와야합니다.");
        System.out.println("user = " + user);
        return "regist";
    }
}
