package qtx.componentes;
/*
   Esta clase es usada por la clase 'PC'.
*/

public class Monitor extends ComponentePC
{
  
 public Monitor(String marca, String modelo)
 {
  this.marca = marca;
  this.modelo = modelo;
 }
	public String getIdentificacion(){
		return "Monitor";
	}
	public float cotizar(int cantidad){
		if(cantidad < 3)
			return this.precioUnitario * cantidad;
		if(cantidad >=3 && cantidad <= 5)
			return this.precioUnitario * cantidad * 0.95f;
		return this.precioUnitario * cantidad * 0.9f;
	}
 
 public void desplegarCaracteristicas()
 {
  System.out.println("--------------------");
  System.out.println("MONITOR:");
  System.out.println("   Marca     : " + this.marca);
  System.out.println("   Modelo    : " + this.modelo);
  System.out.println("--------------------");
 }
 
 public void desplegar(String imagen)
 {
  System.out.println("Desplegando imagen...\n");
  System.out.println(imagen);
  System.out.println("");
 }
}
