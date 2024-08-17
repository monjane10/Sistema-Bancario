package janelas;
import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Vector;
import javax.swing.*;
import banco.ContaCDO;
import banco.Ficheiro;
import banco.OpCDO;

public class JanelaLeva extends JFrame{
	
	private JButton btLeva,btCancel,btApagar;
	private TextField tx;
	private JLabel lb;
	private Container c;
	private int num;
	private ContaCDO co;
	private OpCDO op;
	private Vector v1,v2;
	private Ficheiro f;
	public JanelaLeva(int n) {
		super("Banco Múltiplo");
		num = n;
		v1 = new Vector<>();
		f = new Ficheiro();
		lerFich();
		c = getContentPane();
		c.setLayout(null);
		tx = new TextField(40);
		tx.setBounds(100,10,300,25);
		c.add(tx);
		
		btLeva = new JButton("Levantar");
		btLeva.setBounds(250,350,100,25);
		c.add(btLeva);
		btCancel = new JButton("Cancelar");
		btCancel.setBounds(360,350,100,25);
		c.add(btCancel);
		btApagar = new JButton("Apagar");
		btApagar.setBounds(40,350,100,25);
		c.add(btApagar);
		lb = new JLabel("Digita o valor:");
		lb.setBounds(10,10,100,25);
		c.add(lb);
		Evento ev = new Evento();
		btLeva.addActionListener(ev);
		btCancel.addActionListener(ev);
		btApagar.addActionListener(ev);
		setSize(500,450);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
	}
	public void lerFich() {
		v1 = f.fichLer("contaCDO.dat");
		v2 = f.fichLer("operacoesBank4.dat");
	}
	public static void main(String[] args) {
		new JanelaLeva(2);
	}
	private class Evento implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btLeva) {
				double valor = Integer.parseInt(tx.getText());
				for(int i=0;i<v1.size();i++) {
					op = (OpCDO)v2.get(i);
					if(num==op.getConta().getNumUCDO()) {
						op.levantar(valor);
						v2.remove(i);
						v2.add(i,op);
						f.fichLer("operacoesBank4.dat");
						for(int j=0;j<v1.size();i++) {
							co = (ContaCDO)v1.get(j);
							if(co.getNumUCDO()==op.getConta().getNumUCDO()) {
								v1.remove(i);
								v1.add(i,co);
								f.fichLer("contaCDO.dat");
								break;
							}
						}
						JOptionPane.showMessageDialog(null, "Levantamento feito!");
						break;
					}
				}
			}
		}
	}
}
