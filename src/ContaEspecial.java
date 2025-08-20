/**
 * Representa uma conta especial com limite de crédito.
 * Herda de ContaAbstrata.
 */
public class ContaEspecial extends ContaAbstrata {

    private final double LIMITE_CREDITO = 1000.0; // [cite: 757, 759]

    public ContaEspecial(String numero) {
        super(numero);
    }

    // Método para que a classe Banco possa consultar o limite.
    public double getLimiteCredito() {
        return LIMITE_CREDITO;
    }

    @Override
    public String getTipoConta() {
        return "Conta Especial";
    }
}