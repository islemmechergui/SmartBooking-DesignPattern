package desgin.pattern.smartbooking.strategy.gestionUtilisateur;

import desgin.pattern.smartbooking.entites.UserEntity;

public class ProviderAction implements UserActionStrategy {
    @Override
    public void performAction(UserEntity user) {
        System.out.println("Prestataire " + user.getName() + " peut gérer ses services.");

    }
}
