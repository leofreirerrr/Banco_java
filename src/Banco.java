import java.util.ArrayList;

public class Banco {
    /**
     * Usa um ArrayList para armazenar as contas de forma dinâmica.
     * Graças ao polimorfismo, esta lista pode conter objetos ContaCorrente,
     * ContaPoupanca e ContaEspecial.
     */
    private ArrayList<ContaCorrente> contas;

    /**
     * Construtor da classe Banco.
     * A única responsabilidade dele é inicializar a lista de contas para que
     * o programa não quebre ao tentar usá-la.
     */
    public Banco() {
        // Cria uma lista vazia quando um objeto Banco é instanciado.
        this.contas = new ArrayList<>();
    }

    /**
     * Adiciona um objeto de conta à lista de contas do banco.
     * @param c A conta a ser adicionada (pode ser de qualquer tipo herdado de ContaCorrente).
     */
    public void adicionarConta(ContaCorrente c) {
        // O método .add() do ArrayList cuida de todo o trabalho.
        this.contas.add(c);
        System.out.println("Conta " + c.getNumero() + " adicionada com sucesso!");
    }

    public ContaCorrente obterConta(String numConta) {
        for(ContaCorrente conta:this.contas){
            if(conta.getNumero().equals(numConta)){
                return conta;
            }
        }
        return null;
    }

    public void removerConta(String numConta) {
        ContaCorrente contaLixo = this.obterConta(numConta);

        if(numConta != null){
            contas.remove(numConta);
            System.out.println("Conta " + numConta + " excluída com sucesso!");
        }else{
            System.out.println("Conta não encontrada");
        }
    }

    public void exibirContas() {
        for(ContaCorrente conta:contas){
            System.out.println("------------------------------------");
            System.out.println("Número: " + conta.getNumero());
            System.out.printf("Saldo: R$ %.2f\n", conta.getSaldo());
        }
    }
}