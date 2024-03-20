package com.ejercicioSocket;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MiClienteSocket {
	
	private ObjetoaMandar objeto;
	
	private class ObjetoaMandar{
		public String nombre;
		public String texto;
		
	}
 
	public static void main(String[] args) {
		
		Marco mimarco = new Marco();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
}

class Marco extends JFrame{

	private static final long serialVersionUID = 1L;

	public Marco() {
		setBounds(600,300,280,350);
		LaminaMarcoCliente mimarco = new LaminaMarcoCliente();
		add(mimarco);
		setVisible(true);
	}
		
}


class LaminaMarcoCliente extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField campo1;
	private JButton boton;
	
	public LaminaMarcoCliente() {
		JLabel texto = new JLabel("Emisor");
		add(texto);
		campo1 = new JTextField(20);
		add(campo1);
		boton = new JButton("Enviar");
		
		Enviartexto botonenvia = new Enviartexto();
		boton.addActionListener(botonenvia);
		
		add(boton);
		
	}
	
	private class Enviartexto implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println(campo1.getText());
			System.out.println("Boton Funciona");
			

			Socket soc;
			try {
				soc = new Socket("localhost", 9999);
				DataOutputStream data = new DataOutputStream(soc.getOutputStream());
				data.writeUTF(campo1.getText());
				data.flush();
				data.close();
				soc.close();
			}  catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
}