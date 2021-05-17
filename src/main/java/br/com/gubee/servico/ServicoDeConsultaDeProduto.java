package br.com.gubee.servico;

import br.com.gubee.dominio.FiltroDeProduto;
import br.com.gubee.dominio.entidade.Produto;
import br.com.gubee.dominio.repositorio.ProdutoRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoDeConsultaDeProduto {

    private ProdutoRepositorio produtoRepositorio;
    private FiltroDeProduto filtroDeProduto;

    public ServicoDeConsultaDeProduto(ProdutoRepositorio produtoRepositorio,
                                      FiltroDeProduto filtroDeProduto) {
        this.produtoRepositorio = produtoRepositorio;
        this.filtroDeProduto = filtroDeProduto;
    }

    public List<Produto> consultarTodos() {
        return this.produtoRepositorio.buscarTodos();
    }

    public List<Produto> filtrar(List<String> tecnologias, List<String> mercadosAlvos) {
        List<Produto> todosProdutos = this.produtoRepositorio.buscarTodos();

        return filtroDeProduto.filtrarProdutos(todosProdutos, tecnologias, mercadosAlvos);
    }
}