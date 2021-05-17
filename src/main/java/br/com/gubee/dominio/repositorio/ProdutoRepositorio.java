package br.com.gubee.dominio.repositorio;

import br.com.gubee.dominio.entidade.Produto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProdutoRepositorio {

    public List<Produto> buscarTodos() {
        try {
            List<String> linhasDoArquivo = lerArquivo("./gubee-teste.json");

            String json = linhasDoArquivo.stream()
                    .collect(Collectors.joining());

            ObjectMapper objectMapper = new ObjectMapper();

            return objectMapper.readValue(json, new TypeReference<List<Produto>>(){});

        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler o arquivo.");
        }
    }

    private List<String> lerArquivo(String caminhoDoArquivo) {
        try {
            return Files.readAllLines(Paths.get("./gubee-teste.json"));
        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler o arquivo.");
        }
    }
}