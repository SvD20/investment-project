package com.svyatdanilov.investmentproject.controller;

import com.svyatdanilov.investmentproject.dao.UserRepository;
import com.svyatdanilov.investmentproject.dto.UserDto;
import com.svyatdanilov.investmentproject.entity.User;
import com.svyatdanilov.investmentproject.service.UserDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserDtoService userService;
    private UserRepository userRepository;

    @Autowired
    public UserController(UserDtoService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    // handler method to handle list of users
    @GetMapping("/list")
    public String users(Model model){
        List<UserDto> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/setStatus")
    public String setStatusOfUser(@RequestParam("userId") int id){
        Optional<User> user = userRepository.findById(id);
        if(user.get().getStatus().equals("active")){
            user.get().setStatus("blocked");
        }
        else{
            user.get().setStatus("active");
        }
        userRepository.save(user.get());
        return "redirect:/users/list";
    }



    @GetMapping("/delete")
    public String deleteUser(@RequestParam("userId") int id){
        userRepository.deleteById(id);
        return "redirect:/users/list";
    }
}
