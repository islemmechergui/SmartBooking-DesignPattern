package desgin.pattern.smartbooking.services.ServiceImpl;

import desgin.pattern.smartbooking.repositories.ServiceRepository;
import desgin.pattern.smartbooking.services.ServiceService;
import desgin.pattern.smartbooking.entites.ServiceEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ServiceServiceImpl implements ServiceService {

    private final ServiceRepository repository;

    public ServiceServiceImpl(ServiceRepository repository) {
        this.repository = repository;
    }

    @Override
    public ServiceEntity create(ServiceEntity service) {
        service.setCreatedAt(LocalDateTime.now());
        return repository.save(service);
    }

    @Override
    public List<ServiceEntity> getAll() {
        return repository.findAll();
    }

    @Override
    public ServiceEntity getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service not found"));
    }
}