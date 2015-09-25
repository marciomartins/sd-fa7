package client;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

import org.omg.CORBA.portable.UnknownException;

public class TratarConexaoClient  implements Runnable {
	
	Socket servidor;
	public TratarConexaoClient(Socket servidor){
		this.servidor = servidor;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			Scanner s = new Scanner(servidor.getInputStream());
			while (s.hasNextLine()){
				System.out.println(s.nextLine());
			}
		}catch (IOException e){
			
		}
	}
	

}
