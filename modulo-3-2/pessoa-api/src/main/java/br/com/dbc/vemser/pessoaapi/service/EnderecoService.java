package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final PessoaService pessoaService;
    private final ObjectMapper objectMapper;
    private final EmailService emailService;


    public List<EnderecoDTO> listarTodos() {
        return enderecoRepository.listarTodos()
                .stream()
                .map(enderecoEntity -> objectMapper.convertValue(enderecoEntity, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    public List<EnderecoEntity> listarEnderecosPorIdPessoa(Integer idPessoa) throws Exception {
        getEndereco(idPessoa);
        return enderecoRepository.listarEnderecosPorIdPessoa(idPessoa);
    }

    public List<EnderecoEntity> buscarEnderecoPorId(Integer idEndereco) throws Exception {
        getEndereco(idEndereco);
        return enderecoRepository.buscarEnderecoPorId(idEndereco);
    }

    public EnderecoDTO criarEndereco(Integer idPessoa, EnderecoCreateDTO endereco) throws Exception {
        endereco.setIdPessoa(pessoaService.getPessoa(idPessoa).getIdPessoa());

        EnderecoEntity enderecoEntity = objectMapper.convertValue(endereco, EnderecoEntity.class);
        EnderecoEntity enderecoEntityCriado = enderecoRepository.criarEndereco(idPessoa, enderecoEntity);
        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoEntityCriado, EnderecoDTO.class);

        PessoaDTO dto = getPessoaDTO(enderecoEntityCriado);

        emailService.enviarEmailEnderecoCriado(enderecoDTO, dto);

        return enderecoDTO;
    }

    public EnderecoDTO atualizarEndereco(Integer idEndereco, EnderecoCreateDTO enderecoAtualizar) throws Exception {
        EnderecoEntity enderecoEntityRecuperado = getEndereco(idEndereco);

        enderecoEntityRecuperado.setIdEndereco(idEndereco);
        enderecoEntityRecuperado.setTipo(enderecoAtualizar.getTipo());
        enderecoEntityRecuperado.setLogradouro(enderecoAtualizar.getLogradouro());
        enderecoEntityRecuperado.setNumero(enderecoAtualizar.getNumero());
        enderecoEntityRecuperado.setComplemento(enderecoAtualizar.getComplemento());
        enderecoEntityRecuperado.setCep(enderecoAtualizar.getCep());
        enderecoEntityRecuperado.setCidade(enderecoAtualizar.getCidade());
        enderecoEntityRecuperado.setEstado(enderecoAtualizar.getEstado());
        enderecoEntityRecuperado.setPais(enderecoAtualizar.getPais());
        // metodo criado pelo intelliJ
        PessoaDTO dto = getPessoaDTO(enderecoEntityRecuperado);

        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoEntityRecuperado, EnderecoDTO.class);
        emailService.enviarEmailEnderecoAtualizado(enderecoDTO, dto);

        return enderecoDTO;
    }


    public void deletarEndereco(Integer idEndereco) throws Exception {
        EnderecoEntity enderecoEntityRecuperado = getEndereco(idEndereco);
        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoEntityRecuperado, EnderecoDTO.class);
        // metodo criado pelo intelliJ
        PessoaDTO dto = getPessoaDTO(enderecoEntityRecuperado);

        emailService.enviarEmailEnderecoDeletado(enderecoDTO, dto);
        enderecoRepository.deletarEndereco(enderecoEntityRecuperado);
    }

    private PessoaDTO getPessoaDTO(EnderecoEntity enderecoEntityRecuperado) throws Exception {
        PessoaEntity pessoaEntity = pessoaService.getPessoa(enderecoEntityRecuperado.getIdPessoa());
        PessoaDTO dto = objectMapper.convertValue(pessoaEntity, PessoaDTO.class);
        dto = objectMapper.convertValue(dto, PessoaDTO.class);
        return dto;
    }

    // metodo para validar se o endereco existe, se não existir, lança uma exceção
    private EnderecoEntity getEndereco(Integer idEndereco) throws Exception {
        EnderecoEntity enderecoEntityRecuperado = enderecoRepository
                .listarTodos().stream()
                .filter(enderecoEntity -> enderecoEntity.getIdEndereco().equals(idEndereco))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não encontrado!"));
        return enderecoEntityRecuperado;
    }
}
