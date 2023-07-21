package Trabalho;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BalaCanhaoAnimation extends JPanel {
    private ArrayList<Ponto> pontos;
    private int pontoIndex;

    public BalaCanhaoAnimation(ArrayList<Ponto> pontos) {
        this.pontos = pontos;
        this.pontoIndex = 0;

        Timer timer = new Timer(500, new BalaCanhaoListener());
        timer.start();
    }
    
    class BalaCanhaoListener implements ActionListener{
    	@Override
    	public void actionPerformed(ActionEvent e) {
            if (pontoIndex < pontos.size()) {
                pontoIndex++;
                repaint();
            }
        }
    }
    

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        if (pontoIndex < pontos.size()) {
            Ponto ponto = pontos.get(pontoIndex);
            g2d.fillOval(ponto.posicaoX, getHeight() - ponto.posicaoY, 20, 20);
        }
    }
}
