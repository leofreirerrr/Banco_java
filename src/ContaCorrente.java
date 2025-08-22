public class ContaCorrente extends ContaAbstrata {

    public ContaCorrente(String numero) {
        // Chama o construtor da superclasse (ContaAbstrata)
        super(numero);
    }

    @Override
    public void creditar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            System.out.println("Crédito de R$" + String.format("%.2f", valor) + " realizado com sucesso.");
        } else {
            System.out.println("Valor de crédito inválido.");
        }
    }

    @Override
    public boolean debitar(double valor) {
        if (valor > 0 && this.saldo >= valor) {
            this.saldo -= valor;
            return true; // Apenas retorna sucesso
        }
        return false; // Apenas retorna falha
    }

    @Override
    public String toString() {
        return "Conta Corrente [Número: " + getNumero() + ", Saldo: R$" + String.format("%.2f", getSaldo()) + "]";
    }
}