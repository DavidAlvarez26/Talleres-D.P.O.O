package uniandes.dpoo.aerolinea.modelo.tarifas;


import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteCorporativo;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteNatural;

public class CalculadoraTarifasTemporadaBaja extends CalculadoraTarifas{
	protected static final int COSTO_POR_KM_NATURAL=600;
	protected static final int COSTO_POR_KM_CORPORATIVO=900;
	protected static final double DESCUENTO_PEQ=0.02;
	protected static final double DESCUENTO_MEDIANAS=0.1;
	protected static final double DESCUENTO_GRANDES=0.2;
	@Override
	protected int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
	    int distancia = calcularDistanciaVuelo(vuelo.getRuta());

	    if (cliente.getTipoCliente().equals(ClienteNatural.NATURAL)) {
	        return distancia * COSTO_POR_KM_NATURAL;
	    } 
	    else if (cliente.getTipoCliente().equals(ClienteCorporativo.CORPORATIVO)) {
	        return distancia * COSTO_POR_KM_CORPORATIVO;
	    }
	    return 0;
	}

	@Override
	protected double calcularPorcentajeDescuento(Cliente cliente) {
	    if (cliente.getTipoCliente().equals(ClienteCorporativo.CORPORATIVO)) {
	        ClienteCorporativo corp = (ClienteCorporativo) cliente;
	        switch (corp.getTamanoEmpresa()) {
	            case ClienteCorporativo.PEQUENA:
	                return DESCUENTO_PEQ;
	            case ClienteCorporativo.MEDIANA:
	                return DESCUENTO_MEDIANAS;
	            case ClienteCorporativo.GRANDE:
	                return DESCUENTO_GRANDES;
	        }
	    }
	    return 0; 
	}
}
