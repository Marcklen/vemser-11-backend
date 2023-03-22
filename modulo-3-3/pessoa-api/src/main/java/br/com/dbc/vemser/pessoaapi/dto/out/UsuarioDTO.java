package br.com.dbc.vemser.pessoaapi.dto.out;

import br.com.dbc.vemser.pessoaapi.dto.in.UsuarioCreateDTO;
import lombok.Data;

@Data
public class UsuarioDTO extends UsuarioCreateDTO {

    private Integer idUsuario;
}
