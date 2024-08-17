package janelas;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.time.LocalDate;
import java.util.*;
import banco.*;

public class JanelaATM extends JFrame{
	
	private JButton btTrans,btDepo,btExt,btSaldo,btLev,btSair;
	private Container c;
	private int n;
	private Vector v;
	private ContaCDO co;
	public JanelaATM(int num) {
		super("Banco Múltiplo");
		n = num;
		v = new Vector<>();
		c = getContentPane();
		//Define o Layout
		c.setLayout(new GridLayout(3,2,20,20));
		//Estância e adição ao painel de contéudo dos botões 
		btDepo = new JButton("Depósito");
		c.add(btDepo);
		btTrans = new JButton("Transfêrencia");
		c.add(btTrans);
		btExt = new JButton("Extrato");
		c.add(btExt);
		btSaldo = new JButton("Saldo");
		c.add(btSaldo);
		btLev = new JButton("Levantamento");
		c.add(btLev);
		btSair = new JButton("Voltar");
		c.add(btSair);
		//Estância da classe que trata eventos
		Eventos x = new Eventos();
		//Adiciona os botões ao ActionListener
		btTrans.addActionListener(x);
		btDepo.addActionListener(x);
		btExt.addActionListener(x);
		btSair.addActionListener(x);
		btSaldo.addActionListener(x);
		btLev.addActionListener(x);
		//
		setSize(600,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		
	}
	public void lerFich() {
		try {
			FileInputStream file = new FileInputStream("contaP.dat");
			ObjectInputStream le = new ObjectInputStream(file);
			v = (Vector)le.readObject();
			
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage()+" "+e.getMessage());
		}
	}
	private class Eventos implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btTrans) {
				new JanelaTrans().setVisible(true);;
			}
			if(e.getSource()==btDepo) {
				new JanelaDepo(n).setVisible(true);
			}
			if(e.getSource()==btExt) {
				new JanelaExtrato(n).setVisible(true);
				dispose();
			}
			if(e.getSource()==btSaldo) {
				for(int i=0;i<v.size();i++) {
					co = (ContaCDO)v.get(i);
					if(co.getNumUCDO()==n) {
						JOptionPane.showMessageDialog(null, "Saldo: "+co.getSaldo());
						dispose();
						break;
					}
				}
			}
			if(e.getSource()==btLev) {
				new JanelaLeva(n).setVisible(true);
			}
			if(e.getSource()==btSair) {
				new JanelaLogin().setVisible(true);
				dispose();
			}
		}
		
	}
	public static void main(String[] args) {
		new JanelaATM(5);
	}
}
