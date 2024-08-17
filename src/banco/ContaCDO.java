package banco;
import java.io.Serializable;
import java.time.*;
public class ContaCDO implements Serializable{
	private int numUCDO;
	private LocalDate dataAber;
	private LocalTime horaAber;
	private double saldo;
	private ClienteBanco cliente;
	private String pin;
	public ContaCDO(int numUCDO, LocalDate dataAber, LocalTime horaAber, double saldo,ClienteBanco cliente,String pin) {
		this.numUCDO = numUCDO;
		this.dataAber = dataAber;
		this.horaAber = horaAber;
		this.saldo = saldo;
		this.cliente = cliente;
		this.pin = pin;
	}
	
	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public ClienteBanco getCliente() {
		return cliente;
	}

	public void setCliente(ClienteBanco cliente) {
		this.cliente = cliente;
	}

	public int getNumUCDO() {
		return numUCDO;
	}

	public void setNumUCDO(int numUCDO) {
		this.numUCDO = numUCDO;
	}

	public LocalDate getDataAber() {
		return dataAber;
	}

	public void setDataAber(LocalDate dataAber) {
		this.dataAber = dataAber;
	}

	public LocalTime getHoraAber() {
		return horaAber;
	}

	public void setHoraAber(LocalTime horaAber) {
		this.horaAber = horaAber;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "ContaCDO [numUCDO=" + numUCDO +"Cliente="+", dataAber=" + dataAber + ", horaAber=" + horaAber + ", saldo=" + saldo
				+ "]";
	}
	
	
}
