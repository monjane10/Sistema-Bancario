package janelas;
import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.time.*;
import java.util.*;
import javax.swing.*;
import banco.*;

public class JanelaLogin extends JFrame{
	private JButton btEntrar,btSair;
	private JTextField t1;
	private JRadioButton atm,gestao;
	private Container c;
	private JLabel id,senha;
	private ButtonGroup grupoBt;
	private Vector v1;
	private Vector v2;
	private ContaCDO cp;
	private FuncionarioBanco fun;
	private Ficheiro f;
	private JPasswordField tCo;
	public JanelaLogin() {
		super("Banco Múltiplo");
		c = getContentPane();
		//Define o layout como nulo
		c.setLayout(null);
		//Classe que trata eventos
		Eventos x = new Eventos();
		
		/*ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
		Image i2=i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);*/
		
		/*JLabel la=new JLabel(i3);
		la.setBounds(20, 50, 100, 300);
		c.add(la);*/
		//Estância do componente btEntrar
		btEntrar = new JButton("Entrar");
		//Configura a localização e o tamanho do componente btEntrar
		btEntrar.setBounds(200,220,100,25);
		//Adiciona ao painel de conteúdo
		c.add(btEntrar);
		//Estância do componente btSair
		btSair = new JButton("Sair");
		//Configura a localização e o tamanho do componente btSair
		btSair.setBounds(310,220,100,25);
		//Adiciona ao painel de conteúdo
		c.add(btSair);
		//Estância do componente t1
		t1 = new JTextField();
		tCo = new JPasswordField();
		//Configura a localização e o tamanho do componente t1
		t1.setBounds(130,65,200,25);
		//Adiciona ao painel de conteúdo
		c.add(t1);
		//Configura a localização e o tamanho do componente t2
		tCo.setBounds(130,105,200,25);
		//Adiciona ao painel de conteúdo
		c.add(tCo);
		//Estância o componente atm
		atm = new JRadioButton("ATM",true);
		//Configura a localização e o tamanho do componente
		atm.setBounds(150,150,60,20);
		//Adiciona ao painel de conteúdo
		c.add(atm);
		//Estância do componente gestao
		gestao = new JRadioButton("Gestão",false);
		//Configura a localização e o tamanho do componente
		gestao.setBounds(220,150,90,20);
		//Adiciona ao painel de conteúdo
		c.add(gestao);
		//Estância do componente id
		id = new JLabel("Identificador:");
		//Configura a localização e o tamanho do componente
		id.setBounds(40,50,100,50);
		//Adiciona ao painel de conteúdo
		c.add(id);
		//Estância do componente senha
		senha = new JLabel("Senha:");
		//Configura a localização e o tamanho do componente
		senha.setBounds(40,90,100,50);
		//Método para ler ficheiro
		v1 = new Vector<>();
		fichCli();
		v2 = new Vector<>();
		fichFunci();
		//Adiciona ao painel de conteúdo
		c.add(senha);
		//Permite que apenas um dos 2 botoes possa  ser seleccionado por vez
		grupoBt = new ButtonGroup();
		grupoBt.add(atm);
		grupoBt.add(gestao);
		//Adiciona ao ActionListener
		btEntrar.addActionListener(x);
		btSair.addActionListener(x);
		//Configura a janela
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(450,300);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}


	public static void main(String[] args) {
		new JanelaLogin();
	}
	
	private class Eventos implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btEntrar) {
				if(atm.isSelected()) {
					int num = Integer.parseInt(t1.getText());
					String co = tCo.getText();
					for(int i=0;i<v1.size();i++) {
						cp = (ContaCDO)v1.get(i);
						if(cp.getNumUCDO()==num && cp.getPin().equals(co)) {
							new JanelaATM(num).setVisible(true);
							dispose();
							break;
						}     
					}
				}
				if(gestao.isSelected()) {
					int num1 = Integer.parseInt(t1.getText());
					String cod = tCo.getText();
					for(int i=0;i<v2.size();i++) {
						fun = (FuncionarioBanco)v2.get(i);
						if(fun.getNumUFunGB()==num1 && fun.getPin().equals(cod) ) {
							new JanelaGestao().setVisible(true);
							dispose();
							break;
						}
					}
				}
			}
			if(e.getSource()==btSair) {
				System.exit(0);
			}
		}
		
	}
	public void fichCli() {
		v1 = f.fichLer("contaCDOBank4.dat");
	}
	public void fichFunci() {
		v2 = f.fichLer("funcionarioBank5.dat");
	}
}
