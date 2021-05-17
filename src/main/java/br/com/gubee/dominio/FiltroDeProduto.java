package br.com.gubee.dominio;

import br.com.gubee.dominio.entidade.Produto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class FiltroDeProduto {

    public List<Produto> filtrarProdutos(List<Produto> todosProdutos,
                                         List<String> nomeDasTecnologiasParaSeremFiltradas,
                                         List<String> nomeDosMercadosAlvosParaSeremFiltradas) {

        return todosProdutos.stream()
                .filter(produto ->
                        contemTecnologia(produto.getTecnologias(), nomeDasTecnologiasParaSeremFiltradas)
                        ||
                        contemMercadoAlvo(produto.getMercadosAlvos(), nomeDosMercadosAlvosParaSeremFiltradas)
                )
                .collect(Collectors.toList());
    }

    private boolean contemTecnologia(List<String> tecnlogiasDoProduto, List<String> tecnologiasFiltro) {
        return Objects.nonNull(tecnologiasFiltro) && tecnlogiasDoProduto.stream()
                .anyMatch(tecnlogiaDoProduto -> tecnologiasFiltro.contains(tecnlogiaDoProduto));
    }

    private boolean contemMercadoAlvo(List<String> mercadosAlvosDoProduto, List<String> mercadosAlvosFiltro) {
        return Objects.nonNull(mercadosAlvosFiltro) && mercadosAlvosDoProduto.stream()
                .anyMatch(tecnlogiaDoProduto -> mercadosAlvosFiltro.contains(tecnlogiaDoProduto));
    }
}