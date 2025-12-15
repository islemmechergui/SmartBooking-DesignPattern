package desgin.pattern.smartbooking.strategy.gestionUtilisateur;

import desgin.pattern.smartbooking.entites.UserEntity;

public class ClientAction implements UserActionStrategy {
    @Override
    public void performAction(UserEntity user) {
        System.out.println("Client " + user.getName() + " peut réserver des services.");
    }
}
