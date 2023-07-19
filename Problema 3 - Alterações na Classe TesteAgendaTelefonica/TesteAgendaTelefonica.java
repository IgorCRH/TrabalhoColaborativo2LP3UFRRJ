 

public class TesteAgendaTelefonica {
  public static void main(String[] args) {
    AgendaTelefonica book = new AgendaTelefonica();                                  
    EntradaFormatada in = new EntradaFormatada();                          
    Pessoa alguem;
    while(true) {
      System.out.println("Aperte 1 para cadastrar um contato telefónico\n"+
                         "Aperte 2 para localizar um telenome pelo nome\n"+
                         "Aperte 3 para listar toda a agenda telefónica\n" +
                         "Aperte 4 para localizar uma pessoa pelo número de telefone\n" +
                         "Aperte 9 para sair.");
      int escolha = 0;                                                    
      try {
        escolha = in.lerInt();

      } catch(ExcecaoEntradaDeUsuarioInvalida e) {
        System.out.println(e.getMessage() + "\nTente de novo.");
        continue;
      }

      switch(escolha) {
        case 1:
          book.adicionarEntrada(Cadastro.lerEntrada());
          book.salvar();
          break;
        case 2:
          alguem = Pessoa.cadastrarPessoa();
          Cadastro entrada = book.pegarEntrada(alguem);
          if(entrada == null) {
            System.out.println("O número de " + alguem + " não foi localizado.");
          } else {
            System.out.println("O numero de " + alguem + " é " + entrada.getNumFone());
          }
          break;
        case 3:
          book.listarEntradas();
          break;
        case 4:
          NumeroTelefonico numero = NumeroTelefonico.lerNumTelefonico();
          entrada = book.pegarEntrada(numero);
          if(entrada == null) {
            System.out.println("Ningué com o número " + numero + " foi localizado.");
          } else {
            System.out.println("O nome que corresponde ao número " + numero +
                                               " é " + entrada.getPessoa().toString());
          }
          break;
        case 9:
          book.salvar();
          System.out.println("Encerrando o programa.");
          return;
        default:
          System.out.println("Escolha inválida, tente de novo.");
          break;
      }
    }
  }
}
