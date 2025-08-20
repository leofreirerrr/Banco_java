import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Agora o Banco precisa saber o número máximo de contas de cada tipo
        Banco meuBanco = new Banco(100);
        boolean executando = true;

        while (executando) {
            System.out.println("\n===== MENU BANCO DIGITAL (v2) =====");
            System.out.println("1. Cadastrar Conta Corrente");
            System.out.println("2. Cadastrar Conta Poupança");
            System.out.println("3. Cadastrar Conta Especial");
            System.out.println("4. Exibir Todas as Contas");
            System.out.println("5. Realizar Depósito");
            System.out.println("6. Realizar Saque");
            System.out.println("7. Aplicar Juros (Poupança)");
            System.out.println("8. Sair");
            System.out.print(">> Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            // Os métodos de negócio agora são chamados a partir do Banco
            String numero;
            double valor;

            switch (opcao) {
                case 1:
                    System.out.print("Digite o número da nova Conta Corrente: ");
                    numero = scanner.nextLine();
                    meuBanco.adicionarContaCorrente(new ContaCorrente(numero));
                    break;
                case 2:
                    System.out.print("Digite o número da nova Conta Poupança: ");
                    numero = scanner.nextLine();
                    meuBanco.adicionarContaPoupanca(new ContaPoupanca(numero));
                    break;
                case 3:
                    System.out.print("Digite o número da nova Conta Especial: ");
                    numero = scanner.nextLine();
                    meuBanco.adicionarContaEspecial(new ContaEspecial(numero));
                    break;
                case 4:
                    meuBanco.exibirContas();
                    break;
                case 5: // Depósito
                    System.out.print("Digite o número da conta: ");
                    numero = scanner.nextLine();
                    System.out.print("Digite o valor do depósito: R$ ");
                    valor = scanner.nextDouble();
                    scanner.nextLine();
                    meuBanco.realizarDeposito(numero, valor);
                    break;
                case 6: // Saque
                    System.out.print("Digite o número da conta: ");
                    numero = scanner.nextLine();
                    System.out.print("Digite o valor do saque: R$ ");
                    valor = scanner.nextDouble();
                    scanner.nextLine();
                    meuBanco.realizarSaque(numero, valor);
                    break;
                case 7: // Juros
                    System.out.print("Digite o número da Conta Poupança: ");
                    numero = scanner.nextLine();
                    meuBanco.aplicarJuros(numero);
                    break;
                case 8:
                    executando = false;
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
        scanner.close();
    }
}