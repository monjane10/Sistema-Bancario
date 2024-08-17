package banco;

import java.io.Serializable;

public class FuncionarioBanco implements Serializable{
	//Atributos
	private int numUFunGB;
	private String pNome,apelido;
	private String bI;
	private String residencia;
	private String pin;
	//Método construtor
	public FuncionarioBanco(int numUFunGB, String pNome, String apelido, String bI, String residencia,String pin) {
		this.numUFunGB = numUFunGB;
		this.pNome = pNome;
		this.apelido = apelido;
		this.bI = bI;
		this.residencia = residencia;
		this.pin = pin;
	}
	//Métodos getters e setters
	public int getNumUFunGB() {
		return numUFunGB;
	}

	public void setNumUFunGB(int numUFunGB) {
		this.numUFunGB = numUFunGB;
	}
	
	public  String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getpNome() {
		return pNome;
	}

	public void setpNome(String pNome) {
		this.pNome = pNome;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getbI() {
		return bI;
	}

	public void setbI(String bI) {
		this.bI = bI;
	}

	public String getResidencia() {
		return residencia;
	}

	public void setResidencia(String residencia) {
		this.residencia = residencia;
	}
	@Override
	public String toString() {
		return "FuncionarioBanco [numUFunGB=" + numUFunGB + ", pNome=" + pNome + ", apelido=" + apelido + ", bI=" + bI
				+ ", residencia=" + residencia + "]"+"Pin"+pin;
	}
	
	
}
