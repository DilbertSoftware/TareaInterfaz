package logica;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;



public class ListaConsumo {

	private LinkedList<Consumo>consumos;
	private double metrosCubicosFamiliar;
	private double totalFamiliar;
	private double metrosCubicosComercial;
	private double totalComercial;
	public ListaConsumo()
	{
		consumos=new LinkedList<>();
		totalComercial=0;
		totalFamiliar=0;
		metrosCubicosComercial=0;
		metrosCubicosFamiliar=0;
	}
	
	
	
	
	public LinkedList<Consumo> getConsumos() {
		return consumos;
	}




	public void setConsumos(LinkedList<Consumo> consumos) {
		this.consumos = consumos;
	}




	public double getMetrosCubicosFamiliar() {
		return metrosCubicosFamiliar;
	}




	public void setMetrosCubicosFamiliar(double metrosCubicosFamiliar) {
		this.metrosCubicosFamiliar = metrosCubicosFamiliar;
	}




	public double getMetrosCubicosComercial() {
		return metrosCubicosComercial;
	}




	public void setMetrosCubicosComercial(double metrosCubicosComercial) {
		this.metrosCubicosComercial = metrosCubicosComercial;
	}




	public void setTotalFamiliar(double totalFamiliar) {
		this.totalFamiliar = totalFamiliar;
	}




	public void setTotalComercial(double totalComercial) {
		this.totalComercial = totalComercial;
	}




	public double getTotalFamiliar() {
		return totalFamiliar;
	}




	public double getTotalComercial() {
		return totalComercial;
	}




	public void cargarConsumo(String ruta)
	{
		cargarListaConsumo(ruta);
	}

	private void cargarListaConsumo(String ruta) {
		try {
		LinkedList<String>lista=new LinkedList<>(Files.readAllLines(Paths.get(ruta)));	
		cargarConsumo(lista);
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

	private void cargarConsumo(LinkedList<String> listaConsumos) {
		for(String consumo:listaConsumos)
		{
			try
			{
				String partes[]=consumo.split(",");
				String tipo=partes[0];
				String nombre=partes[1];
				String direccion=partes[2];
				String documento=partes[3];
				double consumoMetro=Double.parseDouble(partes[4]);
				
				Consumo guardar;
				
				if(tipo.equalsIgnoreCase("F"))
				{
					guardar=new ClienteFamiliar(nombre, direccion, Long.parseLong(documento), consumoMetro);
					totalFamiliar+=guardar.calcularGastoDeConsumo();
					metrosCubicosFamiliar+=consumoMetro;
				}
				else
				{
					guardar=new ClienteComercial(nombre, direccion, documento, consumoMetro);
					totalComercial+=guardar.calcularGastoDeConsumo();
					metrosCubicosComercial+=consumoMetro;
					}
				consumos.add(guardar);
			}catch(Exception ex)
			{
				
			}
			
		}
		
	}

	public Iterator<Consumo> iterador() {
		// TODO Auto-generated method stub
		return consumos.iterator();
	}
}
