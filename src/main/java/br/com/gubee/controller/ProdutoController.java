package br.com.gubee.controller;

import br.com.gubee.controller.response.ProdutoResponse;
import br.com.gubee.servico.ServicoDeConsultaDeProduto;
import br.com.gubee.dominio.entidade.Produto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/produtos")
@CrossOrigin("*")
public class ProdutoController {

    private ServicoDeConsultaDeProduto servicoDeConsultaDeProduto;

    public ProdutoController(ServicoDeConsultaDeProduto servicoDeConsultaDeProduto) {
        this.servicoDeConsultaDeProduto = servicoDeConsultaDeProduto;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<ProdutoResponse>> consultar(@RequestParam(required = false) List<String> tecnologias,
                                                           @RequestParam(required = false) List<String> mercadosAlvos) {

        List<Produto> produtos = new ArrayList<>();

        if ((Objects.nonNull(tecnologias) && !tecnologias.isEmpty()) || (Objects.nonNull(mercadosAlvos) && !mercadosAlvos.isEmpty())) {
            produtos = this.servicoDeConsultaDeProduto.filtrar(tecnologias, mercadosAlvos);
        } else {
            produtos = this.servicoDeConsultaDeProduto.consultarTodos();
        }

        List<ProdutoResponse> produtoResponses = produtos.stream()
                .map(produto -> new ProdutoResponse(produto.getNome(), produto.getDescricao(), produto.getMercadosAlvos(), produto.getTecnologias()))
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(produtoResponses);
    }
}
