package com.ejercicioSocket;

import java.awt.BorderLayout;
import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MiServidor {

	public static void main(String[] args) {
		
		MarcoServidor marcoServidor = new MarcoServidor();
		marcoServidor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


	}
	
}	

class MarcoServidor extends JFrame implements Runnable{
	
	private static final long serialVersionUID = 1L;
	private JTextArea areaTexto;
	public MarcoServidor(){
		
		setBounds(1200, 300, 280, 350);
		JPanel miPanel = new JPanel();
		miPanel.setLayout(new BorderLayout());
		areaTexto = new JTextArea();
		miPanel.add(areaTexto, BorderLayout.CENTER);
		add(miPanel);
		setVisible(true);
		
		Thread miHilo = new Thread(this);
		miHilo.start();
	}
	
	@Override
	public void run() {
		
		
		try {
			
			ServerSocket miSS = new ServerSocket(9999);
			
			while(true) {
				Socket soc = miSS.accept();
				
				DataInputStream dis = new DataInputStream(soc.getInputStream());
				String str = (String) dis.readUTF();
				
				areaTexto.append("\nJavi: "+str);
				
				System.out.println("Mensaje: " + str);
				//miSS.close();	
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}


