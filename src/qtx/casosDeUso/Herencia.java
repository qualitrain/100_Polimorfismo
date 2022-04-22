package qtx.casosDeUso;

import qtx.componentes.DiscoDuro;
import qtx.componentes.Monitor;
import qtx.componentes.PC;
import qtx.componentes.TarjetaVideo;
import qtx.servicios.CotizadorImpl2ArrayList;


/* Ejercicio Herencia */

/*
   En este directorio se incluyen las clases 
   - Monitor
   - Disco Duro
   - Tarjeta Video
   Cada una de estas clases tiene 2 atributos comunes:
   - marca
   - modelo
   
   1.- Modifique estas 3 clases de manera que hereden de una superclase llamada 'ComponentePC',
       en la que se encuentren estos atributos.  
       
   2.- Cree una clase llamada PC que también herede de ComponentePC y que este compuesta 
       por las clases Monitor, DiscoDuro y TarjetaVideo   
       
   3.- Implemente un método desplegarCaracterísticas en la clase PC que muestra sus
       propias características y las de sus componentes.
*/
class Herencia{
public static void main(String[] args){
	DiscoDuro disco1=new DiscoDuro("Seagate","XD34","400Gb");
	disco1.setPrecioUnitario(555.0f);
	DiscoDuro disco2=new DiscoDuro("Dell","Z360","600Gb");
	disco2.setPrecioUnitario(445.0f);

	DiscoDuro[] arrDiscos =new DiscoDuro[]{disco1,disco2};
	
	TarjetaVideo tarjeta = new TarjetaVideo("Sony","YOKO34","2Gb");
	Monitor monitor = new Monitor("Samsung","Flat-56");
	monitor.setPrecioUnitario(1000.0f);
	PC miPc = new PC("Dell","Latitude E456",tarjeta,monitor,arrDiscos);
	miPc.desplegarCaracteristicas();
	tarjeta.setPrecioUnitario(100.0f);
	for (int unidades=1;unidades<11;unidades++)
		System.out.println("Cotización de "+unidades+" unidades de "+tarjeta.getIdentificacion()+"="+
			tarjeta.cotizar(unidades));
	System.out.println("Cotización de "+2+" unidades de "+miPc.getIdentificacion()+"="+
		miPc.cotizar(2));
	System.out.println("Cotización de "+4+" unidades de "+monitor.getIdentificacion()+"="+
			monitor.cotizar(4));

	CotizadorImpl2ArrayList cotizador = new CotizadorImpl2ArrayList();
	cotizador.agregarItem(miPc, 3);
	cotizador.agregarItem(monitor, 5);
	cotizador.agregarItem(disco2, 10);
	cotizador.agregarItem(tarjeta, 7);
	cotizador.mostrarCotizacion();
	cotizador.mostrarCotizacionFormatoB();
	}
	
}
