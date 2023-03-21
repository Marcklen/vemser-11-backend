package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.FilmeCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.FilmeDTO;
import br.com.dbc.vemser.pessoaapi.entity.FilmeEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.FilmeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class FilmeService {

    private final FilmeRepository filmeRepository;
    private final ObjectMapper objectMapper;

    public FilmeDTO criarFilme (FilmeCreateDTO filmeCreate) {
        FilmeEntity filmeEntity = objectMapper.convertValue(filmeCreate, FilmeEntity.class);
        filmeEntity = filmeRepository.save(filmeEntity);
        FilmeDTO filmeDTO = objectMapper.convertValue(filmeEntity, FilmeDTO.class);
        return filmeDTO;
    }

    public List<FilmeDTO> listarFilmes() {
        return filmeRepository.findAll()
                .stream()
                .map(filme -> objectMapper.convertValue(filme, FilmeDTO.class))
                .collect(Collectors.toList());
    }

    public FilmeDTO editarFilme (Integer idFilme, FilmeCreateDTO filmeCreate) throws Exception {
        FilmeEntity filmeAntigo = getFilmeById(idFilme);

        filmeAntigo.setDescricao(filmeCreate.getDescricao());
        filmeAntigo.setNota(filmeCreate.getNota());
        filmeAntigo.setTipoFilme(filmeCreate.getTipoFilme());

        filmeAntigo = filmeRepository.save(filmeAntigo);
        FilmeDTO filmeAtualizado = objectMapper.convertValue(filmeAntigo, FilmeDTO.class);

        return filmeAtualizado;
    }

    public void excluirFilme(Integer idFilme) throws Exception {
        FilmeEntity filmeRecuperado = getFilmeById(idFilme);
//        Comentei para utilizar futuramente caso queira enviar alguma arquivo/email
//        FilmeDTO filmeDTO = objectMapper.convertValue(filmeRecuperado, FilmeDTO.class);
        filmeRepository.delete(filmeRecuperado);
    }

    public FilmeEntity getFilmeById (Integer id) throws Exception {
        FilmeEntity filmeRecuperado =
                filmeRepository
                        .findById(id)
                        .orElseThrow(() -> new RegraDeNegocioException("Filme não encontrado"));
        return filmeRecuperado;
    }
}
