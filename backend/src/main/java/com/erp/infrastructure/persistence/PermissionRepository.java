package com.erp.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erp.domain.model.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
