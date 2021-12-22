package com.example.administrationservice.repository;

import com.example.administrationservice.model.SuperAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuperAdminRepository extends JpaRepository<SuperAdmin, Long> {
}
