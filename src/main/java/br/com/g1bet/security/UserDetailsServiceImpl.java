package br.com.g1bet.security;

import java.util.Optional;

import br.com.g1bet.model.Usuario;
import br.com.g1bet.repository.UsuarioRepository;
import br.com.g1bet.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);

        if(usuario.isPresent())
            return new UserDetailsImpl(usuario.get());
        else
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);

    }

}
