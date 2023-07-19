 

import java.io.Serializable;

class Cadastro implements Comparable<Cadastro>, Serializable {
	private Pessoa pessoa;
	private NumeroTelefonico numFone;

	public int compareTo(Cadastro entrada) {
		return pessoa.compareTo(entrada.getPessoa());
	}

	public Cadastro(Pessoa pessoa, NumeroTelefonico numFone) {
		this.pessoa = pessoa;
		this.numFone = numFone;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public NumeroTelefonico getNumFone() {
		return numFone;
	}

	@Override
	public String toString() {
		return pessoa.toString() + '\n' + numFone.toString();
	}

	public static Cadastro lerEntrada() {
		return new Cadastro(Pessoa.cadastrarPessoa(), NumeroTelefonico.lerNumTelefonico());
	}
}
