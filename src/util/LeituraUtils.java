package util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class LeituraUtils {

	public static String lerTecladoComInputStream() throws IOException {

		System.out.println("Digite aqui: ");

		InputStream in = System.in;

		InputStreamReader is = new InputStreamReader(in);

		BufferedReader br = new BufferedReader(is);

		String line = br.readLine();

		br.close();

		return line;

	}
	
	public static String lerTecladoComInputStream(String Msg)  {

		System.out.println(Msg);

		InputStream in = System.in;

		InputStreamReader is = new InputStreamReader(in);

		BufferedReader br = new BufferedReader(is);

		String line = null;
		try {
			line = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return line;

	}

	public static String lerArquivoComInputStream(FileInputStream file) throws IOException {


		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(file));

		String line = "";

		StringBuilder sb = new StringBuilder();

		while ((line = bufferedReader.readLine()) != null) {
			sb.append(line).append("\n");
		}

		bufferedReader.close();
		return sb.toString();
	}

	public static void lerTecladoComScanner() {

		Scanner in = new Scanner(System.in);

		System.out.print("Digite aqui: ");

		StringBuilder sb = new StringBuilder();

		while (in.hasNext()) {
			sb.append(in.next()).append(" ");
		}

		in.close();

		System.out.println(sb.toString());

		in.close();

	}

	public static void lerArquivoComScanner(FileInputStream file) {

		Scanner in = new Scanner(file);

		StringBuilder sb = new StringBuilder();

		while (in.hasNext()) {
			sb.append(in.next()).append(" ");
		}

		in.close();

		System.out.println(sb.toString());

	}

}
