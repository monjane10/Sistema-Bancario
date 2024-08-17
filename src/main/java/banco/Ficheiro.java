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
            System.out.print(e.getMessage());
        }
        return v;
    }
    
    public static void fichEscreve(String file, Vector v) {
        try {
            FileOutputStream fi = new FileOutputStream(file);
            ObjectOutputStream esc = new ObjectOutputStream(fi);
            esc.writeObject(v);
            esc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
