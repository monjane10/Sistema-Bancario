package janelas;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;

import banco.ClienteBanco;
import banco.Ficheiro;
import banco.FuncionarioBanco;


public class JanelaInserirFuncionario extends JFrame{
	
	private Container c;
	private JButton btInserir,btLimpar,btCancelar;
	private JTextField tNome,tNum,tApelido,tBi,tRes,tPin;
	private JLabel lNum,lNome,lApelido,lBi,lRes,lPin;
	private Vector v;
	private FuncionarioBanco fun;
	private Ficheiro fich;
	public JanelaInserirFuncionario() {
		super("Banco Múltiplo");
		fich = new Ficheiro();
		v = new Vector<>();
		lerFich();
		c = getContentPane();
		c.setLayout(null);
		//Estancia os botões
		btInserir = new JButton("Inserir");
		btCancelar= new JButton("Cancelar");
		btLimpar = new JButton("Limpar");
		//Define a posição e o tamanho dos botões
		btInserir.setBounds(280,500,100,25);
		btCancelar.setBounds(400,500,100,25);
		btLimpar.setBounds(50,500,100,25);
		//Estancia as caixas de texto
		tNome = new JTextField();
		tNum = new JTextField();
		tApelido = new JTextField();
		tBi = new JTextField();
		tRes = new JTextField();
		tPin = new JTextField();
		//Define a posição e o tamanho das caixas de texto
		tNome.setBounds(150,130,300,30);
		tNum.setBounds(150,190,300,30);
		tApelido.setBounds(150,250,300,30);
		tBi.setBounds(150,310,300,30);
		tRes.setBounds(150,370,300,30);
		tPin.setBounds(150,430,300,30);
		//Estancia as Labels
		lNum = new JLabel("Número único:");
		lNome = new JLabel("Nome:");
		lApelido = new JLabel("Apelido:");
		lBi = new JLabel("Número de BI:");
		lRes = new JLabel("Residência:");
		lPin = new JLabel("Código");
		//Define a posição e o tamanho das Labels
		lNum.setBounds(150,100,90,30);
		lNome.setBounds(150,160,50,30);
		lApelido.setBounds(150,220,120,30);
		lBi.setBounds(150,280,90,30);
		lRes.setBounds(150,340,90,30);
		lPin.setBounds(150,400,90,30);
		//Adiciona ao painel de conteúdo
		c.add(btInserir);
		c.add(btLimpar);
		c.add(btCancelar);
		c.add(tNome);
		c.add(tNum);
		c.add(tApelido);
		c.add(tBi);
		c.add(tRes);
		c.add(tPin);
		c.add(lNum);
		c.add(lNome);
		c.add(lApelido);
		c.add(lBi);
		c.add(lRes);
		c.add(lPin);
		Evento x = new Evento();
		btInserir.addActionListener(x);
		btLimpar.addActionListener(x);
		btCancelar.addActionListener(x);;
		setSize(550,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		new JanelaInserirFuncionario();
	}
	public void lerFich() {
		v = fich.fichLer("funcionarioBank5.dat");
	}
	private class Evento implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btInserir) {
				String nome = tNome.getText();
				String apelido = tApelido.getText();
				int num = Integer.parseInt(tNum.getText());
				String bi = tBi.getText();
				String res = tRes.getText();
				String cod = tPin.getText();
				fun = new FuncionarioBanco(num, nome, apelido, bi, res, cod);
				v.add(fun);
				fich.fichEscreve("funcionarioBank5.dat", v);
			}
		}
	}
}
