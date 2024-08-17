package janelas;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.Vector;

import javax.swing.*;

import banco.ClienteBanco;
import banco.Ficheiro;
public class JanelaInserirClientes extends JFrame{
	
	private Container c;
	private JButton btInserir,btLimpar,btCancelar;
	private JTextField tNome,tNum,tAno,tMes,tDia,tBi,tRes;
	private JLabel tit,lNome,lNum,lData,lBi,lRes;
	private Vector v;
	//private JLabel l
	private ClienteBanco cli;
	private Ficheiro f;
	public JanelaInserirClientes() {
		super("Banco Múltiplo");
		f = new Ficheiro();
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
		tAno = new JTextField();
		tMes = new JTextField();
		tDia = new JTextField();
		tBi = new JTextField();
		tRes = new JTextField();
		//Define a posição e o tamanho das caixas de texto
		tNome.setBounds(150,130,300,30);
		tNum.setBounds(150,190,300,30);
		tAno.setBounds(150,250,40,30);
		tMes.setBounds(200,250,40,30);
		tDia.setBounds(250,250,40,30);
		tBi.setBounds(150,310,300,30);
		tRes.setBounds(150,370,300,30);
		//Estancia as Labels
		tit = new JLabel("Inserir Clientes");
		tit.setFont(new Font("Aria;",Font.BOLD,18));
		lNome = new JLabel("Nome:");
		lNum = new JLabel("Número único:");
		lData = new JLabel("Data de nascimento:");
		lBi = new JLabel("Número de BI:");
		lRes = new JLabel("Residência:");
		//Define a posição e o tamanho das Labels
		tit.setBounds(180,2,250,100);
		lNome.setBounds(150,100,50,30);
		lNum.setBounds(150,160,90,30);
		lData.setBounds(150,220,120,30);
		lBi.setBounds(150,280,90,30);
		lRes.setBounds(150,340,90,30);
		//Adiciona ao painel de conteúdo
		c.add(btInserir);
		c.add(btLimpar);
		c.add(btCancelar);
		c.add(tNome);
		c.add(tNum);
		c.add(tAno);
		c.add(tMes);
		c.add(tDia);
		c.add(tBi);
		c.add(tRes);
		c.add(lNome);
		c.add(lNum);
		c.add(lData);
		c.add(lBi);
		c.add(lRes);
		c.add(tit);
		Evento x = new Evento();
		btInserir.addActionListener(x);
		btCancelar.addActionListener(x);
		btLimpar.addActionListener(x);
		setSize(550,600);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	public void lerFich() {
		v = f.fichLer("clienteBank4.dat");
	}
	private class Evento implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btInserir) {
				int num = Integer.parseInt(tNum.getText());
				String nome = tNome.getText();
				int d = Integer.parseInt(tDia.getText());
				int m = Integer.parseInt(tMes.getText());
				int a = Integer.parseInt(tAno.getText());
				LocalDate data = LocalDate.of(a, m, d);
				String bi = tBi.getText();
				String resi = tRes.getText();
				cli = new ClienteBanco(num, nome, data, bi, resi);
				v.add(cli);
				f.fichEscreve("clienteBank4.dat", v);
			}
			if(e.getSource()==btCancelar) {
				dispose();
			}
			if(e.getSource()==btLimpar) {
				tAno.setText("");
				tBi.setText("");
				tDia.setText("");
				tMes.setText("");
				tNome.setText("");
				tNum.setText("");
				tRes.setText("");
			}
		}
	}
}
