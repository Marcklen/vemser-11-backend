/**
 *

package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.*;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/consultas") // http://localhost:8080/pessoa
@Validated
@Slf4j
@RequiredArgsConstructor
public class ConsultasController {

    private final PessoaRepository pessoaRepository;
    private final ContatoRepository contatoRepository;
    private final EnderecoRepository enderecoRepository;


    // http://localhost:8080/consultas/pessoas-nome?nome=maicon
    @GetMapping("/pessoas-nome")
    public ResponseEntity<List<PessoaEntity>> buscarPorNomeIgnoreCase(@RequestParam("nome") String nome) {
        return new ResponseEntity<>(pessoaRepository.findByNomeContainingIgnoreCase(nome), HttpStatus.OK);
    }

    // http://localhost:8080/consultas/pessoa?CPF=123
    @GetMapping("/pessoas-cpf")
    public ResponseEntity<List<PessoaEntity>> buscarPorCPFcontendo(@RequestParam("cpf") String cpf) {
        return new ResponseEntity<>(pessoaRepository.findByCpfContains(cpf), HttpStatus.OK);
    }

    // http://localhost:8080/consultas/pessoa?dataInicio=2020-01-01&dataFinal=2020-12-31
    @GetMapping("/pessoas-data-nascimento")
    public ResponseEntity<List<PessoaEntity>> buscarPorDataNascimentoEntre(
            @RequestParam("dataInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicio,
            @RequestParam("dataFinal") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal) {
        return new ResponseEntity<>(pessoaRepository.findByDataNascimentoBetween(dataInicio, dataFinal), HttpStatus.OK);
    }

    // http://localhost:8080/consultas/contato?tipoContato=COMERCIAL ou RESIDENCIAL
    @GetMapping("/contato")
    public ResponseEntity<List<ContatoEntity>> buscarPorTipoContato(@RequestParam("tipoContato") TipoContato tipoContato) {
        return new ResponseEntity<>(contatoRepository.findByTipoContato(tipoContato), HttpStatus.OK);
    }

    // http://localhost:8080/consultas/endereco/tipo?tipo=RESIDENCIAL
    @GetMapping("/endereco/tipo")
    public ResponseEntity<List<EnderecoEntity>> buscarPorTipoEndereco(@RequestParam("tipo") TipoEndereco tipoEndereco) {
        return new ResponseEntity<>(enderecoRepository.findByTipo(tipoEndereco), HttpStatus.OK);
    }

    // http://localhost:8080/consultas/endereco/CEP?CEP=12345678
    @GetMapping("/endereco/cep")
    public ResponseEntity<List<EnderecoEntity>> buscarPorCepOrdenacaoPorLogradouro(@RequestParam("cep") String cep) {
        return new ResponseEntity<>(enderecoRepository.findByCepOrderByLogradouro(cep), HttpStatus.OK);
    }
}
*/