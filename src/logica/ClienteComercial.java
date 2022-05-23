package logica;

public class ClienteComercial implements Consumo {

	private String nombre;
	private String direcci�n;
	private String rut;
	private double metrosConsumidos;
	
	
	
	public ClienteComercial(String nombre, String direcci�n, String rut, double metrosConsumidos) {
		super();
		this.nombre = nombre;
		this.direcci�n = direcci�n;
		this.rut = rut;
		this.metrosConsumidos = metrosConsumidos;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getDirecci�n() {
		return direcci�n;
	}



	public void setDirecci�n(String direcci�n) {
		this.direcci�n = direcci�n;
	}



	public String getRut() {
		return rut;
	}



	public void setRut(String rut) {
		this.rut = rut;
	}



	public double getMetrosConsumidos() {
		return metrosConsumidos;
	}



	public void setMetrosConsumidos(double metrosConsumidos) {
		this.metrosConsumidos = metrosConsumidos;
	}



	@Override
	public String toString() {
		return "Cliente Comercial  nombre=" + nombre + ", direcci�n=" + direcci�n + ", rut=" + rut
				+ ", metrosConsumidos=" + metrosConsumidos ;
	}



	@Override
	public double calcularGastoDeConsumo() {
		
		double totalPagar=Consumo.CARGOFIJOCOM;
		if(metrosConsumidos<=10)
			totalPagar=totalPagar+130*metrosConsumidos;
		else {
			totalPagar=totalPagar+1000;
			metrosConsumidos=metrosConsumidos-10;
			if(metrosConsumidos<=10)
			{
				totalPagar=totalPagar+metrosConsumidos*150;
			}
			else {
				totalPagar=totalPagar+1200;
				totalPagar=totalPagar+(metrosConsumidos-10)*160;
			}
		}
		return totalPagar;
	}

}
