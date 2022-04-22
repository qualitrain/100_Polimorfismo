package qtx.componentes;

import java.util.List;

public abstract class ComponentePC{
	protected String marca;
	protected String modelo;
	protected float precioUnitario;
	
	public abstract void desplegarCaracteristicas();
	
	public String getIdentificacion(){
		return "Componente genérico";
	}
	public float cotizar(int cantidad){
		return this.precioUnitario * cantidad;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public float getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(float precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public TipoComponente getTipo() {
		if(this instanceof DiscoDuro)
			return TipoComponente.DISCO_DURO;
		if(this instanceof TarjetaVideo)
			return TipoComponente.TARJETA_VIDEO;
		if(this instanceof Monitor)
			return TipoComponente.MONITOR;
		if(this instanceof PC)
			return TipoComponente.PC;
		return TipoComponente.INDEFINIDO;
	}
	public static ComponentePC crear(TipoComponente tipo, String marca, String modelo) {
		return crear(tipo, marca, modelo, null);
	}
	public static ComponentePC crearAgregado(TipoComponente tipo, String marca, String modelo, List<ComponentePC> subComponentes) {
		switch(tipo) {
		case PC:
			PC pc = new PC(marca,modelo);
			for(ComponentePC subcomI : subComponentes) {
				if(subcomI.getTipo() == TipoComponente.MONITOR) {
					pc.setMonitor((Monitor) subcomI);
					continue;
				}
				if(subcomI.getTipo() == TipoComponente.DISCO_DURO) {
					pc.agregarDisco((DiscoDuro) subcomI);
					continue;
				}
				if(subcomI.getTipo() == TipoComponente.TARJETA_VIDEO) {
					pc.setTarjetaVideo((TarjetaVideo) subcomI);
				}
			}
			return pc;
		default:
			return null;
		}
	}
	
	public static ComponentePC crear(TipoComponente tipo, String marca, String modelo, String capacidad) {
		switch (tipo)
		{
		case DISCO_DURO:
			return new DiscoDuro(marca, modelo, capacidad);
		case TARJETA_VIDEO:
			return new TarjetaVideo(marca,modelo,capacidad);
		case MONITOR:
			return new Monitor(marca,modelo);
		default:
			
			break;
		}
		return null;
	}
	
}