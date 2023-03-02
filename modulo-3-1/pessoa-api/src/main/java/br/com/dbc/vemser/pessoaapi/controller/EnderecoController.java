package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco") // http://localhost:8080/endereco
public class EnderecoController {

    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping
    public List<Endereco> listarTodos() {
        return enderecoService.listarTodos();
    }

    @GetMapping("/{idPessoa}/pessoa")
    public List<Endereco> listarEnderecosPorPessoa(@PathVariable("idPessoa") Integer idPessoa) throws Exception {
        return enderecoService.listarEnderecosPorIdPessoa(idPessoa);
    }

    @GetMapping("/{idEndereco}")
    public List<Endereco> buscarEnderecoPorId(@PathVariable("idEndereco") Integer idEndereco) throws Exception {
        return enderecoService.buscarEnderecoPorId(idEndereco);
    }

    @PostMapping("/{idPessoa}")
    public Endereco create(@PathVariable("idPessoa") Integer idPessoa,
                           @RequestBody Endereco endereco) throws Exception {
        return enderecoService.criarEndereco(idPessoa, endereco);
    }

    @PutMapping("/{idEndereco}")
    public Endereco atualizarEndereco(@PathVariable("idEndereco") Integer idEndereco,
                                      @RequestBody Endereco enderecoAtualizar) throws Exception {
        return enderecoService.atualizarEndereco(idEndereco, enderecoAtualizar);
    }

    @DeleteMapping("/{idEndereco}")
    public void deletarEndereco(@PathVariable("idEndereco") Integer idEndereco) throws Exception {
        enderecoService.deletarEndereco(idEndereco);
    }
}
