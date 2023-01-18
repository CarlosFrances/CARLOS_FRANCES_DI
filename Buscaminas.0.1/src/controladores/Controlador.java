package controladores;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import modelos.Modelo;
import vistas.Vista;

public class Controlador {
	private Modelo m;
	private Vista v;
	private boolean terminado=false;
	Thread timer=new Thread();
	
	private Integer contMinas=10;
	public void restarContMinas()
	{
		this.contMinas--;
	}
	boolean[][] minas=new boolean[8][8];
	boolean[][] identificadas=new boolean[8][8];
	public Controlador(Modelo m, Vista v) throws IOException
	{
		
		this.m = m;
		this.v = v;

		 //TABLA DE MINAS
		 minas=new boolean[v.length()][v.length()];
		minas=m.inicializarTablaMinas(minas);
		//Generar minas
		m.inicializarTablaBoolean();
		for (int i = 0; i < 10; i++)
		{
			int[] a=m.generarMinas();
			minas[a[0]][a[1]]=true;
		}
		
		//Modificaciones de la vista
		v.setIconImage(Modelo.cargar(Modelo.ICONO));
		v.getMinasIdentificadas().setForeground(Color.RED);
		v.getMinasIdentificadas().setText(this.contMinas.toString());
		
		BufferedImage wPic = ImageIO.read(this.getClass().getResource("/rec/flag.jpg"));
		JLabel wIcon = new JLabel(new ImageIcon(wPic));
		v.getFlag().setIcon(wIcon.getIcon());
		//Añadir escuchadores
		for (int i = 0; i < v.length(); i++) {
			for (int j = 0; j < v.length(); j++) {
				
				v.getBotonij(i, j).addActionListener(new botonesClick(i,j));
				v.getBotonij(i, j).addMouseListener (new MouseAdapter(){
					 @Override
					 public void mouseClicked(MouseEvent e){
						 if(terminado==false)
						 {
							 
							JButton jb=(JButton) e.getSource();
							if(jb.getBackground().equals(Color.green))
								jb.setBackground(Color.lightGray);
							
							else jb.setBackground(Color.green);
						 }	 
					}
				});
				v.getBotonij(i,j).addPropertyChangeListener(this::contarIndicadores);
			}	
		}
		
		v.getBotonReiniciar().addActionListener(this::reiniciar);
		//Acciones
	}



	/* MOVER DATOS A LA VISTA */

	/* METODOS PRIVADOS */
	private void reiniciar(ActionEvent e) {
		m.reiniciar();
		terminado=false;
		minas=m.inicializarTablaMinas(minas);
			for (int i = 0; i < v.length(); i++) {
				for (int j = 0; j < v.length(); j++) {
					v.getBotonij(i, j).setEnabled(true);
					v.getBotonij(i, j).setBackground(Color.LIGHT_GRAY);
					v.getBotonij(i, j).setText("");
					m.inicializarTablaBoolean();
					for (int w = 0; w < 10; w++) {
						int[] a=m.generarMinas();
						minas[a[0]][a[1]]=true;
					}	
				}
			}
		v.getjLabel1().setForeground(Color.CYAN);
	}
	
	/* ******************************************************* */
	/* EVENTOS                                                 */
	/* ******************************************************* */
	
	private void contarIndicadores(PropertyChangeEvent evt) {
		int con=0;
		for (int i = 0; i < minas.length; i++) {
			for (int j = 0; j < minas.length; j++) {
				if(v.getBotonij(i, j).getBackground().equals(Color.GREEN)&&v.getBotonij(i, j).isEnabled())
					con++;
			}
		}
		
		this.contMinas=10-con;
		v.getMinasIdentificadas().setText(contMinas.toString());

		if(this.terminado) v.getMinasIdentificadas().setText("");
	}

	private class botonesClick implements ActionListener {

		private int i;
		private int j;
		
		public botonesClick(int i, int j) {
			this.i=i;
			this.j=j;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			Integer n;
			String s;
			if(v.getBotonij(i, j).getBackground().equals(Color.green))
			{
				JButton nuevoBoton = v.getBotonij(i, j);
				nuevoBoton.setBackground(Color.lightGray);
				v.setBotonesij(i,j,nuevoBoton);
			}
			else if(m.comprobarMina(i,j))
			{
				perder();
			}
			else 
			{
				if(m.comprobarVictoria(v.getBotones())==true)
					v.getjLabel1().setForeground(Color.magenta);
		
				v.getBotonij(i, j).setEnabled(false);
				n=m.numerarCasillas(i,j);
				s=n.toString();
				v.getBotonij(i, j).setText(s);
				if(n==0)
				{
					if(m.getValido(i-1, j))
					{
						n=m.numerarCasillas(i-1,j);
						s=n.toString();
						v.getBotonij(i-1, j).setText(s);
						v.getBotonij(i-1, j).setEnabled(false);
					}
					
					if(m.getValido(i+1, j))
					{
						n=m.numerarCasillas(i+1,j);
						s=n.toString();
						v.getBotonij(i+1, j).setText(s);
						v.getBotonij(i+1, j).setEnabled(false);
						}
					
					if(m.getValido(i, j+1))
					{
						n=m.numerarCasillas(i,j+1);
						s=n.toString();
						v.getBotonij(i, j+1).setText(s);
						v.getBotonij(i, j+1).setEnabled(false);
					}
					
					if(m.getValido(i, j-1))
					{
						n=m.numerarCasillas(i,j-1);
						s=n.toString();
						v.getBotonij(i, j-1).setText(s);
						v.getBotonij(i, j-1).setEnabled(false);
					}
					
					if(m.getValido(i-1, j+1))
					{
						n=m.numerarCasillas(i-1,j+1);
						s=n.toString();
						v.getBotonij(i-1, j+1).setText(s);
						v.getBotonij(i-1, j+1).setEnabled(false);
					}
					
					if(m.getValido(i-1, j-1))
					{
						n=m.numerarCasillas(i-1,j-1);
						s=n.toString();
						v.getBotonij(i-1, j-1).setText(s);
						v.getBotonij(i-1, j-1).setEnabled(false);
					}
					
					if(m.getValido(i+1, j+1))
					{
						n=m.numerarCasillas(i+1,j+1);
						s=n.toString();
						v.getBotonij(i+1, j+1).setText(s);
						v.getBotonij(i+1, j+1).setEnabled(false);
					}
					
					if(m.getValido(i+1, j-1))
					{
						n=m.numerarCasillas(i+1,j-1);
						s=n.toString();
						v.getBotonij(i+1, j-1).setText(s);
						v.getBotonij(i+1, j-1).setEnabled(false);
					}
				}
			}
		}
	}

		private void perder() {
			for (int k = 0; k < v.length(); k++) {
				for (int l = 0; l < v.length(); l++) {
					if(m.comprobarMina(k, l))//Y REVELAR LAS MINAS Y DESHABILITAR TODOS LOS BOTONES AL PERDER
						v.getBotonij(k, l).setBackground(Color.red);
					else v.getBotonij(k, l).setEnabled(false);
					
				}
				
			}
			terminado=true;
			this.contMinas=0;
		}		
}
