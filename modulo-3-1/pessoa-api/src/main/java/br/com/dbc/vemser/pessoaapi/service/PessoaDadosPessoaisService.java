package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.DadosPessoaisDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDadosPessoaisDTO;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PessoaDadosPessoaisService {

    private final ObjectMapper objectMapper;
    private final PessoaService pessoaService;
    private final PessoaRepository pessoaRepository;
    private final DadosPessoaisService dadosPessoaisService;


    public PessoaDadosPessoaisDTO createComDados(PessoaDadosPessoaisDTO pessoaDadosPessoais) throws Exception {

        PessoaCreateDTO pessoaCreateDTO = objectMapper.convertValue(pessoaDadosPessoais, PessoaCreateDTO.class);
        DadosPessoaisDTO dadosPessoaisDTO = objectMapper.convertValue(pessoaDadosPessoais, DadosPessoaisDTO.class);
        PessoaDadosPessoaisDTO pessoaComDadosPessoais = objectMapper.convertValue(pessoaDadosPessoais, PessoaDadosPessoaisDTO.class);
        Pessoa pessoaSemDadosPessoais = pessoaRepository.create(objectMapper.convertValue(pessoaCreateDTO, Pessoa.class));
        dadosPessoaisService.post(dadosPessoaisDTO);
        if (pessoaSemDadosPessoais.getCpf().equals(pessoaComDadosPessoais.getCpf())) {
            pessoaComDadosPessoais.setCpf(pessoaSemDadosPessoais.getCpf());
            pessoaSemDadosPessoais.setCpf(pessoaComDadosPessoais.getCpf());
            return pessoaComDadosPessoais;
        } else {
            throw new RegraDeNegocioException("CPF não confere com o CPF do cadastro de dados pessoais");
        }
    }

    public List<PessoaDadosPessoaisDTO> listarTodosComDados() {
        return dadosPessoaisService
                .getAll()
                .stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDadosPessoaisDTO.class))
                .collect(Collectors.toList());
    }
}