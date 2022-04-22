package qtx.servicios;
import java.util.ArrayList;
import java.util.Locale;

import qtx.componentes.ComponentePC;

public class CotizadorImpl2ArrayList  {
	private ArrayList<ComponentePC> items = new ArrayList<ComponentePC>();
	private ArrayList<Integer> cantidades = new ArrayList<Integer>();
	
	public void agregarItem(ComponentePC componente, int cantidad){
		this.items.add(componente);
		this.cantidades.add(cantidad);
	}
	public float cotizar(){
		float totalCotizacion=0f;
		for(int i=0 ; i<this.items.size();i++){
			ComponentePC componenteI = this.items.get(i);
			totalCotizacion+=componenteI.cotizar(this.cantidades.get(i));
		}
		return totalCotizacion;
	}
	public void mostrarCotizacion(){
		float totalCotizacion=0f;
		System.out.println();
		System.out.println("=============================================================================================");
		System.out.println("                                           Cotización  ");
		System.out.println("=============================================================================================");
		for(int i=0 ; i<this.items.size();i++){
			ComponentePC componenteI = this.items.get(i);
			int cantidad = this.cantidades.get(i);
			float cotizacionItem = componenteI.cotizar(cantidad);
			System.out.print(String.format("%2d", cantidad));
			System.out.print(" unidades de "+String.format("%-18s",componenteI.getIdentificacion()));
			System.out.print(" marca "+String.format("%-10s", componenteI.getMarca()));
			System.out.print(", modelo "+String.format("%-14s", componenteI.getModelo()));
			System.out.println(
					", cuestan "+"$ "+String.format("%8.2f",cotizacionItem));
			totalCotizacion+=cotizacionItem;
		}
		System.out.println("=============================================================================================");
		System.out.println("TOTAL: "
				+String.format("%78s", "$ ") 
				+String.format("%8.2f", totalCotizacion));
		
	}
	public void mostrarCotizacionFormatoB(){
		float totalCotizacion=0f;
		Locale localidadGeografica = new Locale("es", "MX");
		System.out.println();
		System.out.println("===================================================================================");
		System.out.println("                                      Cotización  ");
		System.out.println("===================================================================================");
		System.out.print("Cantidad");
		System.out.print(String.format("%20s", "Descripción"));
		System.out.print(String.format("%15s", "Marca"));
		System.out.print(String.format("%15s", "Modelo"));
		System.out.println(String.format("     %15s", "Importe"));
		System.out.println();
		for(int i=0 ; i<this.items.size();i++){
			ComponentePC componenteI = this.items.get(i);
			int cantidad = this.cantidades.get(i);
			float cotizacionItem = componenteI.cotizar(cantidad);
			System.out.print(String.format(" %5d", cantidad));
			System.out.print(String.format("       %-22s",componenteI.getIdentificacion()));
			System.out.print(String.format("   %-10s", componenteI.getMarca()));
			System.out.print(String.format("   %-14s", componenteI.getModelo()));
//			System.out.println("    $ "+String.format("   %8.2f",cotizacionItem));
			System.out.println("       $ "+String.format(localidadGeografica, "%8.2f",cotizacionItem));
			totalCotizacion+=cotizacionItem;
		}
		System.out.println("===================================================================================");
		System.out.println("TOTAL: "
				+String.format("%67s", "$ ") 
				+String.format(localidadGeografica,"%8.2f", totalCotizacion));
	}

	
}
