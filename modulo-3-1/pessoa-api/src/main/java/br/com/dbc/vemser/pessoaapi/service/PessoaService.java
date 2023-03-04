package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
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

    public PessoaDTO create(PessoaCreateDTO pessoa) throws Exception{
//        validarPessoa(pessoa);
        Pessoa pessoaEntity = objectMapper.convertValue(pessoa, Pessoa.class);
        Pessoa pessoaCriada = pessoaRepository.create(pessoaEntity);
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaCriada, PessoaDTO.class);

        return pessoaDTO;
    }

    public List<PessoaDTO> list() {
        return pessoaRepository
                .list()
                .stream()
                .map(p -> objectMapper.convertValue(p, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public PessoaDTO update(Integer id,
                         PessoaCreateDTO pessoaAtualizar) throws Exception {
        Pessoa pessoaRecuperada = getPessoa(id);
        Pessoa pessoaEntity = objectMapper.convertValue(pessoaAtualizar, Pessoa.class);
        Pessoa pessoaCriada = pessoaRepository.create(pessoaEntity);
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaCriada, PessoaDTO.class);

        pessoaRecuperada.setCpf(pessoaAtualizar.getCpf());
        pessoaRecuperada.setNome(pessoaAtualizar.getNome());
        pessoaRecuperada.setDataNascimento(pessoaAtualizar.getDataNascimento());

        return pessoaDTO;
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

    // validador de pessoas (nome, cpf e data de nascimento)
//    public boolean validarPessoa(PessoaCreateDTO pessoa) throws Exception{
//        if (StringUtils.isBlank(pessoa.getNome())) {
//            throw new Exception("Nome não pode ser vazio!");
//        }
//        if (ObjectUtils.isEmpty(pessoa.getDataNascimento())){
//            throw new Exception("Data de nascimento não pode ser vazia!");
//        }
//        if (StringUtils.isBlank(pessoa.getCpf()) || StringUtils.length(pessoa.getCpf()) != 11) {
//            throw new Exception("CPF não pode ser vazio e deve ter 11 dígitos!");
//        }
//        return true;
//    }
}
