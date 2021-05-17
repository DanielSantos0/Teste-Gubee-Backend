package br.com.gubee.controller.response;


import java.util.List;

public class ProdutoResponse {

    private String productName;
    private String description;
    private List<String> targetMarket;
    private List<String> stack;

    public ProdutoResponse(String productName, String description, List<String> targetMarket, List<String> stack) {
        this.productName = productName;
        this.description = description;
        this.targetMarket = targetMarket;
        this.stack = stack;
    }

    public String getProductName() {
        return productName;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getTargetMarket() {
        return targetMarket;
    }

    public List<String> getStack() {
        return stack;
    }
}