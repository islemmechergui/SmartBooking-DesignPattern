package desgin.pattern.smartbooking.services;

import desgin.pattern.smartbooking.entites.ServiceEntity;

import java.util.List;

public interface ServiceService {
    ServiceEntity create(ServiceEntity service);
    List<ServiceEntity> getAll();
    ServiceEntity getById(Long id);
}
