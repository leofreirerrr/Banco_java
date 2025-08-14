public class ContaPoupanca extends ContaCorrente{
    private final double taxaJuros = 0.01; // private pq ninguém fora da classe precisa acessar e final pq n vai mudar

    public ContaPoupanca(String n, double s) {
        super(n, s); // Chama o construtor da classe pai (ContaCorrente)
    }

    public void renderJuros(){
        double juros = this.saldo * this.taxaJuros; // Calcula os juros
        this.creditar(juros); // Credita os juros ao saldo
    }
}
