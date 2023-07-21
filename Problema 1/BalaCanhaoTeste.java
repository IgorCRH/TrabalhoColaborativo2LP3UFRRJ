package Trabalho;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;

public class BalaCanhaoTeste {
    public static void main(String[] args) {
        System.out.println("Ingresse o angulo de lancamento: ");
        Scanner in = new Scanner(System.in);
        double angulo = in.nextDouble();
        System.out.println("Ingresse o valor da velocidade composta: ");
        double velocidade = in.nextDouble();
        BalaDeCanhao bala = new BalaDeCanhao(0.0);
        if(angulo < 10 || velocidade < 100) {
        	System.out.println("Condições de lançamento perigosas! Ajuste a velocidade de disparo ou ângulo");
        }else {
        ArrayList<Ponto> pontos = bala.atirar(angulo, velocidade, 19);
        
        BalaCanhaoAnimation animation = new BalaCanhaoAnimation(pontos);
        Dimension tamanhoJanela = new Dimension(2000, 1000);
        
        JFrame frame = new JFrame("Trajetória da Bala de Canhão");
        frame.setPreferredSize(tamanhoJanela);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(animation, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
        }
    }
}

