package com.example.linky.admin.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<AdminEntity, Integer> {

    Optional<AdminEntity> findByUid(String uid);
}
