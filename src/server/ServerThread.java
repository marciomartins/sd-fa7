package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread {
	
	private ServerSocket servidor;

	public ServerThread() throws IOException {
		servidor = new ServerSocket(12345);
		System.out.println("Porta 12345 aberta");
		
		while (true) {
			//espera um cliente conectar e imprime o seu ip
			Socket cliente = servidor.accept();
			System.out.println("Nova conexão com o cliente " +
			  cliente.getInetAddress().getHostAddress());
			
			TratarConexaoServidorCompleto tratamento = new TratarConexaoServidorCompleto(cliente);
			
			Thread t = new Thread(tratamento);
			t.start();
		}
		
	}

}
