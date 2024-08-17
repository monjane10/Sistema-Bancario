package banco;

import java.io.Serializable;
import java.time.*;

public class OpCDO implements Serializable{
	private int numUopCDO;
	private ContaCDO conta;
	private LocalDate dataOp;
	private LocalTime horaOp;
	private String tipoOp;
	private double montanteMovi;
	
	public OpCDO(int numUopCDO,ContaCDO conta) {
		this.numUopCDO = numUopCDO;
		this.conta = conta;
	}

	public boolean transferir(double valor,ContaCDO cont) {
		if(this.conta.getSaldo()>=valor) {
			LocalDate data = LocalDate.now();
			LocalTime hora = LocalTime.now();
			this.conta.setSaldo(this.conta.getSaldo()-valor);
			cont.setSaldo(cont.getSaldo()+valor);
			this.dataOp = data;
			this.horaOp = hora;
			this.tipoOp = "Transfêrencia";
			this.montanteMovi = -valor;
			return true;
		}
		return false;
	}
	
	public void depositar(double valor) {
		LocalDate data = LocalDate.now();
		LocalTime hora = LocalTime.now();
		this.conta.setSaldo(this.conta.getSaldo()+valor);
		this.dataOp = data;
		this.horaOp = hora;
		this.tipoOp = "Depósito";
		this.montanteMovi = +valor;
	}
	public boolean levantar(double valor) {
		if(this.conta.getSaldo()>=valor) {
			LocalDate data = LocalDate.now();
			LocalTime hora = LocalTime.now();
			this.conta.setSaldo(this.conta.getSaldo()-valor);
			this.dataOp = data;
			this.horaOp = hora;
			this.tipoOp = "Levantamento";
			this.montanteMovi = -valor;
			return true;
		}
		return false;
	}
	public int getNumUopCDO() {
		return numUopCDO;
	}

	public void setNumUopCDO(int numUopCDO) {
		this.numUopCDO = numUopCDO;
	}

	public ContaCDO getConta() {
		return conta;
	}

	public void setConta(ContaCDO conta) {
		this.conta = conta;
	}

	public LocalDate getDataOp() {
		return dataOp;
	}

	public void setDataOp(LocalDate dataOp) {
		this.dataOp = dataOp;
	}

	public LocalTime getHoraOp() {
		return horaOp;
	}

	public void setHoraOp(LocalTime horaOp) {
		this.horaOp = horaOp;
	}

	public String getTipoOp() {
		return tipoOp;
	}

	public void setTipoOp(String tipoOp) {
		this.tipoOp = tipoOp;
	}

	public double getMontanteMovi() {
		return montanteMovi;
	}

	public void setMontanteMovi(double montanteMovi) {
		this.montanteMovi = montanteMovi;
	}
	@Override
	public String toString() {
		return "OpCDO [numUopCDO=" + numUopCDO + ", conta=" + conta + ", dataOp=" + dataOp + ", horaOp=" + horaOp
				+ ", tipoOp=" + tipoOp + ", montanteMovi=" + montanteMovi + "]";
	}
	
	
}
