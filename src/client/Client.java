package client;

import java.io.Console;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.ConsoleHandler;

import entity.Filme;
import util.EscritaUtils;
import util.LeituraUtils;


public class Client {
	
	private static Socket cliente;
	private static PrintStream saida;

	public final static void clearConsole()
	{
	    try
	    {
	        final String os = System.getProperty("os.name");

	        if (os.contains("Windows"))
	        {
	            Runtime.getRuntime().exec("cls");
	        }
	        else
	        {
	            Runtime.getRuntime().exec("clear");
	        }
	    }
	    catch (final Exception e)
	    {
	        //  Handle any exceptions.
	    }
	}
	
	public static int menu() {

        int selection;
        Scanner input = new Scanner(System.in);
        System.out.println("Selecione uma opção");
        System.out.println("-------------------------\n");
        System.out.println("1 - Cadastro");
        System.out.println("2 - Listar");
        System.out.println("3 - Locar Filme");
        System.out.println("4 - Sair");

        selection = input.nextInt();
        return selection;    
    }
	
	public static int menuCadastro() {

        int selection;
        Scanner input = new Scanner(System.in);
        System.out.println("Selecione uma opção");
        System.out.println("-------------------------\n");
        System.out.println("1 - Filme");
        System.out.println("2 - Cliente");
        System.out.println("3 - Funcionário");
        System.out.println("4 - Menu Principal");
        System.out.println("5 - Sair");

        selection = input.nextInt();
        return selection;    
    }	
	
	public static void main(String[] args) throws IOException {
		
		cliente = new Socket("127.0.0.1", 12345);
		saida = new PrintStream(cliente.getOutputStream());
		System.out.println("O cliente se conectou ao servidor!");	
		
		int opcaoUsuario;
        //Scanner input = new Scanner(System.in);

        opcaoUsuario = menu();
        
        switch (opcaoUsuario) {
        case 1:
        	opcaoUsuario = menuCadastro();
        	switch (opcaoUsuario) {
        	case 1:
        		cadastrarFilme();
        		break;
        	case 2:
        		cadastrarCliente();
        		break;
        	case 3:
        		cadastrarFuncionario();
        		break;
        	case 4:
        		//
        		break;
        	case 5:
            	clearConsole();  
            	System.out.println("Sistema encerrado!"); 
        		break;        	
        	}
            break;
        case 2:
            // 
            break;
        case 3:
            
            menu();
            break;
        case 4:
        	clearConsole();  
        	System.out.println("Sistema encerrado!"); 
            break;
        default:
        	
        }
            // 
	}

	private static void cadastrarFuncionario() {
		// TODO Auto-generated method stub
		String nome = LeituraUtils.lerTecladoComInputStream("Nome do Funcionário: ");
		saida.println("13"+nome);			
	}

	private static void cadastrarCliente() {
		// TODO Auto-generated method stub
		String nome = LeituraUtils.lerTecladoComInputStream("Nome do Cliente: ");
		saida.println("12"+nome);	
	}

	private static void cadastrarFilme() {
		// TODO Auto-generated method stub
		String nome = LeituraUtils.lerTecladoComInputStream("Nome do Filme: ");
		saida.println("11"+nome);
		
	}
}
