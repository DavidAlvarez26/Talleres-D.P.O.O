package uniandes.dpoo.aerolinea.tiquetes;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class Tiquete {
	private String codigo;
	private int tarifa;
	private boolean usado;
	private Vuelo vuelo;
	private Cliente clienteComprador;

	public Tiquete(String codigo,  Vuelo vuelo, Cliente clienteComprador,int tarifa) {

		this.codigo = codigo;
		this.tarifa = tarifa;
		this.vuelo = vuelo;
		this.clienteComprador = clienteComprador;
		this.usado=false;
	}

	public String getCodigo() {
		return codigo;
	}

	public Cliente getClienteComprador() {
		return clienteComprador;
	}

	public int getTarifa() {
		return tarifa;
	}
	public Vuelo getVuelo() {
		return vuelo;
	}
	public void marcarComoUsado() {
		this.usado=true;
	}
	public Boolean EsUsado() {
		if(usado==true){
			return true;
		}
		else {
			return false;
		}
		
	}

}
