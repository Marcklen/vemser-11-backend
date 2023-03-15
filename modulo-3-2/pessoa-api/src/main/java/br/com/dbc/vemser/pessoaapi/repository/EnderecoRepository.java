package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Integer> {

//    List<EnderecoEntity> findByTipo(TipoEndereco tipoEndereco);

//    List<EnderecoEntity> findByCepOrderByLogradouro(String cep);

//    List<EnderecoEntity> findByIdPessoa (Integer idPessoa);

//    List<EnderecoEntity> findByPessoas (PessoaEntity pessoaEntity);
}