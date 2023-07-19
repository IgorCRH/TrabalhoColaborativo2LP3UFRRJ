import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AluguelBici extends JFrame {
    private PainelTarifa painelTarifa;
    private PainelTempo painelTempo;
    private JPanel painelBotao;
    private JButton botaoCalcular;
    private JButton botaoSair;
    private JTextField campoTotal; // novo campo de texto

    public AluguelBici() {
        setTitle("Aluguel de bicicletas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        painelTarifa = new PainelTarifa();
        painelTempo = new PainelTempo();
        campoTotal = new JTextField(10); // inicializa o campo de texto
        campoTotal.setEditable(false); // torna o campo de texto somente leitura

        montarPainelBotoes();

        add(painelTarifa, BorderLayout.NORTH);
        add(painelTempo, BorderLayout.CENTER);
        add(painelBotao, BorderLayout.SOUTH);
        add(campoTotal, BorderLayout.EAST); // adiciona o campo de texto à direita

        pack();
        setVisible(true);
    }

    private void montarPainelBotoes() {
        botaoCalcular = new JButton("Calcular pagamento");
        botaoCalcular.addActionListener(new OuvinteBotaoCalcular());
        botaoSair = new JButton("Sair");
        botaoSair.addActionListener(new OuvinteBotaoSair());
        painelBotao = new JPanel();
        painelBotao.add(botaoCalcular);
        painelBotao.add(botaoSair);
    }

    private class OuvinteBotaoCalcular implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            double tarifa = painelTarifa.pegarTarifa();
            double custoTotal = painelTempo.pegarMontoTotal(tarifa);
            campoTotal.setText(String.format("Monto total: $%,.2f", custoTotal));
        }
    }

    private class OuvinteBotaoSair implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}
