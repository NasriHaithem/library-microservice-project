package com.example.administrationservice.repository;

import com.example.administrationservice.model.SimpleAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimpleAdminRepository extends JpaRepository<SimpleAdmin, Long> {
}
