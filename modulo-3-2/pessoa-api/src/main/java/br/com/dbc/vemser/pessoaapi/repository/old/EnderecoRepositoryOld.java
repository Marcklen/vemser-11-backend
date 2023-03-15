package br.com.dbc.vemser.pessoaapi.repository.old;

import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.dbc.vemser.pessoaapi.entity.TipoEndereco;
import br.com.dbc.vemser.pessoaapi.service.PessoaService;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class EnderecoRepositoryOld {

    // static para simular um banco de dados
    public static List<EnderecoEntity> listaEnderecoEntities = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();
    private final PessoaService pessoaService;

    public EnderecoRepositoryOld(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
//        listaEnderecoEntities.add(new EnderecoEntity(COUNTER.incrementAndGet(), 1, TipoEndereco.valueOf("RESIDENCIAL"), "Rua das Amélias", 123, "apto 101", "12345-678", "Fortaleza", "CE", "Brasil"));
//        listaEnderecoEntities.add(new EnderecoEntity(COUNTER.incrementAndGet(), 1, TipoEndereco.valueOf("COMERCIAL"), "Rua das Laranjeiras", 321, "s/complemento", "12678-345", "Fortaleza", "CE", "Brasil"));
//        listaEnderecoEntities.add(new EnderecoEntity(COUNTER.incrementAndGet(), 2, TipoEndereco.valueOf("RESIDENCIAL"), "Rua das Carnaúbas", 456, "prx. ao viaduto", "12345-345", "Fortaleza", "CE", "Brasil"));
//        listaEnderecoEntities.add(new EnderecoEntity(COUNTER.incrementAndGet(), 2, TipoEndereco.valueOf("COMERCIAL"), "Rua dos Girassóis", 789, "p/tras da igreja", "25636-345", "Fortaleza", "CE", "Brasil"));
//        listaEnderecoEntities.add(new EnderecoEntity(COUNTER.incrementAndGet(), 3, TipoEndereco.valueOf("RESIDENCIAL"), "Av. dos Ipês", 1011, "perto do poste", "65225-123", "Fortaleza", "CE", "Brasil"));
//        listaEnderecoEntities.add(new EnderecoEntity(COUNTER.incrementAndGet(), 4, TipoEndereco.valueOf("COMERCIAL"), "Travessa da Primavera", 1213, "", "56123-699", "Fortaleza", "CE", "Brasil"));
//        listaEnderecoEntities.add(new EnderecoEntity(COUNTER.incrementAndGet(), 5, TipoEndereco.valueOf("COMERCIAL"), "Rua das Violetas", 1415, "", "62123-890", "Fortaleza", "CE", "Brasil"));
    }

    public List<EnderecoEntity> listarTodos() {
        return listaEnderecoEntities;
    }

    public List<EnderecoEntity> listarEnderecosPorIdPessoa(Integer idPessoa) {
        return listaEnderecoEntities
                .stream()
//                .filter(enderecoEntity -> enderecoEntity.getIdPessoa().equals(idPessoa))
                .collect(Collectors.toList());
    }

    public List<EnderecoEntity> buscarEnderecoPorId(Integer idEndereco) {
        return listaEnderecoEntities
                .stream()
                .filter(enderecoEntity -> enderecoEntity.getIdEndereco().equals(idEndereco))
                .collect(Collectors.toList());
    }

    public EnderecoEntity criarEndereco(Integer idPessoa, EnderecoEntity enderecoEntity) {
        enderecoEntity.setIdEndereco(COUNTER.incrementAndGet());
        listaEnderecoEntities.add(idPessoa, enderecoEntity);
        return enderecoEntity;
    }

    public void deletarEndereco(EnderecoEntity enderecoEntity) {
        listaEnderecoEntities.remove(enderecoEntity);
    }
}