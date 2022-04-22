package qtx.casosDeUso;

import java.util.ArrayList;
import java.util.List;

import qtx.componentes.ComponentePC;
import qtx.componentes.TipoComponente;
import qtx.servicios.CotizadorImpl2ArrayList;

public class Test{
	
	public static void main(String[] args){
		testCotizacionArticulos();
		testCotizador();
	}
	public static void testCotizacionArticulos() {
		System.out.println("\n--- Test Cotizacion Simple ---");
		ComponentePC disco1 = ComponentePC.crear(TipoComponente.DISCO_DURO, "Seagate","XD34","400Gb");
		disco1.setPrecioUnitario(555.0f);
		ComponentePC disco2 = ComponentePC.crear(TipoComponente.DISCO_DURO, "Dell","Z360","600Gb");
		disco2.setPrecioUnitario(445.0f);
	
		ComponentePC tarjeta = ComponentePC.crear(TipoComponente.TARJETA_VIDEO,"Sony","YOKO34","2Gb");
		ComponentePC monitor = ComponentePC.crear(TipoComponente.MONITOR,"Samsung","Flat-56");
		monitor.setPrecioUnitario(1000.0f);
		
		List<ComponentePC> subcomponentes = new ArrayList<>();
		subcomponentes.add(tarjeta);
		subcomponentes.add(monitor);
		subcomponentes.add(disco1);
		subcomponentes.add(disco2);
		ComponentePC miPc = ComponentePC.crearAgregado(TipoComponente.PC, "Dell","Latitude E456", subcomponentes);
		miPc.desplegarCaracteristicas();
		tarjeta.setPrecioUnitario(100.0f);
		
		for (int unidades=1;unidades<11;unidades++)
			System.out.println("Cotización de " + unidades+" unidades de " 
							+ tarjeta.getIdentificacion() + "=" 
							+ tarjeta.cotizar(unidades));
		
		System.out.println("Cotización de " + 2 + " unidades de "
				+ miPc.getIdentificacion() + "=" 
				+ miPc.cotizar(2));
		
		System.out.println("Cotización de "+4+" unidades de "+monitor.getIdentificacion()+"="+
				monitor.cotizar(4));
	}
	
	public static void testCotizador() {
		System.out.println("\n--- TestCotizador: Prueba de cotizadores (implementados con un ArrayList) ---");
		ComponentePC disco1 = ComponentePC.crear(TipoComponente.DISCO_DURO, "Seagate","XD34","400Gb");
		disco1.setPrecioUnitario(555.0f);
		ComponentePC disco2 = ComponentePC.crear(TipoComponente.DISCO_DURO, "Dell","Z360","600Gb");
		disco2.setPrecioUnitario(445.0f);
	
		ComponentePC tarjeta = ComponentePC.crear(TipoComponente.TARJETA_VIDEO,"Sony","YOKO34","2Gb");
		ComponentePC monitor = ComponentePC.crear(TipoComponente.MONITOR,"Samsung","Flat-56");
		monitor.setPrecioUnitario(1000.0f);
		
		List<ComponentePC> subcomponentes = new ArrayList<>();
		subcomponentes.add(tarjeta);
		subcomponentes.add(monitor);
		subcomponentes.add(disco1);
		subcomponentes.add(disco2);
		ComponentePC miPc = ComponentePC.crearAgregado(TipoComponente.PC, "Dell","Latitude E456", subcomponentes);
		tarjeta.setPrecioUnitario(100.0f);
		
		CotizadorImpl2ArrayList cotizador = new CotizadorImpl2ArrayList();
		cotizador.agregarItem(miPc, 3);
		cotizador.agregarItem(monitor, 5);
		cotizador.agregarItem(disco2, 10);
		cotizador.agregarItem(tarjeta, 7);
		cotizador.mostrarCotizacion();
		
	}
	
}
