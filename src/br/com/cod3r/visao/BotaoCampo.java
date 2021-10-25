package br.com.cod3r.visao;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import br.com.cod3r.modelo.Campo;
import br.com.cod3r.modelo.CampoEvento;
import br.com.cod3r.modelo.CampoObservador;

@SuppressWarnings("serial")
public class BotaoCampo extends JButton implements CampoObservador, MouseListener{

	private Campo campo;
	
	//CORES
	private final Color BG_PADRAO = new Color(184, 184, 184);
	private final Color BG_MARCADO = new Color(8, 179, 247);
	private final Color BG_EXPLODIR = new Color(189, 66, 68);
	private final Color TEXTO_VERDE = new Color(0, 100, 0);
	
	
	public BotaoCampo(Campo campo) {
		this.campo = campo;
		setBorder(BorderFactory.createBevelBorder(0));
		setOpaque(true);
		setBackground(BG_PADRAO);
		
		addMouseListener(this); //registrando o evento
		campo.registrarObservador(this);
		
	}
	
	@Override
	public void eventoOcorreu(Campo c, CampoEvento evento) {
		switch(evento) {
		case ABRIR:
			aplicarEstiloAbrir();
			break;
		case MARCA:  
			aplicarEstiloMarcar();
			break;
		case EXPLODIR:
			aplicarEstiloExplodir();
			break;
		default:
			aplicarEstiloPadrao();
			
		}
	}

	
	private void aplicarEstiloPadrao() {
		setBackground(BG_PADRAO);
		setBorder(BorderFactory.createBevelBorder(0));
		setOpaque(true);
		setText("");
	}

	private void aplicarEstiloExplodir() {
		setBackground(BG_EXPLODIR);
		setText("X");
	}

	private void aplicarEstiloMarcar() {
		setBackground(BG_MARCADO);
		setText("M");
	}

	private void aplicarEstiloAbrir() {
		
		setBorder(BorderFactory.createLineBorder(Color.gray));
		
		if(campo.isMinado()) {
			setBackground(BG_EXPLODIR);
			setText("X");
			return;
		}
		
		setBackground(BG_PADRAO);
		
		switch (campo.minasNaVizinhanca()){
		case 1: 
			setForeground(TEXTO_VERDE);
			break;
		case 2: 
			setForeground(Color.BLUE);
			break;
		case 3: 
			setForeground(Color.YELLOW);
			break;	
		case 4: 
			setForeground(Color.YELLOW);
			break;		
		case 5: 
			setForeground(Color.YELLOW);
			break;		
		case 6: 
			setForeground(Color.RED);
			break;
		default:
			setForeground(Color.CYAN);
			
		}
		
		String valor = !campo.vizinhancaSegura() ? campo.minasNaVizinhanca() + "" : "";
		
		setText(valor);
	}
	
	//interface dos eventos do mouse 
	
	@Override
	public void mousePressed(MouseEvent e) { //implementando o evento no botao
		if(e.getButton() == 1) {
			campo.abrir();
		} else {
			campo.alternarMarcacao();
		}
	}
	
	
	@Override
	public void mouseExited(MouseEvent e) {
		
	}	
	public void mouseReleased(MouseEvent e) {
		
	}
	public void mouseEntered(MouseEvent e) {		
	}
	public void mouseClicked(MouseEvent e) {
				
	}

	
	
	
	
}
