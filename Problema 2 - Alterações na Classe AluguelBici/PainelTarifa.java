package tce2.problema2;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class PainelTarifa extends JPanel {
   private final double TARIFA_DIA = 3.50;
   private final double TARIFA_NOITE = 2.00;
   private final double TARIFA_FIM_SEMANA = 4.00;

   private JRadioButton dia; 
   private JRadioButton noite;
   private JRadioButton fimSemana;

   private ButtonGroup grupoBotoes;

   public PainelTarifa() {
      dia = new JRadioButton(String.format(
                                 "Durante-o-dia       ($%,.2f) por hora",
                                 TARIFA_DIA));

      noite = new JRadioButton(String.format(
                                 "Durante-a-noite   ($%,.2f) por hora",
                                 TARIFA_NOITE));

      fimSemana = new JRadioButton(String.format(
                                 "Fim-de-semana   ($%,.2f) por hora",
                                 TARIFA_FIM_SEMANA));

      grupoBotoes = new ButtonGroup();
      grupoBotoes.add(dia);
      grupoBotoes.add(noite);
      grupoBotoes.add(fimSemana);

      setLayout(new GridLayout(3, 1));

      setBorder(BorderFactory.createTitledBorder("Selecione uma "
      		+ "categoria de tarifa"));

      add(dia);
      add(noite);
      add(fimSemana);
   }

   public double pegarTarifa() {
      double tarifa = 0.0;

      if (dia.isSelected())
         tarifa = TARIFA_DIA;
      else if (noite.isSelected())
         tarifa = TARIFA_NOITE;
      else if (fimSemana.isSelected())
         tarifa = TARIFA_FIM_SEMANA;

      return tarifa;
   }
}
