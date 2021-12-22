package com.example.administrationservice.service;

import com.example.administrationservice.model.SimpleAdmin;

import java.util.List;

public interface AdminService {
    public List<SimpleAdmin> getSimpleAdmins();
    public SimpleAdmin getSimpleAdminById(Long id);
    public SimpleAdmin saveSimpleAdmin(SimpleAdmin student);
    public SimpleAdmin updateSimpleAdmin(SimpleAdmin student);
    public String deleteSimpleAdminById(Long id);
}
