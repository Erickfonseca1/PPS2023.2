package main.java.ecommerce.model;

import main.java.Produto;
import main.java.ecommerce.ContextoPagamento;
import main.java.ecommerce.model.Pedido;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoCompras {
    private List<Produto> produtos = new ArrayList<>();
    private ContextoPagamento contextoPagamento;

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public double calcularValorTotal() {
        double valorTotal = 0.0;

        // Iterar pelos produtos no carrinho e somar seus preços
        for (Produto produto : produtos) {
            valorTotal += produto.getPreco();
        }
        return valorTotal;
    }

    public Pedido fecharPedido() {
        double valorTotal = calcularValorTotal();
        return new Pedido(valorTotal);
    }

    public void setContextoPagamento(ContextoPagamento contextoPagamento) {
        this.contextoPagamento = contextoPagamento;

    }

    public void processarPagamento() {
        if (contextoPagamento != null) {
            double valorTotal = calcularValorTotal();
            System.out.println("Valor total do carrinho: " + valorTotal);
            contextoPagamento.processarPagamento(valorTotal);
        } else {
            System.out.println("Erro: Forma de pagamento não definida.");
        }
    }
}
