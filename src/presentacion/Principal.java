package presentacion;

import java.util.Iterator;

import logica.Consumo;
import logica.ListaConsumo;

public class Principal {

	public static void main(String args[])
	{
		String archivo="src/archivo/RegistoConsumo.txt";
		ListaConsumo consumos=new ListaConsumo();
		consumos.cargarConsumo(archivo);
		
		Iterator<Consumo>it=consumos.iterador();
		while(it.hasNext())
		{
			Consumo consumo=it.next();
			System.out.println(consumo);
		}
		System.out.println("Metros cubicos familiar 	: "+consumos.getMetrosCubicosFamiliar());
		System.out.println("Total de familiar es 		: $"+consumos.getTotalFamiliar());
		System.out.println("Metros cubicos comercial 	: "+consumos.getMetrosCubicosFamiliar());
		System.out.println("Total de comercial es 		: $"+consumos.getTotalComercial());
		
	}
}
