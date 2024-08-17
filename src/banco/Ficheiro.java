package banco;

import java.util.Vector;
import java.io.*;
public class Ficheiro {
	
	public static Vector fichLer(String file) {
		Vector v = new Vector<>();
		try {
			FileInputStream fi = new FileInputStream(file);
			ObjectInputStream ler = new ObjectInputStream(fi);
			v = (Vector)ler.readObject();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return v;
	}
	public static void fichEscreve(String file,Vector v) {
		try {
			FileOutputStream fi = new FileOutputStream(file);
			ObjectOutputStream escre = new ObjectOutputStream(fi);
			escre.writeObject(v);
			escre.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
