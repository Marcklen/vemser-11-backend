package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final PessoaService pessoaService;
    private final ObjectMapper objectMapper;

    public EnderecoService(EnderecoRepository enderecoRepository, PessoaService pessoaService, ObjectMapper objectMapper) {
        this.enderecoRepository = enderecoRepository;
        this.pessoaService = pessoaService;
        this.objectMapper = objectMapper;
    }

    public List<EnderecoDTO> listarTodos() {
        return enderecoRepository.listarTodos()
                .stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    public List<Endereco> listarEnderecosPorIdPessoa(Integer idPessoa) throws Exception {
        getEndereco(idPessoa);
        return enderecoRepository.listarEnderecosPorIdPessoa(idPessoa);
    }

    public List<Endereco> buscarEnderecoPorId(Integer idEndereco) throws Exception {
        getEndereco(idEndereco);
        return enderecoRepository.buscarEnderecoPorId(idEndereco);
    }

    public EnderecoDTO criarEndereco(Integer idPessoa, EnderecoCreateDTO endereco) throws Exception {
        endereco.setIdPessoa(pessoaService.getPessoa(idPessoa).getIdPessoa());

        Endereco enderecoEntity = objectMapper.convertValue(endereco, Endereco.class);
        Endereco enderecoCriado = enderecoRepository.criarEndereco(idPessoa, enderecoEntity);
        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoCriado, EnderecoDTO.class);

        return enderecoDTO;
    }

    public EnderecoDTO atualizarEndereco(Integer idEndereco, @Valid EnderecoCreateDTO enderecoAtualizar) throws Exception {
        Endereco enderecoRecuperado = getEndereco(idEndereco);

        enderecoRecuperado.setIdEndereco(idEndereco);
        enderecoRecuperado.setTipo(enderecoAtualizar.getTipo());
        enderecoRecuperado.setLogradouro(enderecoAtualizar.getLogradouro());
        enderecoRecuperado.setNumero(enderecoAtualizar.getNumero());
        enderecoRecuperado.setComplemento(enderecoAtualizar.getComplemento());
        enderecoRecuperado.setCep(enderecoAtualizar.getCep());
        enderecoRecuperado.setCidade(enderecoAtualizar.getCidade());
        enderecoRecuperado.setEstado(enderecoAtualizar.getEstado());
        enderecoRecuperado.setPais(enderecoAtualizar.getPais());

        return objectMapper.convertValue(enderecoRecuperado, EnderecoDTO.class);
    }


    public void deletarEndereco(Integer idEndereco) throws Exception {
        Endereco enderecoRecuperado = getEndereco(idEndereco);
        enderecoRepository.deletarEndereco(enderecoRecuperado);
    }

    // metodo para validar se o endereco existe, se não existir, lança uma exceção
    private Endereco getEndereco(Integer idEndereco) throws Exception {
        Endereco enderecoRecuperado = enderecoRepository
                .listarTodos().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(idEndereco))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não encontrado!"));
        return enderecoRecuperado;
    }
}
