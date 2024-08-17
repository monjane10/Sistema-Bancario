package banco;

import java.time.*;
import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Main extends JFrame{
	static Vector v1;
	static Vector v2;
	static Vector v3;
	private static Ficheiro f;
	public static void main(String[] args) {

		//Vector v = f.fichLer("contaCDOBank.dat");
		
		 
		Ficheiro ficheiro = new Ficheiro();
		new Main();
		FuncionarioBanco fun;
		ClienteBanco cli;
		ContaCDO con;
		v1 = new Vector<>();
		v2 = new Vector<>();
		v3 = new Vector<>();
		
		FuncionarioBanco fun1 = new FuncionarioBanco(2233,"Artur","Souza","37372462036383R","Fomento","1234");
		FuncionarioBanco fun2 = new FuncionarioBanco(1122,"Maria","Pedro","83571360282978L","Boane","4321");
		LocalDate data = LocalDate.now();
		LocalTime ho = LocalTime.now();
		LocalDate dc1 = LocalDate.of(2001, 11, 21);
		LocalDate dc2 = LocalDate.of(2003, 2, 13);
		ClienteBanco cli1 = new ClienteBanco(1234,"Eddy Adriano",dc1,"378749382868T","Liberdade");
		ClienteBanco cli2 = new ClienteBanco(8822,"Beatriz Eduardo",dc2,"9465439373530K","Costa-do-Sol");
		ContaCDO con1 = new ContaCDO(2233, data, ho, 1000.00, cli1, "4422");
		ContaCDO con2 = new ContaCDO(1234, data, ho, 500.00, cli2, "1234");
		v1.add(fun1);
		v1.add(fun2);
		v2.add(cli1);
		v2.add(cli2);
		v3.add(con1);
		v3.add(con2);
		ficheiro.fichEscreve("funcionarioBank5.dat", v1);
		ficheiro.fichEscreve("clienteBank4.dat", v2);
		ficheiro.fichEscreve("contaCDOBank4.dat", v3);
		/*for(int i=0;i < v1.size();i++) {
			FuncionarioBanco p = (FuncionarioBanco) v1.get(i);
			System.out.println(p.toString());

		
		System.out.println("Funcionários");
		for(int i=0;i<v1.size();i++) {
			fun = (FuncionarioBanco)v1.get(i);
			System.out.println(fun.toString());
		}
		System.out.println("Clientes");
		for(int i=0;i<v2.size();i++) {
			cli = (ClienteBanco)v2.get(i);
			System.out.println(cli.toString());
		}
		System.out.println("Conta");
		for(int i=0;i<v3.size();i++) {
			con = (ContaCDO)v3.get(i);
			System.out.println(con.toString());
		}
		FuncionarioBanco fun;
		ClienteBanco cli;
		ContaCDO con;
		String filecli = "clienteBank4.dat";
		String fileC = "contaCDOBank4.dat";
		String filef = "funcionarioBank5.dat";
		try {
			FileInputStream file1 = new FileInputStream(filef);
			FileInputStream file2 = new FileInputStream(filecli);
			FileInputStream file3 = new FileInputStream(fileC);
			ObjectInputStream es1 = new ObjectInputStream(file1);
			ObjectInputStream es2 = new ObjectInputStream(file2);
			ObjectInputStream es3 = new ObjectInputStream(file3);
			v1 = (Vector)es1.readObject();
			v2 = (Vector)es2.readObject();
			v3 = (Vector)es3.readObject();
			System.out.println("Funcionários");
			for(int i=0;i<v1.size();i++) {
				fun = (FuncionarioBanco)v1.get(i);
				System.out.println(fun.toString());
			}
			System.out.println("Clientes");
			for(int i=0;i<v2.size();i++) {
				cli = (ClienteBanco)v2.get(i);
				System.out.println(cli.toString());
			}
			System.out.println("Conta");
			for(int i=0;i<v3.size();i++) {
				con = (ContaCDO)v3.get(i);
				System.out.println(con.toString());
			}
		} catch (Exception e) {
			System.out.println("ERRO: "+e.getMessage());
		}
		LocalTime h = LocalTime.of(18, 0);
		h.plusHours(7);
		System.out.println(h.plusHours(7));*/
	}
}
