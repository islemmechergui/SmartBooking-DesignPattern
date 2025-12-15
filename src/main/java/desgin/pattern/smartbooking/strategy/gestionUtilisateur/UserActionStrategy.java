package desgin.pattern.smartbooking.strategy.gestionUtilisateur;

import desgin.pattern.smartbooking.entites.UserEntity;

public interface UserActionStrategy {
    void performAction(UserEntity user);
}
