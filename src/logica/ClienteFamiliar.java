package logica;

public class ClienteFamiliar implements Consumo {

	 private String nombre;
	 private String direcci�n;
	 private long cedula;
	 private double metrosConsumidos;
	 
	 
	public ClienteFamiliar(String nombre, String direcci�n, long cedula, double metrosConsumidos) {
		super();
		this.nombre = nombre;
		this.direcci�n = direcci�n;
		this.cedula = cedula;
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


	public long getCedula() {
		return cedula;
	}


	public void setCedula(long cedula) {
		this.cedula = cedula;
	}


	public double getMetrosConsumidos() {
		return metrosConsumidos;
	}


	public void setMetrosConsumidos(double metrosConsumidos) {
		this.metrosConsumidos = metrosConsumidos;
	}


	@Override
	public String toString() {
		return "Cliente Familiar [nombre=" + nombre + ", direcci�n=" + direcci�n + ", cedula=" + cedula
				+ ", metrosConsumidos=" + metrosConsumidos + "]";
	}


	@Override
	public double calcularGastoDeConsumo() {
		double totalPagar=Consumo.CARGOFIJOFLIA;
		if(metrosConsumidos<=10)
			totalPagar=totalPagar+100*metrosConsumidos;
		else {
			totalPagar=totalPagar+1000;
			metrosConsumidos=metrosConsumidos-10;
			if(metrosConsumidos<=10)
			{
				totalPagar=totalPagar+metrosConsumidos*120;
			}
			else {
				totalPagar=totalPagar+1200;
				totalPagar=totalPagar+(metrosConsumidos-10)*135;
			}
		}
		return totalPagar;
	}

}
