package janelas;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class JanelaTrans extends JFrame{
	private JTextField tx1,tx2;
	private JLabel lb1,lb2;
	private Container c;
	private JButton btTrans,btCancel,btApagar;
	public JanelaTrans() {
		super("Banco Múltiplo");
		
		c = getContentPane();
		c.setLayout(null);
		tx1 = new JTextField();
		tx1.setBounds(170,40,300,25);
		c.add(tx1);
		tx2 = new JTextField();
		tx2.setBounds(170,70,300,25);
		c.add(tx2);
		lb1 = new JLabel("Digita o número da conta:");
		lb1.setBounds(20,40,150,25);
		c.add(lb1);
		lb2 = new JLabel("Digita o valor:");
		lb2.setBounds(20,70,150,25);
		c.add(lb2);
		btTrans = new JButton("Transferir");
		btTrans.setBounds(250,350,100,25);
		c.add(btTrans);
		btCancel = new JButton("Cancelar");
		btCancel.setBounds(360,350,100,25);
		c.add(btCancel);
		btApagar = new JButton("Apagar");
		btApagar.setBounds(40,350,100,25);
		c.add(btApagar);
		setSize(500,450);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		new JanelaTrans();
	}
}
