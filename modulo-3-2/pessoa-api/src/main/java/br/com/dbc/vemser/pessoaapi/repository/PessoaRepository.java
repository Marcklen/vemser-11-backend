package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.dto.RelatorioPessoaCompletoDTO;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {
    List<PessoaEntity> findByNomeContainingIgnoreCase(String nome);

    List<PessoaEntity> findByCpfContains(String cpf);

    List<PessoaEntity> findByDataNascimentoBetween(LocalDate dataInicio, LocalDate dataFinal);

    @Query("SELECT new br.com.dbc.vemser.pessoaapi.dto.RelatorioPessoaCompletoDTO(" +
            "           p.idPessoa, "           +
            "           p.nome, "               +
            "           p.email, "              +
            "           c.numero, "             +
            "           e.cep, "                +
            "           e.cidade, "             +
            "           e.estado, "             +
            "           e.pais, "               +
            "           pt.nome, "              +
            "           f.descricao, "          +
            "           f.nota, "               +
            "           pf.descricao, "         +
            "           pf.notaPessoa, "        +
            "           pf.dataAssistido)"      +
            "FROM PESSOA p "                    +
            "LEFT JOIN p.contatos c "           +
            "LEFT JOIN p.enderecos e "          +
            "LEFT JOIN p.pets pt "              +
            "LEFT JOIN p.avaliacoes pf "        +
            "LEFT JOIN pf.filme f ")
    List<RelatorioPessoaCompletoDTO> reportPessoaCompleto();
}