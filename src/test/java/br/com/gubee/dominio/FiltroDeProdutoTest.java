package br.com.gubee.dominio;

import br.com.gubee.dominio.entidade.Produto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasItems;

public class FiltroDeProdutoTest {

    @Test
    public void deveFiltrarProdutosPorTecnologia() {

        FiltroDeProduto filtroDeProduto = new FiltroDeProduto();

        List<String> tecnologias1 = Arrays.asList("Tecnologia 1", "Tecnologia 2");
        Produto produto1 = new Produto("Produto 1", "Descrição 1", new ArrayList<>(), tecnologias1);
        List<String> tecnologias2 = Arrays.asList("Tecnologia 3", "Tecnologia 4");
        Produto produto2 = new Produto("Produto 2", "Descrição 2", new ArrayList<>(), tecnologias2);

        List<Produto> produtos = Arrays.asList(produto1, produto2);
        List<String> tecnologiasFiltro = Arrays.asList("Tecnologia 1");

        List<Produto> produtosFiltrados = filtroDeProduto.filtrarProdutos(produtos, tecnologiasFiltro, new ArrayList<>());

        assertThat(produtosFiltrados, hasItems(produto1));
    }

    @Test
    public void naoDeveRetornarProdutosQuandoTecnologiaNaoForEncontrada() {

        FiltroDeProduto filtroDeProduto = new FiltroDeProduto();

        List<String> tecnologias1 = Arrays.asList("Tecnologia 1", "Tecnologia 2");
        Produto produto1 = new Produto("Produto 1", "Descrição 1", new ArrayList<>(), tecnologias1);
        List<String> tecnologias2 = Arrays.asList("Tecnologia 3", "Tecnologia 4");
        Produto produto2 = new Produto("Produto 2", "Descrição 2", new ArrayList<>(), tecnologias2);

        List<Produto> produtos = Arrays.asList(produto1, produto2);
        List<String> tecnologiasFiltro = Arrays.asList("Tecnologia 5");

        List<Produto> produtosFiltrados = filtroDeProduto.filtrarProdutos(produtos, tecnologiasFiltro, new ArrayList<>());

        assertThat(produtosFiltrados, empty());
    }

    @Test
    public void deveFiltrarProdutosPorMercadoAlvo() {

        FiltroDeProduto filtroDeProduto = new FiltroDeProduto();

        List<String> mercadosAlvos1 = Arrays.asList("Mercado Alvo 1", "Mercado Alvo 2");
        Produto produto1 = new Produto("Produto 1", "Descrição 1", mercadosAlvos1, new ArrayList<>());
        List<String> mercadosAlvos2 = Arrays.asList("Mercado Alvo 3", "Mercado Alvo 4");
        Produto produto2 = new Produto("Produto 2", "Descrição 2", mercadosAlvos2, new ArrayList<>());

        List<Produto> produtos = Arrays.asList(produto1, produto2);
        List<String> mercadosAlvosFiltro = Arrays.asList("Mercado Alvo 3");

        List<Produto> produtosFiltrados = filtroDeProduto.filtrarProdutos(produtos, new ArrayList<>(), mercadosAlvosFiltro);

        assertThat(produtosFiltrados, hasItems(produto2));
    }

    @Test
    public void naoDeveRetornarProdutosQuandoMercadoAlvoNaoForEncontrada() {

        FiltroDeProduto filtroDeProduto = new FiltroDeProduto();

        List<String> mercadosAlvos1 = Arrays.asList("Mercado Alvo 1", "Mercado Alvo 2");
        Produto produto1 = new Produto("Produto 1", "Descrição 1", mercadosAlvos1, new ArrayList<>());
        List<String> mercadosAlvos2 = Arrays.asList("Mercado Alvo 3", "Mercado Alvo 4");
        Produto produto2 = new Produto("Produto 2", "Descrição 2", mercadosAlvos2, new ArrayList<>());

        List<Produto> produtos = Arrays.asList(produto1, produto2);
        List<String> mercadosAlvosFiltro = Arrays.asList("Mercado Alvo 5");

        List<Produto> produtosFiltrados = filtroDeProduto.filtrarProdutos(produtos, new ArrayList<>(), mercadosAlvosFiltro);

        assertThat(produtosFiltrados, empty());
    }
}