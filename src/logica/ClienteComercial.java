package logica;

public class ClienteComercial implements Consumo {

	private String nombre;
	private String dirección;
	private String rut;
	private double metrosConsumidos;
	
	
	
	public ClienteComercial(String nombre, String dirección, String rut, double metrosConsumidos) {
		super();
		this.nombre = nombre;
		this.dirección = dirección;
		this.rut = rut;
		this.metrosConsumidos = metrosConsumidos;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getDirección() {
		return dirección;
	}



	public void setDirección(String dirección) {
		this.dirección = dirección;
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
		return "Cliente Comercial  nombre=" + nombre + ", dirección=" + dirección + ", rut=" + rut
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
