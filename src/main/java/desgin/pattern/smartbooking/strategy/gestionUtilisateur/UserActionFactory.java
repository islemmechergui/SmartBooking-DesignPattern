package desgin.pattern.smartbooking.strategy.gestionUtilisateur;

import desgin.pattern.smartbooking.enums.Role;


public class UserActionFactory {
    public static UserActionStrategy getStrategy(Role role) {
        return switch (role) {
            case CLIENT -> new ClientAction();
            case PROVIDER -> new ProviderAction();
            case ADMIN -> new AdminAction();
        };
    }
}
