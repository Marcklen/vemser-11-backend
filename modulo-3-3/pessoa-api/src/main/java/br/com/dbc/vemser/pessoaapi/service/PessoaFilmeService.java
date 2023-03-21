package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.PessoaFilmeCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaFilmeDTO;
import br.com.dbc.vemser.pessoaapi.entity.FilmeEntity;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.entity.PessoaFilmeEntity;
import br.com.dbc.vemser.pessoaapi.entity.PessoaFilmePK;
import br.com.dbc.vemser.pessoaapi.repository.PessoaFilmeRepository;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PessoaFilmeService {

    private final PessoaFilmeRepository pessoaFilmeRepository;
    private final PessoaService pessoaService;
    private final ObjectMapper objectMapper;

    // avaliar-filme/{idUsuario}: esse endpoint irá fazer a avaliação do filme
    // para preencher a tabela de relacionamento (PESSOA_X_FILME)

    public PessoaFilmeDTO avaliarFilme(Integer idUsuario, PessoaFilmeCreateDTO pessoaFilmeCreateDTO) throws Exception {
        PessoaEntity pessoaEntity = pessoaService.getPessoa(idUsuario);

        PessoaFilmePK pessoaFilmePK = new PessoaFilmePK();
        pessoaFilmePK.setIdPessoa(pessoaEntity.getIdPessoa());
        pessoaFilmePK.setIdFilme(pessoaFilmeCreateDTO.getIdFilme());

        PessoaFilmeEntity pessoaFilmeEntity = objectMapper.convertValue(pessoaFilmeCreateDTO, PessoaFilmeEntity.class);
        pessoaFilmeEntity.setId(pessoaFilmePK);
        pessoaFilmeEntity = pessoaFilmeRepository.save(pessoaFilmeEntity);

        PessoaFilmeDTO pessoaFilmeDTO = objectMapper.convertValue(pessoaFilmeEntity, PessoaFilmeDTO.class);
        pessoaFilmeDTO.setIdPessoa(pessoaFilmeEntity.getId().getIdPessoa());
        pessoaFilmeDTO.setIdFilme(pessoaFilmeEntity.getId().getIdFilme());

        return pessoaFilmeDTO;
    }
}