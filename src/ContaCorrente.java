/**
 * Representa uma conta corrente padrão.
 * Herda a estrutura básica da ContaAbstrata.
 */
public class ContaCorrente extends ContaAbstrata {

    public ContaCorrente(String numero) {
        // Chama o construtor da classe-mãe.
        super(numero);
    }

    @Override
    public String getTipoConta() {
        return "Conta Corrente";
    }
}