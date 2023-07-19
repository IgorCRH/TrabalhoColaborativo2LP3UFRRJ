package tce2.problema2;

import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PainelTempo extends JPanel {
   private JTextField horas;   
   
   public PainelTempo() {
      JLabel mensagemHoras = new JLabel("Tempo em horas:");
      horas = new JTextField(10);
      
      setLayout(new GridLayout(1, 2));
      setBorder(BorderFactory.createTitledBorder("Duração do aluguel"));
      
      add(mensagemHoras);
      add(horas);
   }
   
   public double pegarMontoTotal(double tarifa) {
      double montoTotal = Double.parseDouble(horas.getText()) * tarifa;
      return montoTotal;
   }
}
