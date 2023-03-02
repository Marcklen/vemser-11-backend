package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/endereco") // http://localhost:8080/endereco
@Validated
public class EnderecoController {

    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping
    public ResponseEntity<List<Endereco>> listarTodos() {
        return new ResponseEntity<>(enderecoService.listarTodos(), HttpStatus.OK);
    }

    @GetMapping("/{idPessoa}/pessoa")
    public ResponseEntity<List<Endereco>> listarEnderecosPorPessoa(@PathVariable("idPessoa") Integer idPessoa)
            throws Exception {
        return new ResponseEntity<>(enderecoService.listarEnderecosPorIdPessoa(idPessoa), HttpStatus.OK);
    }

    @GetMapping("/{idEndereco}")
    public ResponseEntity<List<Endereco>> buscarEnderecoPorId(@PathVariable("idEndereco") Integer idEndereco)
            throws Exception {
        return new ResponseEntity<>(enderecoService.buscarEnderecoPorId(idEndereco), HttpStatus.OK);
    }

    @PostMapping("/{idPessoa}")
    public ResponseEntity<Endereco> create(@PathVariable("idPessoa") Integer idPessoa,
                                           @Valid @RequestBody Endereco endereco) throws Exception {
        return new ResponseEntity<>(enderecoService.criarEndereco(idPessoa, endereco), HttpStatus.CREATED);
    }

    @PutMapping("/{idEndereco}")
    public ResponseEntity<Endereco> atualizarEndereco(@PathVariable("idEndereco") Integer idEndereco,
                                                      @Valid @RequestBody Endereco enderecoAtualizar) throws Exception {
        return new ResponseEntity<>(enderecoService.atualizarEndereco(idEndereco, enderecoAtualizar), HttpStatus.OK);
    }

    @DeleteMapping("/{idEndereco}")
    public ResponseEntity<Void> deletarEndereco(@PathVariable("idEndereco") Integer idEndereco) throws Exception {
        enderecoService.deletarEndereco(idEndereco);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
