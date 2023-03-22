package net.codejava.demo.contr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



import net.codejava.demo.sv.UserServiceImpl;
import net.codejava.demo.user.User;
@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
    private UserServiceImpl userService;

   @PostMapping("/register")
    public User registerUser(@RequestBody User user)  {
	   return userService.registerUser(user);
    }

    @PostMapping("/login")
    public User loginUser(@RequestParam("username") String username, @RequestParam("password") String password) {
        return userService.login(username, password);
    }

}


