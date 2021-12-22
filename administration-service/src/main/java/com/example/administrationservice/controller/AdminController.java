package com.example.administrationservice.controller;


import com.example.administrationservice.model.SimpleAdmin;
import com.example.administrationservice.service.AdminService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/admins/")
public class AdminController {

    private final AdminService adminService;
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping
    public List<SimpleAdmin> getSimpleAdmins() {
        return adminService.getSimpleAdmins();
    }

    @GetMapping("{id}")
    public SimpleAdmin getSimpleAdminById(@PathVariable Long id) {
        return adminService.getSimpleAdminById(id);
    }

    @PostMapping
    public SimpleAdmin  addSimpleAdmin(@RequestBody SimpleAdmin admin) {
        return adminService.saveSimpleAdmin(admin);
    }

    @PutMapping
    public SimpleAdmin  updateSimpleAdmin(@RequestBody SimpleAdmin admin) {
        return adminService.updateSimpleAdmin(admin);
    }

    @DeleteMapping("{id}")
    public String  deleteSimpleAdmin(@PathVariable Long id) {
        return adminService.deleteSimpleAdminById(id);
    }
}
