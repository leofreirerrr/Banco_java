/**
 * Classe abstrata que serve como molde para todos os tipos de conta.
 * Define os atributos e comportamentos comuns.
 */
public abstract class ContaAbstrata {

    protected String numero;
    protected double saldo;

    /**
     * Construtor para todas as contas.
     * @param numero O número da nova conta.
     */
    public ContaAbstrata(String numero) {
        this.numero = numero;
        this.saldo = 0.0; // Toda conta nova começa com saldo zero.
    }

    // Getters e Setters comuns a todas as contas
    public String getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // Método abstrato que força as classes filhas a se identificarem.
    public abstract String getTipoConta();
}