/**
 * Representa uma conta poupança.
 * Herda de ContaAbstrata e possui uma taxa de juros.
 */
public class ContaPoupanca extends ContaAbstrata {

    private final double TAXA_JUROS = 0.01; // [cite: 752]

    public ContaPoupanca(String numero) {
        super(numero);
    }

    // Método para obter a taxa, pode ser útil para a classe Banco.
    public double getTaxaJuros() {
        return TAXA_JUROS;
    }

    @Override
    public String getTipoConta() {
        return "Conta Poupança";
    }
}