package ru.kata.spring.boot_security.demo.controllers;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class UsersController {

//    private final UsersService usersService;
//
//    private final RolesService rolesService;
//
//
//    @Autowired
//    public UsersController(UsersServiceImpl usersService, RolesService rolesService) {
//
//        this.usersService = usersService;
//        this.rolesService = rolesService;
//    }

    @GetMapping("/admin")
    public String users() {

        return "admin";
    }

    @GetMapping("/test")
    public String test() {

        return "test";
    }


//    @PostMapping
//    public String addUser(@ModelAttribute("user") @Valid User user,
//                          @RequestParam("roleId") List<Integer> roleId) {
//
//
//        user.setRoles(rolesService.findMultipleById(roleId));
//
//        usersService.save(user);
//
//
//        return "redirect:/admin";
//    }

//    @DeleteMapping("/delete/{id}")
//    public String deleteUser(@PathVariable("id") long id) {
//
//        usersService.delete(id);
//
//        return "redirect:/admin";
//    }
//
//    @PatchMapping("/update/{id}")
//    public String updateUser(User user,
//                             @RequestParam("roleIdToUpdate") List<Integer> roleId) {
//
//        user.setRoles(rolesService.findMultipleById(roleId));
//
//        usersService.update(user);
//        return "redirect:/admin";
//    }
//
//
//    @GetMapping("/user")
//    public String userPage(Principal principal, Model model) {
//
//        User user = usersService.findByEmail(principal.getName());
//
//        model.addAttribute("currentUser", user);
//
//        System.out.println(user);
//
//        return "user";
//    }
}

