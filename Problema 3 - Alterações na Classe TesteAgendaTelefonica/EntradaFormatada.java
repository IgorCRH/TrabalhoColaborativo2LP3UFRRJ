 

import java.io.StreamTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class EntradaFormatada {
	private StreamTokenizer tokenizador = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
	private int ttipo;                                                  

	public int lerInt() throws ExcecaoEntradaDeUsuarioInvalida {
		if (lerToken() != StreamTokenizer.TT_NUMBER) {
			throw new ExcecaoEntradaDeUsuarioInvalida("lerInt() travou. O dado de entrada não é numérico");
		}

		if (tokenizador.nval > (double) Integer.MAX_VALUE || tokenizador.nval < (double) Integer.MIN_VALUE) {
			throw new ExcecaoEntradaDeUsuarioInvalida("lerInt() travou. O dado está fora do intervalo do tipo intt");
		}

		if (tokenizador.nval != (double) (int) tokenizador.nval) {
			throw new ExcecaoEntradaDeUsuarioInvalida("LerInt() travou. O dado não é inteiro");
		}
		return (int) tokenizador.nval;
	}

	public double lerDouble() throws ExcecaoEntradaDeUsuarioInvalida {
		if (lerToken() != StreamTokenizer.TT_NUMBER) {
			throw new ExcecaoEntradaDeUsuarioInvalida("lerDouble() travou. O dado não é numérico");
		}
		return tokenizador.nval;
	}

	public String lerString() throws ExcecaoEntradaDeUsuarioInvalida {
		if (lerToken() == StreamTokenizer.TT_WORD || ttipo == '\"' || ttipo == '\"') {
			return tokenizador.sval;
		} else {
			throw new ExcecaoEntradaDeUsuarioInvalida("lerString() travou. o dado não é string");
		}
	}

	// método auxiliar para ler o token seguinte
	private int lerToken() {
		try {
			ttipo = tokenizador.nextToken();
			return ttipo;

		} catch (IOException e) {                                          
			e.printStackTrace();
			System.exit(1);  // Finaliza o programa
		}
		return 0;
	}
}
