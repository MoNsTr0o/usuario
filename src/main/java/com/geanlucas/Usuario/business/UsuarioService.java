package com.geanlucas.Usuario.business;

import com.geanlucas.Usuario.business.converter.UsuarioConverter;
import com.geanlucas.Usuario.business.dto.UsuarioDTO;
import com.geanlucas.Usuario.infrastructure.entity.Usuario;
import com.geanlucas.Usuario.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioConverter usuarioConverter;

    public UsuarioDTO salvaUsuario(UsuarioDTO usuarioDTO){

        // convertendo o DTO para Entity
        Usuario usuario = usuarioConverter.paraUsuario(usuarioDTO);
        return usuarioConverter.paraUsuarioDTO(
                usuarioRepository.save(usuario)
        );

    }

}
