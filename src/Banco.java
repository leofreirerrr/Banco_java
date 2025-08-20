public class Banco {

    private ContaCorrente[] contasCorrentes;
    private ContaPoupanca[] contasPoupanca;
    private ContaEspecial[] contasEspeciais;

    private int indiceCC, indiceCP, indiceCE;

    public Banco(int maxContas) {
        this.contasCorrentes = new ContaCorrente[maxContas];
        this.contasPoupanca = new ContaPoupanca[maxContas];
        this.contasEspeciais = new ContaEspecial[maxContas];
        this.indiceCC = 0;
        this.indiceCP = 0;
        this.indiceCE = 0;
    }

    // MÉTODOS PARA ADICIONAR CONTAS
    public void adicionarContaCorrente(ContaCorrente c) {
        if (indiceCC < contasCorrentes.length) contasCorrentes[indiceCC++] = c;
    }
    public void adicionarContaPoupanca(ContaPoupanca c) {
        if (indiceCP < contasPoupanca.length) contasPoupanca[indiceCP++] = c;
    }
    public void adicionarContaEspecial(ContaEspecial c) {
        if (indiceCE < contasEspeciais.length) contasEspeciais[indiceCE++] = c;
    }

    // MÉTODO PARA OBTER QUALQUER TIPO DE CONTA
    public ContaAbstrata obterConta(String numConta) {
        for (int i = 0; i < indiceCC; i++) {
            if (contasCorrentes[i].getNumero().equals(numConta)) return contasCorrentes[i];
        }
        for (int i = 0; i < indiceCP; i++) {
            if (contasPoupanca[i].getNumero().equals(numConta)) return contasPoupanca[i];
        }
        for (int i = 0; i < indiceCE; i++) {
            if (contasEspeciais[i].getNumero().equals(numConta)) return contasEspeciais[i];
        }
        return null;
    }

    // MÉTODOS COM AS REGRAS DE NEGÓCIO
    public void realizarDeposito(String numConta, double valor) {
        ContaAbstrata conta = obterConta(numConta);
        if (conta != null && valor > 0) {
            conta.setSaldo(conta.getSaldo() + valor);
            System.out.println("Depósito realizado com sucesso.");
        } else {
            System.out.println("ERRO: Conta não encontrada ou valor inválido.");
        }
    }

    public void realizarSaque(String numConta, double valor) {
        ContaAbstrata conta = obterConta(numConta);
        if (conta == null || valor <= 0) {
            System.out.println("ERRO: Conta não encontrada ou valor inválido.");
            return;
        }

        double saldoDisponivel = conta.getSaldo();
        if (conta instanceof ContaEspecial) {
            saldoDisponivel += ((ContaEspecial) conta).getLimiteCredito();
        }

        if (saldoDisponivel >= valor) {
            conta.setSaldo(conta.getSaldo() - valor);
            System.out.println("Saque realizado com sucesso.");
        } else {
            System.out.println("ERRO: Saldo/Limite insuficiente.");
        }
    }

    public void aplicarJuros(String numConta) {
        ContaAbstrata conta = obterConta(numConta);
        if (conta instanceof ContaPoupanca) {
            ContaPoupanca cp = (ContaPoupanca) conta;
            double juros = cp.getSaldo() * cp.getTaxaJuros();
            cp.setSaldo(cp.getSaldo() + juros);
            System.out.println("Juros aplicados com sucesso.");
        } else {
            System.out.println("ERRO: A conta não é do tipo Poupança ou não foi encontrada.");
        }
    }

    // MÉTODO PARA EXIBIR TODAS AS CONTAS
    public void exibirContas() {
        System.out.println("\n--- LISTA DE CONTAS CADASTRADAS ---");
        for (int i = 0; i < indiceCC; i++) {
            System.out.println("------------------------------------");
            System.out.println("Tipo: " + contasCorrentes[i].getTipoConta());
            System.out.println("Número: " + contasCorrentes[i].getNumero());
            System.out.printf("Saldo: R$ %.2f\n", contasCorrentes[i].getSaldo());
        }
        for (int i = 0; i < indiceCP; i++) {
            System.out.println("------------------------------------");
            System.out.println("Tipo: " + contasPoupanca[i].getTipoConta());
            System.out.println("Número: " + contasPoupanca[i].getNumero());
            System.out.printf("Saldo: R$ %.2f\n", contasPoupanca[i].getSaldo());
        }
        for (int i = 0; i < indiceCE; i++) {
            System.out.println("------------------------------------");
            System.out.println("Tipo: " + contasEspeciais[i].getTipoConta());
            System.out.println("Número: " + contasEspeciais[i].getNumero());
            System.out.printf("Saldo: R$ %.2f\n", contasEspeciais[i].getSaldo());
            System.out.printf("Limite: R$ %.2f\n", ((ContaEspecial) contasEspeciais[i]).getLimiteCredito());
        }
        System.out.println("------------------------------------");
    }
}