package com.tienda.service;

import com.Tienda.Tienda.domain.Rol;
import com.Tienda.Tienda.domain.Usuario;
import com.Tienda.Tienda.repository.UsuarioRepository;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class UsuarioDetailsService implements UserDetailsService {

    @Autowired
    private HttpSession session;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        //Se busca el username en la tabla usuario
        Usuario usuario = usuarioRepository.findByUsername(username);
        if (usuario == null) {
            //No lo encontro...
            throw new UsernameNotFoundException(username);
        }

        //Si estamos acá... todo bien... se encontró el usuario...
        session.removeAttribute("imagenUsuario");
        session.setAttribute("imagenUsuario", usuario.getRutaImagen());

        //Se cargan los roles como ROLES de Seguridad...
        var roles = new ArrayList<GrantedAuthority>();
        for (Rol rol : usuario.getRoles()) {
            roles.add(new SimpleGrantedAuthority("ROLE_" + rol.getNombre()));
        }

        return new User(usuario.getUsername(), usuario.getPassword(), roles); //Esto se usa para comparar la clave y si todo está bien se asignan los roles
    }

}
