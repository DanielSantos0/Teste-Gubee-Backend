package br.com.gubee.servico;

import br.com.gubee.dominio.FiltroDeProduto;
import br.com.gubee.dominio.repositorio.ProdutoRepositorio;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class ServicoDeConsultaDeProdutoTest {

    @Test
    public void deveChamarProdutoRepositorioUmaVezAoConsultarTodosProdutos() {

        ProdutoRepositorio produtoRepositorioMock = mock(ProdutoRepositorio.class);
        FiltroDeProduto filtroDeProdutoMock = mock(FiltroDeProduto.class);
        ServicoDeConsultaDeProduto servicoDeConsultaDeProduto = new ServicoDeConsultaDeProduto(produtoRepositorioMock, filtroDeProdutoMock);

        servicoDeConsultaDeProduto.consultarTodos();

        verify(produtoRepositorioMock, times(1)).buscarTodos();
    }

    @Test
    public void deveChamarProdutoRepositorioUmaVezAoFiltrarProdutos() {

        ProdutoRepositorio produtoRepositorioMock = mock(ProdutoRepositorio.class);
        FiltroDeProduto filtroDeProdutoMock = mock(FiltroDeProduto.class);
        ServicoDeConsultaDeProduto servicoDeConsultaDeProduto = new ServicoDeConsultaDeProduto(produtoRepositorioMock, filtroDeProdutoMock);

        servicoDeConsultaDeProduto.filtrar(new ArrayList<>(), new ArrayList<>());

        verify(produtoRepositorioMock, times(1)).buscarTodos();
    }

    @Test
    public void deveChamarFiltroDeProdutoUmaVezAoFiltrarProdutos() {

        ProdutoRepositorio produtoRepositorioMock = mock(ProdutoRepositorio.class);
        FiltroDeProduto filtroDeProdutoMock = mock(FiltroDeProduto.class);
        ServicoDeConsultaDeProduto servicoDeConsultaDeProduto = new ServicoDeConsultaDeProduto(produtoRepositorioMock, filtroDeProdutoMock);

        servicoDeConsultaDeProduto.filtrar(new ArrayList<>(), new ArrayList<>());

        verify(filtroDeProdutoMock, times(1)).filtrarProdutos(anyList(), anyList(), anyList());
    }
}
