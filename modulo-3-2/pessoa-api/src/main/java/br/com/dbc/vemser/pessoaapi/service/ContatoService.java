package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.entity.ContatoEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContatoService {

    private final ContatoRepository contatoRepository;
    private final PessoaService pessoaService;
    private final ObjectMapper objectMapper;

    public ContatoService(ContatoRepository contatoRepository, PessoaService pessoaService, ObjectMapper objectMapper) {
        this.contatoRepository = contatoRepository;
        this.pessoaService = pessoaService;
        this.objectMapper = objectMapper;
    }

    public ContatoDTO create(Integer idPessoa, ContatoCreateDTO contato) throws Exception {

        contato.setIdPessoa(pessoaService.getPessoa(idPessoa).getIdPessoa());

        ContatoEntity contatoEntity = objectMapper.convertValue(contato, ContatoEntity.class);
        ContatoEntity contatoEntityCriado = contatoRepository.create(contatoEntity);
        ContatoDTO contatoDTO = objectMapper.convertValue(contatoEntityCriado, ContatoDTO.class);

        return contatoDTO;
    }

    public List<ContatoDTO> lista() {
        return contatoRepository.list()
                .stream()
                .map(contatoEntity -> objectMapper.convertValue(contatoEntity, ContatoDTO.class))
                .collect(Collectors.toList());
    }

    public ContatoDTO update(Integer id, ContatoCreateDTO contatoAtualizar) throws Exception {
        ContatoEntity contatoEntityRecuperado = getContato(id);

        contatoEntityRecuperado.setTipoContato(contatoAtualizar.getTipoContato());
        contatoEntityRecuperado.setNumero(contatoAtualizar.getNumero());
        contatoEntityRecuperado.setDescricao(contatoAtualizar.getDescricao());

        return objectMapper.convertValue(contatoEntityRecuperado, ContatoDTO.class);
    }

    public void delete(Integer id) throws Exception {
        ContatoEntity contatoEntityRecuperado = getContato(id);
        contatoRepository.delete(contatoEntityRecuperado);
    }

    public List<ContatoEntity> findByIdPessoa(Integer idPessoa) throws Exception {
        getContato(idPessoa);
        return contatoRepository.findByIdPessoa(idPessoa);
    }

    private ContatoEntity getContato(Integer id) throws Exception {
        ContatoEntity contatoEntityRecuperado = contatoRepository.list().stream()
                .filter(contatoEntity -> contatoEntity.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado!"));
        return contatoEntityRecuperado;
    }
}
