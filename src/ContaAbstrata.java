/**
 * A classe Abstrata serve como uma base para as outras classes que herdarem dela.
 * Os métodos declarados aqui devem ser sobrescritos pelas subclasses, e obrigatóriamente devem estar presentes
 */

public abstract class ContaAbstrata {
    private final String numero;
            protected double saldo;

    /**
     * Construtor para ContaAbstrata.
     * Define o número da conta e inicializa o saldo como 0.
     * O usuário não pode definir um saldo inicial.
     */
    public ContaAbstrata(String numero) {
        this.numero = numero;
        this.saldo = 0.0; // Saldo inicial é sempre zero
    }

    // Métodos abstratos que serão implementados e subclasses, elas terão que sobrescrever para cada tipo de conta
    public abstract void creditar(double valor);
    public abstract boolean debitar(double valor);


    public String getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public String toString() { //isso aqui serve para implementar um objeto diretamente, vai ser usado no exibircontas()
        return "Conta [Numero=" + numero + ", Saldo=" + String.format("%.2f", saldo) + "]";
    }
}