package janelas;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;
import banco.ContaCDO;
import banco.Ficheiro;
import banco.OpCDO;

public class JanelaDepo extends JFrame{
	private JButton btDepo,btCancel,btApagar;
	private TextField tx;
	private JLabel lb;
	private Container c;
	private Ficheiro f = new Ficheiro();
	private Vector v,v2;
	private ContaCDO co;
	private OpCDO op;
	private int n;
	public JanelaDepo(int num) {
		super("Banco Múltiplo");
		n = num;
		 v = new Vector<>();
		 v2 = new Vector<>();
		 lerFich();
		c = getContentPane();
		c.setLayout(null);
		tx = new TextField(40);
		tx.setBounds(100,10,300,25);
		c.add(tx);
		btDepo = new JButton("Depositar");
		btDepo.setBounds(250,350,100,25);
		c.add(btDepo);
		btCancel = new JButton("Cancelar");
		btCancel.setBounds(360,350,100,25);
		c.add(btCancel);
		btApagar = new JButton("Apagar");
		btApagar.setBounds(40,350,100,25);
		c.add(btApagar);
		lb = new JLabel("Digita o valor:");
		lb.setBounds(10,10,100,25);
		c.add(lb);
		Evento x = new Evento();
		
		setSize(500,450);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
	public class Evento implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btDepo) {
				double valor = Double.parseDouble(tx.getText());
				for(int i=0;i<v.size();i++) {
					op = (OpCDO)v.get(i);
					if(op.getConta().getNumUCDO()==n) {
						v.remove(i);
						v.add(i,op);
						f.fichEscreve("operacoesBank.dat", v);
						for(int j=0;j<v2.size();i++) {
							co = (ContaCDO)v2.get(i);
							if(op.getConta().getNumUCDO()==co.getNumUCDO()) {
								co = op.getConta();
								v2.add(i, co);
							}
						}
						JOptionPane.showMessageDialog(null, "Depósito feito com sucesso");
						dispose();
						break;
					}
				}
			}
		}
	}
	public void lerFich() {
		v = f.fichLer("operacoesBank.dat");
		v2 = f.fichLer("operacoesBank.dat");
	}
	public static void main(String[] args) {
		new JanelaDepo(56);
	}
}
