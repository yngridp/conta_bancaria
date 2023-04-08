package conta.model;

public class ContaPoupanca extends Conta { //extends para chamar a heranca

	private int aniversario;
	
	public ContaPoupanca(int numero, int agencia, int tipo, String titular, float saldo, int aniversario) {
		super(numero, agencia, tipo, titular, saldo);
		
		this.aniversario = aniversario;
		
		
	}

	public int getAniversario() {
		return aniversario;
	}

	public void setAniversario(int aniversario) {
		this.aniversario = aniversario;
	}
	public boolean rendimento(float valor) {
		return false;
			
	}
	
	public void visualizar () {
		super.visualizar();
		System.out.println("Anivers�rio da Conta: " + this.aniversario);
	}

}
