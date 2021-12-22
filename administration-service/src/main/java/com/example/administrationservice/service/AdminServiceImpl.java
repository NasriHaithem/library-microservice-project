package com.example.administrationservice.service;

import com.example.administrationservice.model.SimpleAdmin;
import com.example.administrationservice.repository.SimpleAdminRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService{

    private final SimpleAdminRepository simpleAdminRepository;

    public AdminServiceImpl(SimpleAdminRepository simpleAdminRepository) {
        this.simpleAdminRepository = simpleAdminRepository;
    }

    @Override
    public List<SimpleAdmin> getSimpleAdmins() {
        return simpleAdminRepository.findAll();
    }
    @Override
    public SimpleAdmin getSimpleAdminById(Long id) {
        return simpleAdminRepository.findById(id).get();
    }
    @Override
    public SimpleAdmin saveSimpleAdmin(SimpleAdmin simpleAdmin) {
        return simpleAdminRepository.save(simpleAdmin);
    }
    @Override
    public SimpleAdmin updateSimpleAdmin(SimpleAdmin newSimpleAdmin) {

        if(simpleAdminRepository.findById(newSimpleAdmin.getId()).isPresent())
        {
            SimpleAdmin updatedSimpleAdmin = simpleAdminRepository.findById(newSimpleAdmin.getId()).get();

            if(newSimpleAdmin.getNom() != null) updatedSimpleAdmin.setNom(newSimpleAdmin.getNom());
            if(newSimpleAdmin.getPrenom() != null) updatedSimpleAdmin.setPrenom(newSimpleAdmin.getPrenom());
            if(newSimpleAdmin.getUsername() != null) updatedSimpleAdmin.setUsername(newSimpleAdmin.getUsername());

            return simpleAdminRepository.save(updatedSimpleAdmin);
        }
        return null;
    }
    @Override
    public String deleteSimpleAdminById(Long id) {
        if(simpleAdminRepository.findById(id).isPresent())
        {
            simpleAdminRepository.deleteById(id);
            return "Successfully deleted";
        }
        return "No simpleAdmin with the provided ID";
    }


}
