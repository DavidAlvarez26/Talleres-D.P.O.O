package uniandes.dpoo.aerolinea.modelo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import uniandes.dpoo.aerolinea.exceptions.VueloSobrevendidoException;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.tarifas.CalculadoraTarifas;
import uniandes.dpoo.aerolinea.tiquetes.GeneradorTiquetes;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public class Vuelo {
    private String fecha;
    private Avion avion;
    private Ruta ruta;
    private Map<String, Tiquete> tiquetes;

    public Vuelo(String fecha, Avion avion, Ruta ruta) {
        this.fecha = fecha;
        this.avion = avion;
        this.ruta = ruta;
        this.tiquetes = new HashMap<>();
    }

    public String getFecha() {
        return fecha;
    }

    public Avion getAvion() {
        return avion;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public Collection<Tiquete> getTiquetes() {
        return tiquetes.values();
    }

    public int venderTiquetes(Cliente cliente, CalculadoraTarifas calculadora, int cantidad) 
            throws VueloSobrevendidoException {

        int capacidad = avion.getCapacidad();
        if (tiquetes.size() + cantidad > capacidad) {
            throw new VueloSobrevendidoException(this);
        }

        int tarifa = calculadora.calcularTarifa(this, cliente);
        int total = 0;

        for (int i = 0; i < cantidad; i++) {
            
            Tiquete tiquete = GeneradorTiquetes.generarTiquete(this, cliente, tarifa);

            tiquetes.put(tiquete.getCodigo(), tiquete);
            cliente.agregarTiquete(tiquete);

            total += tarifa;
        }

        return total;
    }
    public boolean equals(Object obj) {
        if (this == obj) return true;              
        if (obj == null || getClass() != obj.getClass()) return false;

        Vuelo other = (Vuelo) obj;
        return fecha.equals(other.fecha) &&
               ruta.equals(other.ruta) &&
               avion.equals(other.avion);
    }

    
}