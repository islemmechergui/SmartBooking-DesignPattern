package desgin.pattern.smartbooking.strategy.gestionUtilisateur;

import desgin.pattern.smartbooking.entites.UserEntity;

public class AdminAction implements UserActionStrategy {
    @Override
    public void performAction(UserEntity user) {
        System.out.println("Admin " + user.getName() + " peut gérer tous les utilisateurs et services.");

    }
}
