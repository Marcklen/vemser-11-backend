package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {

    private final ContatoRepository contatoRepository;

    public ContatoService(ContatoRepository contatoRepository) {
        this.contatoRepository = contatoRepository;
    }

    public Contato create(Integer idPessoa, Contato contato) throws Exception {
        getContato(idPessoa); // só para validar se a pessoa existe, se não existir, lança uma exceção
        contato.setIdPessoa(idPessoa);
        return contatoRepository.create(contato);
    }

    public List<Contato> lista() {
        return contatoRepository.list();
    }

    public Contato update(Integer id, Contato contatoAtualizar) throws Exception {
           Contato contatoRecuperado = getContato(id);
//           contatoRecuperado.setIdPessoa(contatoAtualizar.getIdPessoa());
           contatoRecuperado.setTipoContato(contatoAtualizar.getTipoContato());
           contatoRecuperado.setNumero(contatoAtualizar.getNumero());
           contatoRecuperado.setDescricao(contatoAtualizar.getDescricao());

        return contatoRecuperado;
    }

    public void delete(Integer id) throws Exception {
        Contato contatoRecuperado = getContato(id);
        contatoRepository.delete(contatoRecuperado);
    }

    public List<Contato> findByIdPessoa(Integer idPessoa) throws Exception {
        getContato(idPessoa);
        return contatoRepository.findByIdPessoa(idPessoa);
    }

    private Contato getContato(Integer id) throws Exception {
        Contato contatoRecuperado = contatoRepository.list().stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Contato não encontrado!"));
        return contatoRecuperado;
    }
}
