 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;

class NumeroTelefonico implements Serializable {
	private String codigoDDI;
	private String numComDDD;
	private static final long serialVersionUID = 1001L;
	private static BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

	public NumeroTelefonico(String codigoDDI, String numComDDD) {
		this.codigoDDI = codigoDDI;
		this.numComDDD = numComDDD;
	}

	public static NumeroTelefonico lerNumTelefonico() {
		String ddi = null;                                                
		String dddConNumFone = null;                                           
		try {
			System.out.print("Ingresse o DDI: ");
			ddi = teclado.readLine().trim();
			System.out.print("Ingresse o DDD: ");
			dddConNumFone = teclado.readLine().trim();
			System.out.print("Ingresse o número telefónico : ");
			dddConNumFone += " " + teclado.readLine().trim();
		} catch(IOException e) {
			System.err.println("Erro lendo o número telefónico.");
			e.printStackTrace();
			System.exit(1);
		}
		return new NumeroTelefonico(ddi, dddConNumFone);
	}

	@Override
	public String toString() {
		return codigoDDI + " " + numComDDD;
	}

	@Override
	public boolean equals(Object umNumero) {
		NumeroTelefonico n = (NumeroTelefonico)umNumero;
		return codigoDDI.equals(n.codigoDDI) && numComDDD.equals(n.numComDDD);
	}

	@Override
	public int hashCode() {
		return 7*codigoDDI.hashCode()+13*numComDDD.hashCode();
	}
}
