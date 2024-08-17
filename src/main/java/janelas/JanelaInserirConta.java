package janelas;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Vector;

import javax.swing.*;

import banco.ClienteBanco;

import banco.ContaCDO;
import banco.Ficheiro;
public class JanelaInserirConta extends JFrame{
	
	private Container c;
	private JButton btInserir,btLimpar,btCancelar;
	private JTextField tNumCli,tSaldo,tSenha;
	private JLabel lNumCli,lSaldo,lSenha;
	private Vector v1,v2;
	private Ficheiro f;
	private ContaCDO co;
	private ClienteBanco cli;
	public JanelaInserirConta() {
		super("Banco Múltiplo-Criar Conta");
		v1 = new Vector<>();
		v2 = new Vector<>();
		f = new Ficheiro();
		c = getContentPane();
		c.setLayout(null);
		//Estancia os botões
		btInserir = new JButton("Criar");
		btCancelar= new JButton("Cancelar");
		btLimpar = new JButton("Limpar");
		//Define a posição e o tamanho dos botões
		btInserir.setBounds(280,500,100,25);
		btCancelar.setBounds(400,500,100,25);
		btLimpar.setBounds(50,500,100,25);
		//Estancia as caixas de texto
		tNumCli = new JTextField();
		tSaldo = new JTextField();
		tSenha = new JTextField();
		//Define a posição e o tamanho das caixas de texto
		tNumCli.setBounds(150,130,300,30);
		tSaldo.setBounds(150,190,300,30);
		tSenha.setBounds(150,250,300,30);
		//Estancia as Labels
		lNumCli = new JLabel("Número único do Cliente:");
		lSaldo = new JLabel("Saldo:");
		lSenha = new JLabel("Senha");
		//Define a posição e o tamanho das Labels
		lNumCli.setBounds(150,100,160,30);
		lSaldo.setBounds(150,160,50,30);
		lSenha.setBounds(150,220,50,30);
		//Adiciona ao painel de conteúdo
		c.add(btInserir);
		c.add(btLimpar);
		c.add(btCancelar);
		c.add(tNumCli);
		c.add(tSaldo);
		c.add(lSenha);
		c.add(lNumCli);
		c.add(lSaldo);
		c.add(tSenha);
		Evento x = new Evento();
		btInserir.addActionListener(x);
		btLimpar.addActionListener(x);
		btCancelar.addActionListener(x);
		setSize(550,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		new JanelaInserirConta();
	}
	
	public void fichLer() {
		v1 = f.fichLer("contaCDOBank.dat");
		v2 = f.fichLer("clienteBank4.dat");
	}
	private class Evento implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btInserir) {
		
				int n1 = Integer.parseInt(lNumCli.getText());
				int num = n1+1;
				double saldo = Double.parseDouble(lSaldo.getText());
				String senha = tSenha.getText();
				for(int i =0;i<v2.size();i++) {
					cli = (ClienteBanco)v2.get(i);
					if(cli.getNumCli()==n1) {
						co = new ContaCDO(num, LocalDate.now(), LocalTime.now(), saldo, cli,senha);
						v1.add(co);
						f.fichEscreve("contaCDOBank4.dat", v1);
					}
				}
			}
			if(e.getSource()==btLimpar) {
				btInserir.setText("");
				btCancelar.setText("");
				btLimpar.setText("");
			}
			if(e.getSource()==btCancelar) {
				dispose();
			}
		}
	}
}

