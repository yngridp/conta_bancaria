package conta;


import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {
	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);

		int opcao, numero = 0, agencia, tipo, aniversario, numeroDestino;
		String titular;
		float saldo, limite, valor;
		
		
		ContaController contas = new ContaController();
		
		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João da Silva", 1000f, 100.0f);
        contas.cadastrar(cc1);

        ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 124, 1, "Maria da Silva", 2000f, 100.0f);
        contas.cadastrar(cc2);

        ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Mariana dos Santos", 4000f, 12);
        contas.cadastrar(cp1);

        ContaPoupanca cp2 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Juliana Ramos", 8000f, 15);
        contas.cadastrar(cp2);
		
		// tipo da agencia, numero da gencia
		
		
		/*ContaCorrente c1 = new ContaCorrente (1, 123, 1, "Yngrid Padilha", 10000.00f, 1000.00f);
		//metodo visualizar para mostrar todos os dados
		c1.visualizar();
		c1.sacar(1000);
		c1.visualizar();
		c1.depositar(2000);
		
		
		ContaPoupanca c2 = new ContaPoupanca (2, 1234, 2, "Stefani Padilha", 100000.00f, 27);
		c2.visualizar();
		
		
		//get mostra valor de uma propriedade especifica
		
		//consertar o nome // alterar dado  set*/

		while (true) {

			System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND + "*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                BANCO DO BRAZIL COM Z                ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Conta                          ");
			System.out.println("            2 - Listar todas as Contas               ");
			System.out.println("            3 - Buscar Conta por Numero              ");
			System.out.println("            4 - Atualizar Dados da Conta             ");
			System.out.println("            5 - Apagar Conta                         ");
			System.out.println("            6 - Sacar                                ");
			System.out.println("            7 - Depositar                            ");
			System.out.println("            8 - Transferir valores entre Contas      ");
			System.out.println("            9 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     " + Cores.TEXT_RESET);
             // se digitar opcao que nao seja um nuemro de 1 a 9
			try {
			    opcao = leia.nextInt();
			}catch(InputMismatchException e) {
				System.out.println("Digite valores inteiros!");
				leia.nextLine();
				opcao = 0;
			}

			if (opcao == 9) {
				System.out.println(Cores.TEXT_CYAN_BOLD + "Banco do Brazil com Z - O seu Futuro começa aqui!");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println("Criar Conta\n\n");

				System.out.println("Digite o Numero da Agência: ");
				agencia = leia.nextInt();
				System.out.println("Digite o Nome do Titular: ");
				leia.skip("\\R?");
				titular = leia.nextLine();

				do {
					System.out.println("Digite o Tipo da Conta (1-CC ou 2-CP): ");
					tipo = leia.nextInt();
				} while (tipo < 1 && tipo > 2);

				System.out.println("Digite o Saldo da Conta (R$): ");
				saldo = leia.nextFloat();

				switch (tipo) {
				case 1 :
				{
					System.out.println("Digite o Limite de Crédito (R$): ");
					limite = leia.nextFloat();
					// criar o objeto conta corrente
					contas.atualizar(new ContaCorrente(numero,agencia , tipo, titular, saldo, limite));
					break;

				}
				case 2 :
				{
					System.out.println("Digite o dia do Aniversario da Conta: ");
					aniversario = leia.nextInt();
					// criar o objeto conta poupanca
					contas.atualizar(new ContaPoupanca(numero,agencia , tipo, titular, saldo, aniversario));
					break;
                    
				}
				}
				
				keyPress();
				break;
			case 2:
				System.out.println("Listar todas as Contas\n\n");
				contas.listarTodas();
				
				keyPress();
				break;
			case 3:
				System.out.println("Consultar dados da Conta - por número\n\n");

				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();
				
				contas.procurarporNumero(numero);
				
				keyPress();
				break;
			case 4:
				System.out.println("Atualizar dados da Conta\n\n");

				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();
				
				if(contas.buscarNaCollection(numero) != null) {
					

				tipo = contas.retornaTipo(numero);
				// condicional buscar na collection

				System.out.println("Digite o Numero da Agência: ");
				agencia = leia.nextInt();
				System.out.println("Digite o Nome do Titular: ");
				leia.skip("\\R?");
				titular = leia.nextLine();

				System.out.println("Digite o Saldo da Conta (R$): ");
				saldo = leia.nextFloat();

				// retornar tipo

				switch (tipo) {
				case 1 :
				{
					System.out.println("Digite o Limite de Crédito (R$): ");
					limite = leia.nextFloat();
					break;

					// criar o objeto conta corrente
				}
				case 2 :
				{
					System.out.println("Digite o dia do Aniversario da Conta: ");
					aniversario = leia.nextInt();
					break;

					// criar o objeto conta poupanca

				}
				default : 
				{
					System.out.println("Tipo de conta inválido!");
					break;
				}
				
				}
				}else {
					System.out.println("A conta não goi encontrada!");
				}

				// fim do condicional buscar na collection
				
				keyPress();
				break;
			case 5:
				System.out.println("Apagar a Conta\n\n");

				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();
				
				contas.deletar(numero);
				
				keyPress();
				break;
			case 6:
				System.out.println("Saque\n\n");

				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();
				
				System.out.println("Digite o valor do Saque: ");
				valor = leia.nextFloat();
				
				contas.sacar(numero, valor);
        
				keyPress();
				break;
			case 7:
				System.out.println("Depósito\n\n");

				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();
				
				System.out.println("Digite o valor do Depósito: ");
				valor = leia.nextFloat();
				
				contas.depositar(numero, valor);
  
				keyPress();
				break;
			case 8:
				System.out.println("Transferência entre Contas\n\n");

				System.out.println("Digite o Numero da Conta de Origem: ");
				numero = leia.nextInt();
				System.out.println("Digite o Numero da Conta de Destino: ");
				numeroDestino = leia.nextInt();

				do {
					System.out.println("Digite o Valor da Transferência (R$): ");
					valor = leia.nextFloat();
				} while (valor <= 0);
 
				contas.transferir(numero, numeroDestino, valor);
				
				keyPress();
				break;
			default:
				System.out.println("\nOpção Inválida!\n");
				
				keyPress();
				break;
			}
		}
	}

	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Yngrid Padilha-yngrid_padilha@hotmail.com");
		System.out.println("github.com/yngridp");
		System.out.println("*********************************************************");
	}
	public static void keyPress() { //keypress para dar pausa no menu
		try {
			System.out.println(Cores.TEXT_RESET + "Pressione a tecla enter para continuar...");
			System.in.read(); 
		}catch(IOException e) {
			 System.out.println("Erro de digitação!");
		}
	}
}
