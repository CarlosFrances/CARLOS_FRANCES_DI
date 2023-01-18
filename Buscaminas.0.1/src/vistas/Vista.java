package vistas;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

public class Vista extends javax.swing.JFrame {
    public Vista() {
		  initComponents();
		botones=new JButton[8][8];
		
		root.setLayout(null);
		for(int i=0;i<botones.length;i++)
		//botones[i]
		for(int j=0;j<botones[i].length;j++)
		{
			botones[i][j]=new JButton();
			botones[i][j].setBounds(21+31*j, 25+21+31*i, 35, 35);
			root.add(botones[i][j]);
		}
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        root = new JPanel();
        botonReiniciar = new JButton();
        jLabel1 = new JLabel();
        flag = new JLabel();
        minasIdentificadas = new JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscaminas");
        setName("Form"); // NOI18N
        setResizable(false);

        root.setBackground(Color.cyan);
        root.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        root.setName("root"); // NOI18N
        root.setPreferredSize(new Dimension(300, 300));

        botonReiniciar.setMnemonic('r');
        botonReiniciar.setText("Reiniciar");
        botonReiniciar.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        botonReiniciar.setName("botonReiniciar"); // NOI18N

        jLabel1.setFont(new Font("Dialog", 0, 22)); // NOI18N
        jLabel1.setForeground(Color.cyan);
        jLabel1.setText("¡ ENHORABUENA !");
        jLabel1.setName("jLabel1"); // NOI18N

        flag.setName("flag"); // NOI18N

        minasIdentificadas.setFont(new Font("Franklin Gothic Medium", 1, 20)); // NOI18N
        minasIdentificadas.setForeground(Color.cyan);
        minasIdentificadas.setText("Minas: 10");
        minasIdentificadas.setName("minasIdentificadas"); // NOI18N

        GroupLayout rootLayout = new GroupLayout(root);
        root.setLayout(rootLayout);
        rootLayout.setHorizontalGroup(rootLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(rootLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel1)
                .addContainerGap(44, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, rootLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(rootLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, rootLayout.createSequentialGroup()
                        .addComponent(botonReiniciar)
                        .addGap(112, 112, 112))
                    .addGroup(GroupLayout.Alignment.TRAILING, rootLayout.createSequentialGroup()
                        .addComponent(flag, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(minasIdentificadas, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98))))
        );
        rootLayout.setVerticalGroup(rootLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, rootLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rootLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(flag, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                    .addComponent(minasIdentificadas))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 268, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonReiniciar)
                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(root, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(root, GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Vista v = new Vista();
                modelos.Modelo m = new modelos.Modelo();
				try {
					controladores.Controlador c = new controladores.Controlador(m,v);
				} catch (IOException ex) {
					Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
				}
                v.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton botonReiniciar;
    private JLabel flag;
    private JLabel jLabel1;
    private JLabel minasIdentificadas;
    private JPanel root;
    // End of variables declaration//GEN-END:variables
    
    public JPanel getRoot() {
        return root;
    }
	
		private JButton[][] botones;
	
	public JButton[][] getBotones()
	{
		return botones;
	}
	
	public JButton getBotonij(int i, int j)
	{
		return botones[i][j];
	}
	
	public int length()
	{
		return botones.length;
	}

	public JButton getBotonReiniciar() {
		return botonReiniciar;
	}

	public JLabel getjLabel1() {
		return jLabel1;
	}
	
	public void setBotones(JButton[][] a)
	{
			botones=a;
	}
	
	public void setBotonesij(int i,int  j,JButton a)
	{
		botones[i][j]=a;
	}

	public JLabel getFlag() {
		return flag;
	}

	public JLabel getMinasIdentificadas() {
		return minasIdentificadas;
	}
	
}
