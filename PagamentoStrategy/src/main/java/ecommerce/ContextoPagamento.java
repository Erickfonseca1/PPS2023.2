package main.java.ecommerce;

import main.java.ecommerce.model.PagamentoStrategy;

public class ContextoPagamento {
    private PagamentoStrategy metodoPagamento;

    public ContextoPagamento(PagamentoStrategy metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public void processarPagamento(double valorTotal) {
        metodoPagamento.efetuarPagemento(valorTotal);
    }
}
