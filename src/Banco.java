import java.util.ArrayList;

public class Banco {

    // Usa ArrayList para armazenar dinamicamente as contas
    private final ArrayList<ContaAbstrata> contas;

    public Banco() {
        this.contas = new ArrayList<>();
    }

    // Adiciona uma conta de qualquer tipo (Corrente, Poupanca, Especial)
    public void adicionarConta(ContaAbstrata conta) {
        this.contas.add(conta);
        System.out.println("Conta " + conta.getNumero() + " adicionada com sucesso.");
    }

    // Busca uma conta pelo número
    public ContaAbstrata obterConta(String numero) {
        for (ContaAbstrata conta : this.contas) {
            if (conta.getNumero().equals(numero)) {
                return conta;
            }
        }
        return null;
    }

    // Remove uma conta pelo número
    public boolean removerConta(String numero) {
        ContaAbstrata contaParaRemover = obterConta(numero);
        if (contaParaRemover != null) {
            return this.contas.remove(contaParaRemover);
        }else{
        return false;
        }
    }

    // Exibe todas as contas cadastradas
    public void exibirContas() {
        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta cadastrada.");
        } else {
            System.out.println("\n--- Lista de Contas ---");
            for (ContaAbstrata conta : this.contas) {
                // O método toString() correto será chamado devido ao polimorfismo
                System.out.println(conta.toString());
            }
            System.out.println("-----------------------\n");
        }
    }
}