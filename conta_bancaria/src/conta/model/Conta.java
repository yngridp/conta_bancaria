package conta.model;

public abstract class Conta {
   //atributos
	private int numero;
	private int agencia;
	private int tipo;
	private String titular;
	private float saldo; // double quando usa calculo muitas casas dps da virgula
	
	//metodo construtor mesmo nome da classe /Source /general construtor
	public Conta(int numero, int agencia, int tipo, String titular, float saldo) {
		this.numero = numero;
		this.agencia = agencia;
		this.tipo = tipo;
		this.titular = titular;
		this.saldo = saldo;
		
	}
// get e set / source / generat get and set
	//se não quiser alterar alteração não criar o metodo
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	public boolean sacar (float valor) {
		//checar se há saldo na conta
		if(this.getSaldo() < valor) {
			System.out.println("\nSaldo é insuficinete!");
			return false;
		}
		//alterando o valor do valor, com a dif do salor menos saque
		this.setSaldo(this.getSaldo() - valor);
		return true;
	}
	public void depositar(float valor) {
		this.setSaldo(this.getSaldo() + valor);
	}
	//imprimir todos os dados 
	public void visualizar() {
		String tipo = " ";
		
		switch(this.tipo) {
		case 1 :
			tipo = "Conta Corrente";
			break;
		case 2 :
			tipo = "Conta Poupança";
			break;
			
		}
		System.out.println("***************************************");
		System.out.println("             DADOS DA CONTA            ");
		System.out.println("***************************************");
		System.out.println("Numero da conta: " + this.numero);
		System.out.println("Numero da agencia: " + this.agencia);
		System.out.println("Tipo da conta: " + tipo);
		System.out.println("Numero do titular da conta: " + this.titular);
		System.out.println("Saldo da conta: " + this.saldo);
	}
	
}
