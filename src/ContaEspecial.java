public class ContaEspecial extends ContaCorrente{
    private double limiteCredito = 1000.0;

    public ContaEspecial(String n, double s) { // Construtor que usa os parâmetros da classe pai
        super(n, s);
    }

    @Override
    public void debitar(double valor){
        if((this.getSaldo() + limiteCredito) >= valor){
            this.setSaldo(this.getSaldo() - valor);
        } else {
            System.out.println("Saldo insuficiente para o débito de R$" + valor);
        }
    }
}
