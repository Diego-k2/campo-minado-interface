package br.com.cod3r.visao;

import javax.swing.JFrame;

import br.com.cod3r.modelo.Tabuleiro;

@SuppressWarnings("serial")
public class TelaPrincipal extends JFrame {

	public TelaPrincipal() { //CRIANDO AS DEFINIÇÕES DA TELA
		
		Tabuleiro tabuleiro = new Tabuleiro(16, 30, 55);
		PainelTabuleiro painelTabuleiro = new PainelTabuleiro(tabuleiro);
		
		add(painelTabuleiro);
		
		setTitle("Campo Minado");
		setSize(690, 438);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		
		new TelaPrincipal();
		
		
		
	}
	
	
	
}
