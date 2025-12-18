
package com.Tienda.Tienda.repository;

import com.Tienda.Tienda.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
    
}