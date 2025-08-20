import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("|======================|\n|  Bem vindo ao Banco  |\n|======================|");
        System.out.println("|==========================|\n|   Criar Conta Corrente   |\n|==========================|");
        Banco banco = new Banco();
        ContaCorrente contac1 = new ContaCorrente("1",0);
        banco.adicionarConta(contac1);

        ContaEspecial conta_esp = new ContaEspecial("2",0);
        ContaPoupanca conta_poup = new ContaPoupanca("3",0);

        boolean a = true;
        while (a){
            Scanner escolha = new Scanner(System.in);
            System.out.println("|===========================|\n| Selecione uma Opção       |\n|   1. Exibir Conta         |\n|   2. Creditar             |\n|   3. Debitar              |\n|                           |\n|   4. Criar Conta Especial |\n|   5. Criar Conta Poupança |\n|   6. Render Juros         |\n|===========================|");
            int opcao = escolha.nextInt();

            if (opcao == 1) {
                banco.exibirContas();
            }
            else if (opcao == 2) {
                System.out.println("Valor do crédito: ");
                Scanner valor = new Scanner(System.in);
                int valor_credito = valor.nextInt();
                contac1.creditar(valor_credito);
            }

            else if (opcao == 3) {
                Scanner conta = new Scanner(System.in);
                System.out.println("|==========================|\n" +
                        "| Escolha qual Conta usar: |\n" +
                        "|                          |\n" +
                        "| 1. Conta Corrente        |\n" +
                        "| 2. Conta Especial        |\n" +
                        "|==========================|");
                int opcao_conta = escolha.nextInt();
                if (opcao_conta == 1) {
                    System.out.println("Valor do débito: ");
                    Scanner valor = new Scanner(System.in);
                    int valor_debito = valor.nextInt();
                    contac1.debitar(valor_debito);
                }
                else if (opcao_conta == 2) {
                    System.out.println("Valor do débito: ");
                    Scanner valor = new Scanner(System.in);
                    int valor_debito = valor.nextInt();
                    conta_esp.debitar(valor_debito);
                }
            }
            else if (opcao == 4) {
                System.out.println("Conta Especial criada com sucesso!");
                banco.adicionarConta(conta_esp);
            }
            else if (opcao == 5) {
                System.out.println("Conta Poupanca criada com sucesso!");
                banco.adicionarConta(conta_poup);
            } else if (opcao == 6) {
                conta_poup.renderJuros();
            }
            System.out.println("|=====================|\n| Continuar? (s ou n) |\n|=====================|");
            String continuar = sc.nextLine();
            if (continuar.equals("N")||continuar.equals("n")){
                a = false;
            }


            System.out.println("Obrigado por usar o programa!! :)");
        }

//        ContaCorrente contac1 = new ContaCorrente(123,100);
//
//        Banco banco1 = new Banco();
//        banco1.adicionarConta(contac1);
    }
}