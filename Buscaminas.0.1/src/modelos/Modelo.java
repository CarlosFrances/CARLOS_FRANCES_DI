package modelos;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class Modelo {

	final public static URL ICONO=Modelo.class.getResource("/rec/mina2.png");
	final public static URL BANDERA=Modelo.class.getResource("/rec/flag.jpg");
	static public Image cargar(URL url)
	{
		return new ImageIcon(url).getImage();
	}
	
	private boolean[][]botones = new boolean[8][8];
	public void inicializarTablaBoolean()
	{
		for (int i = 0; i < botones.length; i++) {
			for (int j = 0; j < botones.length; j++) {
				botones[i][j]=false;
			}
			
		}
	}
	public boolean isMina(int i,int j)
	{
		return botones[i][j]==true;
	}
	private final int LADO=8;
	boolean isValido(int i, int j)
	{
		return (i >= 0) && (i < LADO) &&  (j >= 0) && (j < LADO);
	}
	public boolean getValido(int i,int j)
	{
		return (i >= 0) && (i < LADO) &&  (j >= 0) && (j < LADO);
	}
	
	public int[] generarMinas() {
		int[] z=new int[2];
		int a;
		int b;
			while(true)
			{
				a=(int)(Math.random()*8);
				b=(int)(Math.random()*8);
				if(!botones[a][b])
				{
					botones[a][b]=true;//BOMBA = TRUE
					z[0]=a;
					z[1]=b;
					break;
				}
			}
			return z;
	}

	public boolean[][] inicializarTablaMinas(boolean[][] l) {
		boolean[][] minas=l.clone();
		for (int i = 0; i < minas.length; i++) {
			for (int j = 0; j < minas.length; j++) {
				minas[i][j]=false;
			}
		}
		return minas;
	}
 
	public boolean comprobarMina(int i, int j) {
		return botones[i][j]==true;
	}

	public int numerarCasillas(int i, int j) {
		int contador=0;
		
		if(isValido(i-1,j)) //CASILLA NORTE
			if (isMina(i-1, j))
				contador++;
		
		if(isValido(i+1,j)) //CASILLA SUR
			if (isMina(i+1, j))
				contador++;
		
		if(isValido(i,j+1)) //CASILLA ESTE
			if (isMina(i, j+1))
				contador++;
		
		if(isValido(i,j-1)) //CASILLA OESTE
			if (isMina(i, j-1))
				contador++;
		
		if(isValido(i-1,j+1)) //CASILLA NOR-ESTE
			if (isMina(i-1, j+1))
				contador++;
		
		if(isValido(i-1,j-1)) //CASILLA NOR-OESTE
			if (isMina(i-1, j-1))
				contador++;
		
		if(isValido(i+1,j+1)) //CASILLA SUR-ESTE
			if (isMina(i+1, j+1))
				contador++;
		
		if(isValido(i+1,j-1)) //CASILLA SUR-OESTE
			if (isMina(i+1, j-1))
				contador++;
		
		return contador;
	}
	
	public int numerarAlrededor(int i, int j, Integer n) {
		int contador=0;
		if(n==0&&isValido(i-1,j))
			contador=numerarCasillas(i-1,j);
		
		if(n==0&&isValido(i+1,j))
			contador=numerarCasillas(i+1,j);
		
		if(n==0&&isValido(i,j+1))
			contador=numerarCasillas(i,j+1);
		
		if(n==0&&isValido(i,j-1))
			contador=numerarCasillas(i,j-1);
		
		if(n==0&&isValido(i-1,j+1))
			contador=numerarCasillas(i-1,j+1);
		
		if(n==0&&isValido(i-1,j-1))
			contador=numerarCasillas(i-1,j-1);
		
		if(n==0&&isValido(i+1,j+1))
			contador=numerarCasillas(i+1,j+1);
		
		if(n==0&&isValido(i+1,j+1))
			contador=numerarCasillas(i+1,j+1);
		
		return contador;
	}

	public void reiniciar() {
		inicializarTablaBoolean();
	}

	public boolean comprobarVictoria(JButton[][] botones) {
		int contador=0;
		for (int i = 0; i < botones.length; i++) {
			for (int j = 0; j < botones.length; j++) {
				if(botones[i][j].isEnabled()==false)
					contador++;
			}	
		}
		return contador==53;
	}


	public void rodear(int i, int j, JButton[][] botones) {
		if(isValido(i-1,j)) //CASILLA NORTE
			botones[i-1][j].setEnabled(false);
		
		if(isValido(i+1,j)) //CASILLA SUR
			botones[i+1][j].setEnabled(false);
		
		if(isValido(i,j+1)) //CASILLA ESTE
			botones[i][j+1].setEnabled(false);
		
		if(isValido(i,j-1)) //CASILLA OESTE
			botones[i][j-1].setEnabled(false);
		
		if(isValido(i-1,j+1)) //CASILLA NOR-ESTE
			botones[i-1][j+1].setEnabled(false);
		
		if(isValido(i-1,j-1)) //CASILLA NOR-OESTE
			botones[i-1][j-1].setEnabled(false);
		
		if(isValido(i+1,j+1)) //CASILLA SUR-ESTE
			botones[i+1][j+1].setEnabled(false);
		
		if(isValido(i+1,j-1)) //CASILLA SUR-OESTE
			botones[i+1][j-1].setEnabled(false);
	}	
}

