package util;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

public class EscritaUtils {
	public static void escreverArquivoComOutpuStream(FileOutputStream file, String conteudo){

		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(file);

		BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

		try {
			bufferedWriter.write(conteudo);
		} catch (IOException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}

		try {
			bufferedWriter.newLine();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		try {
			bufferedWriter.flush();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			bufferedWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//System.out.println("Feito!");

	}
	
	public static void escreverArquivoComPrintStream() throws FileNotFoundException{
		
		FileOutputStream file = new FileOutputStream("Exemplo2.txt");
		
		PrintStream printStream = new PrintStream(file);
		
		String conteudo = "Sistemas Distribuidos";
		
		printStream.println(conteudo);
		
		printStream.close();
		
	}
}
