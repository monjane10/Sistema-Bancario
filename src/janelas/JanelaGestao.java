package janelas;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class JanelaGestao extends JFrame{
	private JMenu inserir,alterar,remover,procurar,listar;
	private Container c;
	private JMenuBar barra;
	private JMenuItem clientesInserir,contaInserir,funcInserir;
	private JMenuItem alterarCli,alterarConta,alterarFunc;
	private JMenuItem removerCli,removerConta,removerFunc;
	private JMenu procurarCli,procurarConta,procurarFunc;
	private JMenuItem procurarCliNum,procurarCliNome,procurarContaNum,procurarContaNome,verDetalhes,
	procurarF;
	private JMenuItem listaCli,listaConta,listaFunc;
	private ImageIcon fundo = new ImageIcon("bancofundo.png");
	public JanelaGestao() {
		super("Gestão do Banco");
		c = getContentPane();
		Evento ev = new Evento();
		//Estância os componentes do tipo JMenu e JMenuBar
		barra = new JMenuBar();
		setJMenuBar(barra);
		barra.setBackground(new Color(40,75,0));
		inserir = new JMenu("Novo+");
		alterar = new JMenu("Alterar Dados");
		remover = new JMenu("Remover");
		procurar = new JMenu("Procurar");
		listar = new JMenu("Listar");
		//Estância de componentes JMenuItem
		clientesInserir = new JMenuItem("Inserir clientes"); 
		contaInserir = new JMenuItem("Criar nova conta");
		funcInserir = new JMenuItem("Inserir Funcionario");
		//Estância de componentes JMenu para alterar
		alterarCli = new JMenuItem("Alterar Clientes");
		alterarConta = new JMenuItem("Alterar Dados do Conta");
		alterarFunc = new JMenuItem("Alterar Dados do Funcionário");
		//Estância de componentes JMenuItem para alterar
		listaCli = new JMenuItem("Lista dos Clientes");
		listaConta = new JMenuItem("Lista das Conta");
		listaFunc = new JMenuItem("Lista dos funcionários");
		//Estância de componentes JMenuItem para remover
		removerCli = new JMenuItem("Remover Cliente");
		removerConta = new JMenuItem("Remover Conta");
		removerFunc = new JMenuItem("Remover Funcionário");
		//
		verDetalhes = new JMenuItem("Ver detalhes");
		//Estância de componentes JMenuItem para procurar(Cliente)
		procurarCliNome = new JMenuItem("Pelo nome");
		procurarCliNum = new JMenuItem("Pelo número único");
		//Estância de componentes JMenuItem para procurar(Conta)
		procurarContaNome = new JMenuItem("Pelo nome(Cliente)");
		procurarContaNum = new JMenuItem("Pelo número");
		//Estância de componentes JMenuItem para procurar(Funcionário)
		procurarF = new JMenuItem("Pelo número");
		//Estância de componentes JMenu para alterar
		procurarCli = new JMenu("Procurar cliente");
		procurarFunc = new JMenu("Procurar Funcionário");
		procurarConta = new JMenu("Procurar Conta");
		//Adicionar o JMenuItem ao menu inserir
		inserir.add(clientesInserir);
		inserir.add(contaInserir);
		inserir.add(funcInserir);
		//Adicionar o JMenuItem ao menu(Cliente procurar)
		procurarCli.add(procurarCliNome);
		procurarCli.add(procurarCliNum);
		//Adicionar o JMenuItem ao menu(Conta procurar)
		procurarConta.add(procurarContaNome);
		procurarConta.add(procurarContaNum);
		procurarConta.add(verDetalhes);
		//Adicionar o JMenuItem ao menu(Funcionário procurar)
		procurarFunc.add(procurarF);
		//Adicionar o JMenuItem ao menu
		listar.add(listaCli);
		listar.add(listaConta);
		listar.add(listaFunc);
		//Adicionar o JMenuItem ao menu alterar
		alterar.add(alterarCli);
		alterar.add(alterarConta);
		alterar.add(alterarFunc);
		//Adicionar o JMenu ao menu procurar
		procurar.add(procurarCli);
		procurar.add(procurarFunc);
		procurar.add(procurarConta);
		//Adicionar o JMenu ao menu remover
		remover.add(removerCli);
		remover.add(removerConta);
		remover.add(removerFunc);
		//Adiciona o menu à barra
		barra.add(inserir);
		barra.add(alterar);
		barra.add(remover);
		barra.add(procurar);
		barra.add(listar);
		//Adiciona ao ActionListener
		clientesInserir.addActionListener(ev);
		funcInserir.addActionListener(ev);
		contaInserir.addActionListener(ev);
		alterarCli.addActionListener(ev);
		alterarConta.addActionListener(ev);
		alterarFunc.addActionListener(ev);
		listaCli.addActionListener(ev);
		//
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setSize(915,575);
		setResizable(false);
		setLocationRelativeTo(null);
		
		/*Panel panel = new Panel();
		c.add(panel,BorderLayout.CENTER);*/
		
	}
	public static void main(String[] args) {
		new JanelaGestao();
	}
	private class Panel extends JPanel {
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Image img = fundo.getImage();
			g.drawImage(img,0,0,this);
		}
	}
	private class Evento implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String alt;
			if(e.getSource()==alterarCli) {
				new JanelaAlterarCliente();
			}
			if(e.getSource()==alterarConta) {
				
				dispose();
			}
			if(e.getSource()==alterarFunc) {
				
				dispose();
			}
			if(e.getSource()==clientesInserir) {
				new JanelaInserirClientes().setVisible(true);
			}
			if(e.getSource()==funcInserir) {
				new JanelaInserirFuncionario().setVisible(true);
			}
			if(e.getSource()==contaInserir) {
				new JanelaInserirConta().setVisible(true);
			}
			if(e.getSource()==listaCli) {
				new ListarClientes().setVisible(true);
			}
		}
		
	}
}
