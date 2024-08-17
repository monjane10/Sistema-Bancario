package janelas;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;

import banco.*;


public class JanelaAlterarFunc extends JFrame{
	
	private Container c;
	private JButton btAlterar,btCancelar,btPro;
	private JTextField tNome,tNum,tApelido,tBi,tRes,tPro,tPin;
	private JLabel lNum,lNome,lApelido,lBi,lRes,lPin;
	private JLabel lb;
	private Icon ic = new ImageIcon("search.png");
	private Vector v;
	private FuncionarioBanco fun;
	public JanelaAlterarFunc() {
		super("Banco Múltiplo-Alterar Funcionário");
		v = new Vector<>();
		lerFichCli();
		c = getContentPane();
		c.setLayout(null);
		//Estancia os botões
		btAlterar = new JButton("Alterar");
		btCancelar = new JButton("Cancelar");
		btPro = new JButton(ic);
		//Define a posição e o tamanho dos botões
		btAlterar.setBounds(280,500,100,25);
		btCancelar.setBounds(400,500,100,25);
		btPro.setBounds(470,40,25,25);
		//Estancia as caixas de texto
		tNome = new JTextField();
		tNum = new JTextField();
		tApelido = new JTextField();
		tBi = new JTextField();
		tRes = new JTextField();
		tPin = new JTextField();
		tPro = new JTextField();
		//Define a posição e o tamanho das caixas de texto
		tNum.setBounds(150,130,300,30);
		tNome.setBounds(150,190,300,30);
		tApelido.setBounds(150,250,300,30);
		tBi.setBounds(150,310,300,30);
		tRes.setBounds(150,370,300,30);
		tPro.setBounds(150,40,300,30);
		tPin.setBounds(150,430,300,30);
		//Estancia as Labels
		lNum = new JLabel("Número único:");
		lNome = new JLabel("Nome:");
		lApelido = new JLabel("Apelido:");
		lBi = new JLabel("Número de BI:");
		lRes = new JLabel("Residência:");
		lPin = new JLabel("Pin:");
		lb = new JLabel("Digita o úmero único:");
		//Define a posição e o tamanho das Labels
		lNum.setBounds(150,100,90,30);
		lNome.setBounds(150,160,50,30);
		lApelido.setBounds(150,220,120,30);
		lBi.setBounds(150,280,90,30);
		lRes.setBounds(150,340,90,30);
		lPin.setBounds(150,400,90,30);
		lb.setBounds(150,15,120,30);
		//Adiciona ao painel de conteúdo
		c.add(btAlterar);
		c.add(btCancelar);
		c.add(btPro);
		c.add(tNome);
		c.add(tNum);
		c.add(tApelido);
		c.add(tPro);
		c.add(tBi);
		c.add(tRes);
		c.add(tPin);
		c.add(lNum);
		c.add(lNome);
		c.add(lApelido);
		c.add(lBi);
		c.add(lRes);
		c.add(lPin);
		c.add(lb);
		Evento ev  = new Evento();
		btAlterar.addActionListener(ev);
		btCancelar.addActionListener(ev);
		btPro.addActionListener(ev);
		setSize(550,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		new JanelaAlterarFunc();
	}
	public void lerFichCli() {
		FuncionarioBanco fun1 = new FuncionarioBanco(1234, "Hugo", "Suaréz", "49897209232B", "Rrrr", "12345");
		v.add(fun1);
	}
	private class Evento implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btPro) {
				int num = Integer.parseInt(tPro.getText());
				for(int i=0;i<v.size();i++) {
					fun = (FuncionarioBanco)v.get(i);
					if(num==fun.getNumUFunGB()) {
						tNome.setText(fun.getpNome());
						tNum.setText(tPro.getText());
						tApelido.setText(fun.getApelido());
						tBi.setText(fun.getbI());
						tRes.setText(fun.getResidencia());
						tPin.setText(fun.getPin());
						break;
					}
				}
			}
			if(e.getSource()==btAlterar) {
				int num = Integer.parseInt(tPro.getText());
				for(int i=0;i<v.size();i++) {
					fun = (FuncionarioBanco)v.get(i);
					if(num==fun.getNumUFunGB()) {
						fun.setpNome(tNome.getText());
						fun.setNumUFunGB(Integer.parseInt(tNum.getText()));
						fun.setApelido(tApelido.getText());
						fun.setbI(tBi.getText());
						fun.setResidencia(tRes.getText());
						fun.setPin(tPin.getText());
						v.remove(i);
						v.add(i,fun);
						JOptionPane.showMessageDialog(null, "Dados Alterados com sucesso");
						break;
					}
				}
				for(int i=0;i<v.size();i++) {
					fun = (FuncionarioBanco)v.get(i);
					System.out.println(fun.toString());
				}
			}
		}
	}
}

