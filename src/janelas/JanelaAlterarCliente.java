package janelas;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import banco.*;

public class JanelaAlterarCliente extends JFrame{
	private Container c;
	private JButton btAlterar,btCancelar,btPro;
	private JTextField tNome,tNum,tData,tBi,tRes,tPro;
	private JLabel lNome,lNum,lData,lBi,lRes;
	private Vector v;
	private JLabel lb;
	private Icon ic = new ImageIcon("search.png");
	private ClienteBanco cli;
	private Ficheiro f;
	public JanelaAlterarCliente() {
		super("Banco Múltiplo-Alterar Cliente");
		c = getContentPane();
		c.setLayout(null);
		v = new Vector<>();
		lerFichCli();
		//Estancia os botões
		btAlterar = new JButton("Alterar");
		btCancelar= new JButton("Cancelar");
		btPro = new JButton(ic);
		//Define a posição e o tamanho dos botões
		btAlterar.setBounds(280,500,100,25);
		btCancelar.setBounds(400,500,100,25);
		btPro.setBounds(470,40,25,25);
		//Estancia as caixas de texto
		tNome = new JTextField();
		tNum = new JTextField();
		tData = new JTextField();
		tBi = new JTextField();
		tRes = new JTextField();
		tPro = new JTextField();
		//Define a posição e o tamanho das caixas de texto
		tNome.setBounds(150,130,300,30);
		tNum.setBounds(150,190,300,30);
		tData.setBounds(150,250,300,30);
		tBi.setBounds(150,310,300,30);
		tRes.setBounds(150,370,300,30);
		tPro.setBounds(150,40,300,30);
		//Estancia as Labels
		lNome = new JLabel("Nome:");
		lNum = new JLabel("Número único:");
		lData = new JLabel("Data de nascimento:");
		lBi = new JLabel("Número de BI:");
		lRes = new JLabel("Residência:");
		lb = new JLabel("Digita o úmero único:");
		//Define a posição e o tamanho das Labels
		lNome.setBounds(150,100,50,30);
		lNum.setBounds(150,160,90,30);
		lData.setBounds(150,220,120,30);
		lBi.setBounds(150,280,90,30);
		lRes.setBounds(150,340,90,30);
		lb.setBounds(150,15,120,30);
		//Adiciona ao painel de conteúdo
		c.add(btAlterar);
		c.add(btCancelar);
		c.add(btPro);
		c.add(tNome);
		c.add(tNum);
		c.add(tData);
		c.add(tBi);
		c.add(tRes);
		c.add(tPro);
		c.add(lNome);
		c.add(lNum);
		c.add(lData);
		c.add(lBi);
		c.add(lRes);
		c.add(lb);
		Evento ev = new Evento();
		btPro.addActionListener(ev);
		btAlterar.addActionListener(ev);
		btCancelar.addActionListener(ev);
		setSize(550,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	public void lerFichCli() {   
			v = f.fichLer("clienteBank.dat");
	}
	public static void main(String[] args) {
		new JanelaAlterarCliente();
	}
	   
	private class Evento implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btPro) {
				int num = Integer.parseInt(tPro.getText());
				for(int i=0;i<v.size();i++) {
					cli = (ClienteBanco)v.get(i);
					if(num==cli.getNumCli()) {
						String data = cli.getDataNasc().getYear() +"-"+cli.getDataNasc().getMonthValue() + "-"+cli.getDataNasc().getDayOfMonth();
						tNome.setText(cli.getNome());
						tNum.setText(tPro.getText());
						tData.setText(data);
						tBi.setText(cli.getBi());
						tRes.setText(cli.getRes());
					}
				}
			}
			if(e.getSource()==btAlterar) {
				int num = Integer.parseInt(tPro.getText());
				for(int i=0;i<v.size();i++) {
					cli = (ClienteBanco)v.get(i);
					if(num==cli.getNumCli()) {
						cli.setNome(tNome.getText());
						cli.setNumCli(Integer.parseInt(tNum.getText()));
						cli.setDataNasc(LocalDate.parse(tData.getText()));
						cli.setBi(tBi.getText());
						cli.setRes(tRes.getText());
						v.remove(i);
						v.add(i,cli);
						JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso");
						dispose();
						break;
					}
				}
			}
		}
		
	}
}
