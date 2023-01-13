package br.com.g1bet.mapper;

import br.com.g1bet.model.Usuario;
import br.com.g1bet.dto.request.UsuarioRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    Usuario toUsuario(UsuarioRequest usuarioRequest);

}
