package br.com.dbc.vemser.pessoaapi.repository.old;

import br.com.dbc.vemser.pessoaapi.entity.ContatoEntity;
import br.com.dbc.vemser.pessoaapi.service.PessoaService;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class ContatoRepositoryOld {

    // static para simular um banco de dados
    private static List<ContatoEntity> listaContatoEntities = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();
    private final PessoaService pessoaService;

    public ContatoRepositoryOld(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
//        listaContatoEntities.add(new ContatoEntity(COUNTER.incrementAndGet() /*1*/, 1, TipoContato.valueOf("RESIDENCIAL"), "85-98801-2345", "Casa"));
//        listaContatoEntities.add(new ContatoEntity(COUNTER.incrementAndGet() /*2*/, 1, TipoContato.valueOf("COMERCIAL"), "85-98112-6789", "Trabalho"));
//        listaContatoEntities.add(new ContatoEntity(COUNTER.incrementAndGet() /*3*/, 2, TipoContato.valueOf("RESIDENCIAL"), "85-98903-1023", "Casa"));
//        listaContatoEntities.add(new ContatoEntity(COUNTER.incrementAndGet() /*4*/, 2, TipoContato.valueOf("COMERCIAL"), "85-98804-4567", "whatsapp"));
//        listaContatoEntities.add(new ContatoEntity(COUNTER.incrementAndGet() /*5*/, 3, TipoContato.valueOf("RESIDENCIAL"), "85-98505-8910", "Casa"));
//        listaContatoEntities.add(new ContatoEntity(COUNTER.incrementAndGet() /*6*/, 3, TipoContato.valueOf("COMERCIAL"), "85-98906-1112", "Casa e Whatsapp"));
//        listaContatoEntities.add(new ContatoEntity(COUNTER.incrementAndGet() /*7*/, 4, TipoContato.valueOf("RESIDENCIAL"), "85-98327-1314", "Casa - Não Ligar por Favor"));
//        listaContatoEntities.add(new ContatoEntity(COUNTER.incrementAndGet() /*8*/, 4, TipoContato.valueOf("COMERCIAL"), "85-98258-1516", "trasnportadora"));
//        listaContatoEntities.add(new ContatoEntity(COUNTER.incrementAndGet() /*9*/, 5, TipoContato.valueOf("RESIDENCIAL"), "85-99909-1718", "casa"));
//        listaContatoEntities.add(new ContatoEntity(COUNTER.incrementAndGet() /*10*/, 5, TipoContato.valueOf("COMERCIAL"), "85-98810-1925", "casa e whatsapp"));
    }

    public ContatoEntity create(ContatoEntity contatoEntity) throws Exception {
        contatoEntity.setIdContato(COUNTER.incrementAndGet());
        listaContatoEntities.add(contatoEntity);
        return contatoEntity;
    }

    public List<ContatoEntity> list() {
        return listaContatoEntities;
    }

    public void delete(ContatoEntity contatoEntity) {
        listaContatoEntities.remove(contatoEntity);
    }

    public List<ContatoEntity> findByIdPessoa(Integer idPessoa) {
        return listaContatoEntities.stream()
//                .filter(contatoEntity -> contatoEntity.getIdPessoa().equals(idPessoa))
                .collect(Collectors.toList());
    }
}