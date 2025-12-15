package desgin.pattern.smartbooking.controllers;

import desgin.pattern.smartbooking.entites.UserEntity;
import desgin.pattern.smartbooking.services.UserService;
import desgin.pattern.smartbooking.strategy.gestionUtilisateur.UserActionFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity user) {
        return userService.createUser(user);
    }

    @GetMapping
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserEntity getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @PostMapping("/{id}/action")
    public void performUserRoleAction(@PathVariable Long id) {
        userService.performRoleAction(id);
    }
}
