package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.entity.ContatoEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class ContatoService {

    private final ContatoRepository contatoRepository;
    private final PessoaService pessoaService;
    private final ObjectMapper objectMapper;


    public ContatoDTO create(Integer idPessoa, ContatoCreateDTO contato) throws Exception {

        contato.setIdPessoa(pessoaService.getPessoa(idPessoa).getIdPessoa());

        ContatoEntity contatoEntity = objectMapper.convertValue(contato, ContatoEntity.class);
//        ContatoEntity contatoEntityCriado = contatoRepositoryOld.create(contatoEntity);
        contatoEntity = contatoRepository.save(contatoEntity);
        ContatoDTO contatoDTO = objectMapper.convertValue(contatoEntity, ContatoDTO.class);

        return contatoDTO;
    }

    public List<ContatoDTO> lista() {
//        return contatoRepositoryOld.list()
        return contatoRepository.findAll()
                .stream()
                .map(contatoEntity -> objectMapper.convertValue(contatoEntity, ContatoDTO.class))
                .collect(Collectors.toList());
    }

    public ContatoDTO update(Integer id, ContatoCreateDTO contatoAtualizar) throws Exception {
        ContatoEntity contatoEntityRecuperado = getContato(id);

        contatoEntityRecuperado.setTipoContato(contatoAtualizar.getTipoContato());
        contatoEntityRecuperado.setNumero(contatoAtualizar.getNumero());
        contatoEntityRecuperado.setDescricao(contatoAtualizar.getDescricao());

        contatoRepository.save(contatoEntityRecuperado);

        ContatoDTO contatoDTO = objectMapper.convertValue(contatoEntityRecuperado, ContatoDTO.class);

        return contatoDTO;
    }

    public void delete(Integer id) throws Exception {
        ContatoEntity contatoEntityRecuperado = getContato(id);
//        contatoRepositoryOld.delete(contatoEntityRecuperado);
        contatoRepository.delete(contatoEntityRecuperado);
    }

    public List<ContatoEntity> findByIdPessoa(Integer idPessoa) throws Exception {
        getContato(idPessoa);
//        return contatoRepositoryOld.findByIdPessoa(idPessoa);
        return null;
    }

    private ContatoEntity getContato(Integer id) throws Exception {
//        ContatoEntity contatoEntityRecuperado = contatoRepositoryOld.list().stream()
//                .filter(contatoEntity -> contatoEntity.getIdContato().equals(id))
//                .findFirst()
        ContatoEntity contatoEntityRecuperado =
                contatoRepository.findById(id)
                        .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado!"));
        return contatoEntityRecuperado;
    }
}