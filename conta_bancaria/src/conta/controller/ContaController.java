package conta.controller;

import java.util.ArrayList;

import conta.model.Conta;
import conta.repository.ContaRepository;

public class ContaController implements ContaRepository {

	private ArrayList<Conta> listaContas = new ArrayList<Conta>();
	int numero = 0;
	@Override
	public void procurarporNumero(int numero) {
		Conta conta = buscarNaCollection(numero);
		
		if(conta != null)
			conta.visualizar();
		else
			System.out.println("A conta não foi encontrada!");
		
	}

	@Override
	public void listarTodas() {
		for(var conta : listaContas) {
			conta.visualizar();
		}
		
	}

	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println("A conta número: " + conta.getNumero() + "foi criada com sucesso!");
		
	}

	@Override
	public void atualizar(Conta conta) {
        var buscaconta = buscarNaCollection(numero);
		
		if(buscaconta != null) {
			listaContas.set(listaContas.indexOf(buscaconta), conta);
			System.out.println("Os dados da conta foram atualizados com sucesso");
		}else
			System.out.println("A conta não foi encontrada!");
		
	}

	@Override
	public void deletar(int numero) {
		
        Conta conta = buscarNaCollection(numero);
		
		if(conta != null) {
			if(listaContas.remove(conta) == true) //metdodo deletar
				System.out.println("A conta foi excluida!");
		}else
			System.out.println("A conta não foi encontrada!");
		
	}

	@Override
	public void sacar(int numero, float valor) {
        Conta conta = buscarNaCollection(numero);
		
		if(conta != null) {
			if(conta.sacar(valor) == true) // checar se o saque deu certo
				System.out.println("O saque foi efetuado com sucesso!");
		}else
			System.out.println("A conta não foi encontrada!");
		
	}

	@Override
	public void depositar(int numero, float valor) { //depositar metodo void pois nao retorna nada
        Conta conta = buscarNaCollection(numero);
		
		if(conta != null) {
			conta.depositar(valor); // 
				System.out.println("O depósito foi efetuado com sucesso!");
		}else
			System.out.println("A conta não foi encontrada!");
		
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
        Conta contaOrigem = buscarNaCollection(numeroOrigem);
        Conta contaDestino = buscarNaCollection(numeroDestino);
		
		if(contaOrigem != null && contaDestino != null) {
			if(contaOrigem.sacar(valor) == true) {
				contaDestino.depositar(valor);
				System.out.println("A transferencia foi efetuada com sucesso!");	                            
			}
		}else
			System.out.println("A conta não foi encontrada!");
		
	}
	
	/*Métdoos auxiliares*/
	public int gerarNumero() { // gerar numero da conta , contador 
		return ++ numero;
	}
		
	public Conta buscarNaCollection(int numero) {
		for(Conta conta : listaContas) {
			if(conta.getNumero() == numero) {
				return conta;
			}
		}
		return null;
	}
	public int retornaTipo(int numero) {
		for(Conta conta : listaContas) {
			if(conta.getNumero() == numero) {
				return conta.getTipo();
			}
		}
		return 0; // retorna numero nao pode ser null
	}
}

