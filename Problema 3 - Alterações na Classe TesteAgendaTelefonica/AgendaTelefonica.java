 

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;


class AgendaTelefonica implements Serializable {
	private HashMap<Pessoa,Cadastro> mapaPessoas = new HashMap<>();
	private HashMap<NumeroTelefonico,Cadastro> mapaNumeros = new HashMap<>();
	private static final long serialVersionUID = 1001L;
	private Path arquivo = Paths.get(System.getProperty("user.home")).resolve("Agenda telefonica salva").resolve("AgendaTelefonica.bin");

	public void listarEntradas() {
		LinkedList<Cadastro> entradas = new LinkedList<>(mapaPessoas.values());
		Collections.sort(entradas);                                                                     

		for(Cadastro entrada : entradas) {
			System.out.println(entrada);
		}
	}
	@SuppressWarnings("unchecked")
	public AgendaTelefonica() {
		if(Files.exists(arquivo)) {                                                                       
			try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(Files.newInputStream(arquivo)))){
				mapaPessoas = (HashMap<Pessoa, Cadastro>)in.readObject();                                 
				mapaNumeros = (HashMap<NumeroTelefonico, Cadastro>)in.readObject();                       
			} catch(ClassNotFoundException | IOException e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
	}

	public void salvar() {
		try {
			Files.createDirectories(arquivo.getParent());                                                   
		} catch (IOException e) {
			System.err.println("Erro de I/O ao criar a pasta. " + e.getMessage());
			e.printStackTrace();
			System.exit(1);
		}
		try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(Files.newOutputStream(arquivo)))){
			System.out.println("Salvando a agenda telefónica");
			out.writeObject(mapaPessoas);
			out.writeObject(mapaNumeros);                                                                 
			System.out.println("Feito!");
		} catch(IOException e) {
			System.out.println("Erro de I/O ao salvar a agenda telefónica. " + e.getMessage());
			e.printStackTrace();
			System.exit(1);
		}
	}

	public void adicionarEntrada(Cadastro entrada) {
		mapaPessoas.put(entrada.getPessoa(), entrada);
		mapaNumeros.put(entrada.getNumFone(), entrada);
	}

	public Cadastro pegarEntrada(NumeroTelefonico chave) {
		return mapaNumeros.get(chave);
	}

	public Cadastro pegarEntrada(Pessoa chave) {
		return mapaPessoas.get(chave);
	}

	public NumeroTelefonico pegarNumero(Pessoa chave) {
		Cadastro entrada = pegarEntrada(chave);
		if(entrada != null) {
			return entrada.getNumFone();
		} else {
			return null;
		}
	}

	public Pessoa getPerson(NumeroTelefonico chave) {
		Cadastro entrada = pegarEntrada(chave);
		if(entrada != null) {
			return entrada.getPessoa();
		} else {
			return null;
		}
	}
}
