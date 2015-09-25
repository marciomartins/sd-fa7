package server;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

import client.Client;
import util.EscritaUtils;
import util.LeituraUtils;
import entity.Cliente;
import entity.Filme;
import entity.Funcionario;
import entity.TipoCadastro;

public class TratarConexaoServidorCompleto implements Runnable {
	Socket c;
	PrintStream clientePrintStream;	
	
	public TratarConexaoServidorCompleto(Socket cliente) throws IOException {
		// TODO Auto-generated constructor stub
		c = cliente;
		clientePrintStream = new PrintStream(cliente.getOutputStream());
	}
	
	public void run() {
				Scanner s = null;
				try {
					s = new Scanner(c.getInputStream());
					while (s.hasNextLine()){
						String msg = s.nextLine();
						
						System.out.println(msg);
												
						TipoCadastro val = TipoCadastro.getValue(msg.substring(0,2));
						
						switch (val) {
						case CADASTRO_FILME: //
							  cadastrarFilme(msg.substring(1));
							break;
						case CADASTRO_CLIENTE: //
							  cadastrarCliente(msg.substring(1));
							break;
						case CADASTRO_FUNCIONARIO: //
							  cadastrarFuncionario(msg.substring(1));
							break;
						default:
							break;
						}
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	}

	private void cadastrarFilme(String msg) {
		// TODO Auto-generated method stub
		String nome = msg;
		String genero = "SIFI";
		String calssificacao = "Livre";
		Filme filme = new Filme(1, nome, genero, false, false, calssificacao);
		FileOutputStream file = null;
		try {
			file = new FileOutputStream(".\\Filmes.txt", true);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		EscritaUtils.escreverArquivoComOutpuStream(file, filme.toString());
		clientePrintStream.println("Cadastro realizado com sucesso.");
	}
	
	private void cadastrarCliente(String msg) {
		// TODO Auto-generated method stub
		String nome = msg;
		Cliente cli = new Cliente(1, nome);
		FileOutputStream file = null;
		try {
			file = new FileOutputStream(".\\Filmes.txt", true);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		EscritaUtils.escreverArquivoComOutpuStream(file, cli.toString());
		clientePrintStream.println("Cadastro realizado com sucesso.");
	}
	
	private void cadastrarFuncionario(String msg) {
		// TODO Auto-generated method stub
		String nome = msg;
		Funcionario fun = new Funcionario(1, nome, "");
		FileOutputStream file = null;
		try {
			file = new FileOutputStream(".\\Funcionário.txt", true);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		EscritaUtils.escreverArquivoComOutpuStream(file, fun.toString());
		clientePrintStream.println("Cadastro realizado com sucesso.");
	}

}
