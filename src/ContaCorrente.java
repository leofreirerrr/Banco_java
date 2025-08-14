public class ContaCorrente {
    private final String numero; //
    protected double saldo; // protected porque a classe filha precisa acessar

    public ContaCorrente(String numero, double saldo){
        this.numero = numero;
        this.saldo = saldo;
    }

    public String getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void creditar(double valor){
        if(valor > 0){
            this.setSaldo(this.getSaldo()+valor);
        }else{
            System.out.println("Valor de crédito inválido: R$" + valor);
        }
    }

    public void debitar(double valor){
        if(valor > 0 && this.getSaldo() >= valor){
            this.setSaldo(this.getSaldo() - valor);
        }else{
            System.out.println("Saldo insuficiente ou valor inválido para o débito de R$" + valor);
        }
    }
}