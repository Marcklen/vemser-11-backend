package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepositoryOld;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PessoaService {

    //    private final PessoaRepositoryOld pessoaRepositoryOld;
    private final PessoaRepository pessoaRepository;
    private final ObjectMapper objectMapper;
    private final EmailService emailService;


    public PessoaDTO create(PessoaCreateDTO pessoa) throws Exception {

        PessoaEntity pessoaEntity = objectMapper.convertValue(pessoa, PessoaEntity.class);
//        PessoaEntity pessoaEntityCriada = pessoaRepositoryOld.create(pessoaEntity);
        pessoaEntity = pessoaRepository.save(pessoaEntity);
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTO.class);

        emailService.enviarEmailParaPessoaCadastrada(pessoaDTO);

        return pessoaDTO;
    }

    public List<PessoaDTO> list() {
//        return pessoaRepositoryOld.list()
        return pessoaRepository.findAll()
                .stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public PessoaDTO update(Integer id,
                            PessoaCreateDTO pessoaAtualizar) throws Exception {
        PessoaEntity pessoaEntityRecuperada = getPessoa(id);

        pessoaEntityRecuperada.setCpf(pessoaAtualizar.getCpf());
        pessoaEntityRecuperada.setNome(pessoaAtualizar.getNome());
        pessoaEntityRecuperada.setDataNascimento(pessoaAtualizar.getDataNascimento());
        pessoaEntityRecuperada.setEmail(pessoaAtualizar.getEmail());

        pessoaEntityRecuperada = pessoaRepository.save(pessoaEntityRecuperada);

        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaEntityRecuperada, PessoaDTO.class);
        emailService.enviarEmailParaPessoaAtualizada(pessoaDTO);

        return pessoaDTO;
    }

    public void delete(Integer id) throws Exception {
        PessoaEntity pessoaEntityRecuperada = getPessoa(id);
        // fiz essa conversão para verificar se o objeto está sendo convertido corretamente e se consigo exclui-lo
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaEntityRecuperada, PessoaDTO.class);
        emailService.enviarEmailParaPessoaExcluida(pessoaDTO);
//        pessoaRepositoryOld.delete(pessoaEntityRecuperada);
        pessoaRepository.delete(pessoaEntityRecuperada);
    }

    public List<PessoaEntity> listByName(String nome) throws RegraDeNegocioException {
//        List<PessoaEntity> pessoaEntityList = pessoaRepositoryOld.listByName(nome);
        List<PessoaEntity> pessoaEntityList =
                pessoaRepository.findByNome(nome)
                        .stream()
                        .filter(pessoa -> pessoa.getNome().toUpperCase().contains(nome.toUpperCase()))
                        .collect(Collectors.toList());
        if (pessoaEntityList.isEmpty()) {
            throw new RegraDeNegocioException("Nenhuma pessoa encontrada com o nome: " + nome.toUpperCase());
        }
        return pessoaEntityList;
    }

    public PessoaEntity getPessoa(Integer id) throws Exception {
//        PessoaEntity pessoaEntityRecuperada = pessoaRepositoryOld.list().stream()
//                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
//                .findFirst()
        PessoaEntity pessoaRecuperada =
                pessoaRepository.findById(id)
                        .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada!"));
        return pessoaRecuperada;
    }
}