public abstract class Conta implements IConta {

  private static int SEQUENCIAL = 1;
  private final int AGENCIA_PADRAO = 1;

  protected int agencia;
  protected int numero;
  protected double saldo;
  protected Cliente cliente;

  public Conta(Cliente cliente) {
    this.agencia = AGENCIA_PADRAO;
    this.numero = Conta.SEQUENCIAL++;
    this.cliente = cliente;
  }

  public void sacar(double valor) {
    this.saldo -= valor;
    if (saldo < valor) {
      System.out.println("Valor inválido, tente novamente.");
      saldo = 0;
    }
  }

  public void depositar(double valor) {
    this.saldo += valor;
  }

  public void transferir(double valor, Conta contaDestino) {
    this.sacar(valor);
    contaDestino.depositar(valor);
  }

  public int getAgencia() {
    return agencia;
  }

  public int getNumero() {
    return numero;
  }

  public double getSaldo() {
    return saldo;
  }

  protected void imprimirInfosComuns() {

    System.out.println(String.format("Cliente: %s", this.cliente.getNome()));
    System.out.println(String.format("Agencia: %d", this.agencia));
    System.out.println(String.format("Numero: %d", this.numero));
    System.out.println(String.format("Saldo: %.2f", this.saldo));
  }

}
