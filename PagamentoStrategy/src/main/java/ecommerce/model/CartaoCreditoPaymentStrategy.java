package main.java.ecommerce.model;

public class CartaoCreditoPaymentStrategy implements PagamentoStrategy{
    private String numCartao;
    private String dataValidade;
    private String codSeguranca;

    public CartaoCreditoPaymentStrategy(String numCartao, String dataValidade, String codSeguranca) {
        this.numCartao = numCartao;
        this.dataValidade = dataValidade;
        this.codSeguranca = codSeguranca;
    }

    @Override
    public void efetuarPagemento(double valor) {
        if (validarCartaoDeCredito()) {
            System.out.println("Pagamento com cartão de crédito efetuado.");
        } else {
            System.out.println("Falha no pagamento com cartão, tente novamente.");
        }
    }

    private boolean validarCartaoDeCredito() {
        // lógica de validação do cartão
        return true;
    }
}
