import java.util.Scanner;

public class Main {

    // 1. Scanner único e estático para toda a classe
    private static final Scanner scanner = new Scanner(System.in);
    private static final Banco banco = new Banco();

    public static void main(String[] args) {
        System.out.println("|======================|\n|  Bem-vindo ao Banco  |\n|======================|");

        int opcao;
        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer após ler o número

            switch (opcao) {
                case 1:
                    cadastrarConta();
                    break;
                case 2:
                    creditarValor();
                    break;
                case 3:
                    debitarValor();
                    break;
                case 4:
                    banco.exibirContas();
                    break;
                case 5:
                    removerConta();
                    break;
                case 6:
                    renderJuros();
                    break;
                case 7:
                    consultarSaldo();
                    break;
                case 0:
                    System.out.println("\nObrigado por usar o nosso sistema! :)");
                    break;
                default:
                    System.out.println("\nOpção inválida. Por favor, tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    public static void exibirMenu() {
        System.out.println("\n|===========================|");
        System.out.println("|   Selecione uma Opção     |");
        System.out.println("|---------------------------|");
        System.out.println("| 1. Cadastrar nova conta   |");
        System.out.println("| 2. Creditar valor         |");
        System.out.println("| 3. Debitar valor          |");
        System.out.println("| 4. Exibir todas as contas |");
        System.out.println("| 5. Remover conta          |");
        System.out.println("| 6. Render Juros Poupança  |");
        System.out.println("| 7. Consultar Saldo        |");
        System.out.println("| 0. Sair do Sistema        |");
        System.out.println("|===========================|");
        System.out.print("Escolha uma opção: ");
    }

    private static void cadastrarConta() {
        System.out.println("\n--- Cadastro de Conta ---");
        System.out.print("Digite o número da nova conta: ");
        String numero = scanner.nextLine();

        // Verifica se a conta já existe
        if (banco.obterConta(numero) != null) {
            System.out.println("Erro: Já existe uma conta com este número.");
            return;
        }

        System.out.println("Tipo de conta:\n 1-Corrente\n 2-Poupança\n 3-Especial");
        System.out.print("Escolha o tipo: ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        ContaAbstrata novaConta;
        switch (tipo) {
            case 1:
                novaConta = new ContaCorrente(numero);
                break;
            case 2:
                novaConta = new ContaPoupanca(numero);
                break;
            case 3:
                novaConta = new ContaEspecial(numero);
                break;
            default:
                System.out.println("Tipo de conta inválido. Cadastro cancelado.");
                return;
        }
        banco.adicionarConta(novaConta);
    }

    private static void consultarSaldo() {
        System.out.print("\nDigite o número da conta para consultar o saldo: ");
        String numero = scanner.nextLine();

        // Procura a conta no banco
        ContaAbstrata conta = banco.obterConta(numero);

        // Se a conta for encontrada, exibe o saldo
        if (conta != null) {
            System.out.println("------------------------------------");
            // O método getSaldo() já existe na ContaAbstrata e é herdado por todas as contas
            System.out.println("Saldo da Conta " + conta.getNumero() + ": R$ " + String.format("%.2f", conta.getSaldo()));
            System.out.println("------------------------------------");
        } else {
            // Se não encontrar, informa o usuário
            System.out.println("Erro: Conta não encontrada.");
        }
    }

    private static void creditarValor() {
        System.out.print("\nDigite o número da conta para creditar: ");
        String numero = scanner.nextLine();

        // 1. Primeiro, verifica se a conta existe
        ContaAbstrata conta = banco.obterConta(numero);

        if (conta != null) {
            // 2. Se a conta foi encontrada, SÓ ENTÃO pede o valor
            System.out.print("Conta encontrada. Digite o valor a ser creditado: ");
            double valor = scanner.nextDouble();
            scanner.nextLine(); // Limpar buffer

            // 3. Realiza a operação
            conta.creditar(valor); // Este método já imprime o sucesso ou falha do crédito

        } else {
            // Se a conta não foi encontrada, informa o erro e volta ao menu
            System.out.println("Erro: Conta não encontrada.");
        }
    }

    private static void debitarValor() {
        System.out.print("\nDigite o número da conta para debitar: ");
        String numero = scanner.nextLine();

        // 1. Primeiro, verifica se a conta existe
        ContaAbstrata conta = banco.obterConta(numero);

        if (conta != null) {
            // 2. Se a conta foi encontrada, SÓ ENTÃO pede o valor
            System.out.print("Conta encontrada. Digite o valor a ser debitado: ");
            double valor = scanner.nextDouble();
            scanner.nextLine(); // Limpar buffer

            // 3. Tenta realizar a operação e usa a resposta (true/false)
            if (conta.debitar(valor)) {
                System.out.println("Débito de R$" + String.format("%.2f", valor) + " realizado com sucesso.");
            } else {
                System.out.println("Operação falhou. Saldo/Limite insuficiente ou valor inválido.");
            }

        } else {
            // Se a conta não foi encontrada, informa o erro e volta ao menu
            System.out.println("Erro: Conta não encontrada.");
        }
    }

    private static void removerConta() {
        System.out.print("\nDigite o número da conta a ser removida: ");
        String numero = scanner.nextLine();
        banco.removerConta(numero);
    }

    private static void renderJuros() {
        System.out.print("\nDigite o número da conta poupança para render juros: ");
        String numero = scanner.nextLine();

        // 1. Primeiro, verifica se a conta existe
        ContaAbstrata conta = banco.obterConta(numero);

        if (conta != null) {
            // 2. Se existe, verifica se é do tipo correto
            if (conta instanceof ContaPoupanca) {
                // 3. Se for, realiza a operação (não precisa de mais inputs)
                ((ContaPoupanca) conta).renderJuros();
            } else {
                System.out.println("Erro: Esta operação é válida apenas para Contas Poupança.");
            }
        } else {
            // Se a conta não foi encontrada, informa o erro e volta ao menu
            System.out.println("Erro: Conta não encontrada.");
        }
    }
}