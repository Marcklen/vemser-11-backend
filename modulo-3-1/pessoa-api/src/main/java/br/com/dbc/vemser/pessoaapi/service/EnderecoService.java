package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final PessoaService pessoaService;

    public EnderecoService(EnderecoRepository enderecoRepository, PessoaService pessoaService) {
        this.enderecoRepository = enderecoRepository;
        this.pessoaService = pessoaService;
    }

    public List<Endereco> listarTodos() {
        return enderecoRepository.listarTodos();
    }

    public List<Endereco> listarEnderecosPorIdPessoa(Integer idPessoa) throws Exception {
        getEndereco(idPessoa);
        return enderecoRepository.listarEnderecosPorIdPessoa(idPessoa);
    }

    public List<Endereco> buscarEnderecoPorId(Integer idEndereco) throws Exception {
        getEndereco(idEndereco);
        return enderecoRepository.buscarEnderecoPorId(idEndereco);
    }

    public Endereco criarEndereco(Integer idPessoa, Endereco endereco) throws Exception {
        pessoaService.getPessoa(idPessoa);
        endereco.setIdPessoa(idPessoa);
        validarEndereco(endereco);
        return enderecoRepository.criarEndereco(endereco);
    }

    public Endereco atualizarEndereco(Integer idEndereco, Endereco enderecoAtualizar) throws Exception {
        Endereco enderecoRecuperado = getEndereco(idEndereco);
        validarEndereco(enderecoAtualizar);

        enderecoRecuperado.setIdEndereco(idEndereco);
        enderecoRecuperado.setTipo(enderecoAtualizar.getTipo());
        enderecoRecuperado.setLogradouro(enderecoAtualizar.getLogradouro());
        enderecoRecuperado.setNumero(enderecoAtualizar.getNumero());
        enderecoRecuperado.setComplemento(enderecoAtualizar.getComplemento());
        enderecoRecuperado.setCep(enderecoAtualizar.getCep());
        enderecoRecuperado.setCidade(enderecoAtualizar.getCidade());
        enderecoRecuperado.setEstado(enderecoAtualizar.getEstado());
        enderecoRecuperado.setPais(enderecoAtualizar.getPais());

        return enderecoRecuperado;
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
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado!"));
        return enderecoRecuperado;
    }

    private boolean validarEndereco(Endereco endereco) throws Exception {
        if (StringUtils.isBlank(endereco.getTipo().toString()) ||
                ObjectUtils.isEmpty(endereco.getTipo())) {
            throw new Exception("O tipo do endereço não pode ser nulo!");
        }
        if (StringUtils.isBlank(endereco.getLogradouro())) {
            throw new Exception("O logradouro do endereço não pode ser nulo!");
        }
        if (ObjectUtils.isEmpty(endereco.getNumero())) {
            throw new Exception("O número do endereço não pode ser nulo!");
        }
        if (StringUtils.length(endereco.getNumero().toString())  > 5) {
            throw new Exception("O número do endereço não pode ser maior que 5 caracteres!");
        }
        if (StringUtils.isBlank(endereco.getCep()) ||
                StringUtils.length(endereco.getCep())  < 8 &&
                        StringUtils.length(endereco.getCep())  > 10) {
            throw new Exception("O CEP do endereço não pode ser nulo, nem menor que 8 caracteres " +
                    "e nem maior que 10 caracteres!");
        }
        if (StringUtils.isBlank(endereco.getCidade())) {
            throw new Exception("A cidade do endereço não pode ser nula!");
        }
        if (StringUtils.isBlank(endereco.getEstado()) ||
                StringUtils.length(endereco.getEstado())  != 2) {
            throw new Exception("O estado do endereço não pode ser nulo e nem ter mais que 2 caracteres!" +
                    "Exemplo: CE, SP, RS");
        }
        if (StringUtils.isBlank(endereco.getPais())) {
            throw new Exception("O país do endereço não pode ser nulo!");
        }
        return true;
    }
}
