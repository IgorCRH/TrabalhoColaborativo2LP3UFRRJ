package Trabalho;
import java.util.ArrayList;

public class BalaDeCanhao{
	 private double posX;
	 private double posY;
	 private double velocEmX;
	 private double velocEmY;
	 private static final double GRAVIDADE = -9.81;
	 
	 public BalaDeCanhao() {
	 }
	 public BalaDeCanhao(double posX){
		 this.posX = posX;
		 this.posY = 0;
	 }
	 public void mover(double deltaSegundos) {
		 posX += velocEmX * deltaSegundos;
		 posY += velocEmY * deltaSegundos;
		 velocEmY += GRAVIDADE * deltaSegundos;
	 }
	 
	 public Ponto getLocalizacao(){
		 return new Ponto((int)posX, (int)posY);
	 }
	
	 public ArrayList<Ponto> atirar(double alpha, double v, int numPontosNoVoo){
		 double deltaSegundos;
		 alpha = alpha * Math.PI/180;
		 ArrayList<Ponto> pontos = new ArrayList<Ponto>(); 
		 velocEmX = v * Math.cos(alpha);
		 velocEmY = v * Math.sin(alpha);
		 System.out.println("Recalculando deltaSegundos para obter varios pontos");
		 deltaSegundos = (-2 * velocEmY/GRAVIDADE)/numPontosNoVoo;
		 do {
			 mover(deltaSegundos);
			 pontos.add(getLocalizacao() );
		 } while (posY >= 0);
		 return pontos;
	 }
}
