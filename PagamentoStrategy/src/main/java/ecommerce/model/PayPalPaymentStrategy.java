package main.java.ecommerce.model;

public class PayPalPaymentStrategy implements PagamentoStrategy {
    private String email;
    private String password;

    public PayPalPaymentStrategy(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public void efetuarPagemento(double valor) {
        if (autenticarViaPayPal()) {
            System.out.println("Pagamento via PayPal efetuado com sucesso");
        } else {
            System.out.println("Falha no pagamento, verifique suas credenciais.");
        }

    }

    private boolean autenticarViaPayPal() {
        // lógica para validar email e senha
        return true;
    }
}
