package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    private final ObjectMapper objectMapper;

    public PessoaService(PessoaRepository pessoaRepository, ObjectMapper objectMapper) {
        this.pessoaRepository = pessoaRepository;
        this.objectMapper = objectMapper;
    }

    public PessoaDTO create(PessoaCreateDTO pessoa) throws Exception {

        Pessoa pessoaEntity = objectMapper.convertValue(pessoa, Pessoa.class);
        Pessoa pessoaCriada = pessoaRepository.create(pessoaEntity);
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaCriada, PessoaDTO.class);

        return pessoaDTO;
    }

    public List<PessoaDTO> list() {
        return pessoaRepository.list()
                .stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public PessoaDTO update(Integer id,
                            PessoaCreateDTO pessoaAtualizar) throws Exception {
        Pessoa pessoaRecuperada = getPessoa(id);

        pessoaRecuperada.setCpf(pessoaAtualizar.getCpf());
        pessoaRecuperada.setNome(pessoaAtualizar.getNome());
        pessoaRecuperada.setDataNascimento(pessoaAtualizar.getDataNascimento());

        return objectMapper.convertValue(pessoaRecuperada, PessoaDTO.class);
    }

    public void delete(Integer id) throws Exception {
        Pessoa pessoaRecuperada = getPessoa(id);
        pessoaRepository.delete(pessoaRecuperada);
    }

    public List<Pessoa> listByName(String nome) throws RegraDeNegocioException {
        List<Pessoa> pessoaList = pessoaRepository.listByName(nome);
        if(pessoaList.isEmpty()) {
            throw new RegraDeNegocioException("Nenhuma pessoa encontrada com o nome: " + nome.toUpperCase());
        }
        return pessoaList;
    }

    public Pessoa getPessoa(Integer id) throws Exception {
        Pessoa pessoaRecuperada = pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada!"));
        return pessoaRecuperada;
    }

//    public PessoaDTO getPessoaDTO (Integer id) throws Exception {
//        PessoaDTO pessoaDTO = objectMapper.convertValue(getPessoa(id), PessoaDTO.class);
//        return pessoaDTO;
//    }

}