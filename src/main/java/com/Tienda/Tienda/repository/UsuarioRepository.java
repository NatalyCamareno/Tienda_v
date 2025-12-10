
package com.Tienda.Tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;  
import com.Tienda.Tienda.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Producto, Integer>{
    
    Usuario findByUsername(String username);
    
    Usuario findByUsernameAndPassword(String username, String Password);

    Usuario findByUsernameOrCorreo(String username, String correo);

    boolean existsByUsernameOrCorreo(String username, String correo);
    
}
