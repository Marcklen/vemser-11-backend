package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.entity.TipoEndereco;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
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
        getEndereco(idPessoa);
        endereco.setIdPessoa(idPessoa);
        return enderecoRepository.criarEndereco(endereco);
    }

    public Endereco atualizarEndereco(Integer idEndereco, Endereco enderecoAtualizar) throws Exception {
        Endereco enderecoRecuperado = getEndereco(idEndereco);
//        enderecoRecuperado.setIdPessoa(enderecoAtualizar.getIdPessoa()); // não pode atualizar o idPessoa essa linha é necessária ?
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
}
