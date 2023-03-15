package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.ContatoEntity;
import br.com.dbc.vemser.pessoaapi.entity.TipoContato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContatoRepository extends JpaRepository<ContatoEntity, Integer> {

    List<ContatoEntity> findByTipoContato(TipoContato tipoContato);
    List<ContatoEntity> findContatoEntitiesByPessoaEntityOrderByTipoContato(Integer idPessoa);
}