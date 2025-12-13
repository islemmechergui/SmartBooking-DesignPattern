package desgin.pattern.smartbooking.controllers;

import desgin.pattern.smartbooking.entites.ServiceEntity;
import desgin.pattern.smartbooking.services.ServiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
public class ServiceController {

    private final ServiceService serviceService;

    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @PostMapping
    public ServiceEntity create(@RequestBody ServiceEntity service) {
        return serviceService.create(service);
    }

    @GetMapping
    public List<ServiceEntity> getAll() {
        return serviceService.getAll();
    }

    @GetMapping("/{id}")
    public ServiceEntity getById(@PathVariable Long id) {
        return serviceService.getById(id);
    }
}
