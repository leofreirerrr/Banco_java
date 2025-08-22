// FONTES: Herança PII.pdf

public class ContaPoupanca extends ContaCorrente {

    // A taxa de juros é uma constante da classe
    private static final double TAXA_JUROS = 0.005; // 0.5%

    public ContaPoupanca(String numero) {
        // Chama o construtor da superclasse (ContaCorrente)
        super(numero);
    }

    /**
     * Calcula o juro com base na taxa e no saldo atual,
     * e credita o valor na própria conta.
     */
    public void renderJuros() {
        double juros = this.getSaldo() * TAXA_JUROS;
        this.creditar(juros);
        System.out.println("Juros de R$" + String.format("%.2f", juros) + " rendeu na conta " + getNumero());
    }

    @Override
    public String toString() {
        return String.format("Conta Poupança: [Número: %s , Saldo: R$ %.2f]", getNumero(), getSaldo());
    }
}