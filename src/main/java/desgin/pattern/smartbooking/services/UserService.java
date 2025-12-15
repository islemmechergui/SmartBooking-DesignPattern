package desgin.pattern.smartbooking.services;

import desgin.pattern.smartbooking.entites.UserEntity;

import java.util.List;

public interface UserService {
    UserEntity createUser(UserEntity user);
    UserEntity getUserById(Long id);
    List<UserEntity> getAllUsers();
    void deleteUser(Long id);
    void performRoleAction(Long userId);

}
