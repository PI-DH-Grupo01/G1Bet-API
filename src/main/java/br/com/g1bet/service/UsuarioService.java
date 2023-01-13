package br.com.g1bet.service;

import br.com.g1bet.mapper.exceptions.CampoExistenteException;
import br.com.g1bet.mapper.exceptions.IdNaoExisteException;
import br.com.g1bet.mapper.UsuarioMapper;
import br.com.g1bet.model.Usuario;
import br.com.g1bet.dto.request.UsuarioRequest;
import br.com.g1bet.dto.response.UsuarioResponse;
import br.com.g1bet.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository repository;
    private final PasswordEncoder encoder;

    public UsuarioResponse cadastrar(UsuarioRequest usuarioRequest) {
        if (repository.existsByEmail(usuarioRequest.getEmail())) {
            throw new CampoExistenteException("Esse email já existe!");
        }

        Usuario usuario = UsuarioMapper.INSTANCE.toUsuario(usuarioRequest);
        return UsuarioResponse.toUsuarioResponse(repository.save(usuario));
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new IdNaoExisteException("ID nao encontrado");
        }
        repository.deleteById(id);
    }

    public Usuario buscar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Id: " + id, "Usuario não encontrado"));
    }

    public Usuario atualizar(Usuario usuario, Long id) {
        Usuario atualizarUsuario = buscar(id);
        atualizarUsuario.setNome(usuario.getNome());
        atualizarUsuario.setCpf(usuario.getCpf());
        atualizarUsuario.setDataDeNascimento(usuario.getDataDeNascimento());
        atualizarUsuario.setEmail(usuario.getEmail());
        atualizarUsuario.setSenha(usuario.getSenha());
        atualizarUsuario.setChavePix(usuario.getChavePix());
        atualizarUsuario.setSaldoUsuario(usuario.getSaldoUsuario());
        return repository.save(atualizarUsuario);
    }

}
