package desgin.pattern.smartbooking.services.ServiceImpl;

import desgin.pattern.smartbooking.repositories.UserRepository;
import desgin.pattern.smartbooking.services.UserService;
import desgin.pattern.smartbooking.entites.UserEntity;
import desgin.pattern.smartbooking.strategy.gestionUtilisateur.UserActionFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity createUser(UserEntity user) {
        user.setCreatedAt(LocalDateTime.now());
        return userRepository.save(user);
    }

    @Override
    public UserEntity getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void performRoleAction(Long userId) {
        UserEntity user = getUserById(userId);
        UserActionFactory.getStrategy(user.getRole()).performAction(user);
    }
}
