import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      int optionMenu = 0;

      Cliente cliente = new Cliente();
      System.out.println("Digite seu nome: ");
      String nomeDoCliente = scanner.next();
      cliente.setNome(nomeDoCliente);
      System.out.println("Olá " + cliente.getNome() + " escolha uma opção: ");

      Conta cc = new ContaCorrente(cliente);
      Conta poupanca = new ContaPoupanca(cliente);
      

      do {
        System.out.println("""

            **************************************

                1 - Consultar Conta Corrente
                2 - Consultar Conta Poupanca
                3 - Depositar
                4 - Sacar
                5 - Transferir
                6 - Sair

            **************************************
                """);

        optionMenu = scanner.nextInt();

        switch (optionMenu) {
          case 1:
            cc.imprimirExtrato();
            break;
          case 2:
            poupanca.imprimirExtrato();
          default:
            break;
          case 3:
            System.out.println("Informe o valor a ser depositado: ");
            int depositarDinheiro = scanner.nextInt();
            cc.depositar(depositarDinheiro);
            break;
          case 4:
            System.out.println("Informe o valor a ser Sacado: ");
            int sacarDinheiro = scanner.nextInt();
            cc.sacar(sacarDinheiro);
            break;
          case 5:
            System.out.println("Informe o valor a ser Transferido: ");
            int transferirDinheiro = scanner.nextInt();
            cc.transferir(transferirDinheiro, poupanca);
        }
      } while (optionMenu != 6);
    }

  }
}
