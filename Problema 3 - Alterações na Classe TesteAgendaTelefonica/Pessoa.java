 

import java.io.Serializable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pessoa implements Comparable<Pessoa>, Serializable {
	private String nome;                                            
	private String sobrenome;                                             
	private static BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

	public Pessoa(String nome, String sobrenome) {
		this.nome = nome;
		this.sobrenome = sobrenome;
	}

	public static Pessoa cadastrarPessoa() {
		String nome = null;
		String sobrenome = null;
		try {
			System.out.print("Ingresse o nome do contato: ");
			nome = teclado.readLine().trim();
			System.out.print("Ingresse o sobrenome do contato: ");
			sobrenome = teclado.readLine().trim();
		} catch(IOException e) {
			System.err.println("Erro lendo o nome.");
			e.printStackTrace();
			System.exit(1);
		}
		return new Pessoa(nome,sobrenome);
	}

	@Override
	public boolean equals(Object pessoa) {
		return compareTo((Pessoa)pessoa) == 0;
	}

	@Override
	public int hashCode() {
		return 7*nome.hashCode()+13*sobrenome.hashCode();
	}

	@Override
	public String toString() {
		return nome + " " + sobrenome;
	}

	// Compare Person objects
	public int compareTo(Pessoa pessoa) {
		int result = sobrenome.compareTo(pessoa.sobrenome);
		return result == 0 ? nome.compareTo(pessoa.nome) : result;
	}
}
