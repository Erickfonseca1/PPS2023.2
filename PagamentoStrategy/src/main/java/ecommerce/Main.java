package main.java.ecommerce;

import main.java.Produto;
import main.java.ecommerce.model.*;

public class Main {
    public static void main(String[] args) {
        // Criação de produtos
        Produto teclado = new Produto("teclado", 100.00);
        Produto mouse = new Produto("mouse", 50.00);

        // Criação do carrinho de compras
        CarrinhoCompras carrinho = new CarrinhoCompras();
        carrinho.adicionarProduto(teclado);
        carrinho.adicionarProduto(mouse);

        Pedido pedido = carrinho.fecharPedido();

        // Escolha do método de pagamento
        PagamentoStrategy mpPayPal = new PayPalPaymentStrategy("email.teste@teste.com", "senhateste123");
        // PagamentoStrategy mpCartao = new CartaoCreditoPaymentStrategy("1234-5678-9012-3456", "12/25", "123");

        // Definição do contexto de pagamento no carrinho
        ContextoPagamento contextoPayPal = new ContextoPagamento(mpPayPal);
        carrinho.setContextoPagamento(contextoPayPal);

        //ContextoPagamento contextoCartao = new ContextoPagamento(mpCartao);
        //carrinho.setContextoPagamento(contextoCartao);

        // Processa pagamento usando contexto
        carrinho.processarPagamento();
    }
}