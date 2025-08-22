public class ContaEspecial extends ContaCorrente {

    // O limite de crédito é uma constante da classe
    //esse final significa que o valor não pode ser alterado
            private static final double LIMITE_CREDITO = 1000.00;

    public ContaEspecial(String numero) {
        // Chama o construtor da superclasse (ContaCorrente)
        super(numero);
    }

    /**
     * Sobrescreve o método debitar para considerar o limite de crédito.
     * O cliente pode sacar até o saldo + limite.
     */
    @Override
    public boolean debitar(double valor) {
        if (valor > 0 && (this.saldo + LIMITE_CREDITO) >= valor) {
            this.saldo -= valor;
            return true; // Apenas retorna sucesso
        }
        return false; // Apenas retorna falha
    }

    @Override
    public String toString() {
        return "Conta Especial [Número: " + getNumero() + ", Saldo: R$" + String.format("%.2f", getSaldo()) + ", Limite: R$" + String.format("%.2f", LIMITE_CREDITO) + "]";
    }
}