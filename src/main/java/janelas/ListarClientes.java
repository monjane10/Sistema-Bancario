package janelas;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.time.LocalDate;
import java.util.*;
import banco.ClienteBanco;

public class ListarClientes extends JFrame{
	private JTable tab;
	private JScrollPane sc;
	private String tit[] = {"Nome","Número único","Data de nascimento"
			,"Número de BI","Residência"};
	private Object tabDados[][];
	private Vector v;
	private Container c;
	private ClienteBanco cli;
	public ListarClientes() {
		super("Lista de Clientes");
		c = getContentPane();
		v = new Vector<>();
		lerFich();
		tabDados = getDados(v.size());
		tab = new JTable(tabDados,tit);
		sc = new JScrollPane(tab);
		c.add(sc);
		setSize(600,500);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void lerFich() {
		try {
			FileInputStream file = new FileInputStream("clienteBank4.dat");
			ObjectInputStream le = new ObjectInputStream(file);
			v = (Vector)le.readObject();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage()+" "+e.getMessage());
		}
	}
	public static void main(String[] args) {
		new ListarClientes();
	}
	
	public Object[][] getDados(int linhas){
		Object x[][] = new Object[linhas][tit.length];
		for(int i=0;i<linhas;i++) {
			cli = (ClienteBanco)v.get(i);
			x[i][0] = cli.getNome();
			x[i][1] = cli.getNumCli();
			x[i][2] = cli.getDataNasc();
			x[i][3] = cli.getBi();
			x[i][4] = cli.getRes();
		}
		return x;
	}
}
