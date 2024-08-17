package janelas;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import banco.*;
import java.io.*;
import java.time.*;
public class JanelaExtrato extends JFrame{
	private Vector v1,v2;
	private String tit [] = {"Número único","Data da operação","Hora da operação","Tipo de operação","Movimento"};
	private Object tabDados[][];
	private JTable tab;
	private JScrollPane sc;
	private Container c;
	private JButton bt;
	private OpCDO op;
	public JanelaExtrato(int num) {
		
		c = getContentPane();
		v1= new Vector<>();
		v2 = new Vector<>();
		lerFich();
		tabDados = getDados(v2.size());
		tab = new JTable(tabDados,tit);
		sc = new JScrollPane(tab);
		bt = new JButton("Voltar");
		c.add(bt);
		bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		c.add(sc);
		setSize(600,500);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void lerFich() {
		try {
			FileInputStream file = new FileInputStream("contaP.dat");
			ObjectInputStream le = new ObjectInputStream(file);
			v1 = (Vector)le.readObject();
			ContaCDO co1;
			for(int i=0;i<v1.size();i++) {
				op = (OpCDO)v1.get(i);
				if(op.getDataOp().getDayOfMonth()==LocalDate.now().getDayOfMonth()) {
					v2.add(op);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage()+" "+e.getMessage());
		}
	}
	public Object [][] getDados(int linhas){
		Object x[][] = new Object[linhas][tit.length];
		for(int i=0;i<linhas;i++) {
			op = (OpCDO)v2.get(i);
			x[i][0] = op.getNumUopCDO();
			x[i][1] = op.getDataOp();
			x[i][2] = op.getHoraOp();
			x[i][3] = op.getTipoOp();
			x[i][4] = op.getMontanteMovi();
		}
		return x;
	}
	public static void main(String[] args) {
		new JanelaExtrato(4);
	}
}
