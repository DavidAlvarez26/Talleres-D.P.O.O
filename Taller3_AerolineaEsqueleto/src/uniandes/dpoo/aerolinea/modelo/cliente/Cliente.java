package uniandes.dpoo.aerolinea.modelo.cliente;

import java.util.ArrayList;
import java.util.List;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public abstract class Cliente {
	private List<Tiquete> tiquetesSinUsar;
	private List<Tiquete> tiquetesUsados;
	public Cliente() {
		this.tiquetesSinUsar = new ArrayList<>();
		this.tiquetesUsados = new ArrayList<>();
	}
	public abstract String getTipoCliente();
	public abstract String getIdentificador();
	public void agregarTiquete(Tiquete tiquete) {
        tiquetesSinUsar.add(tiquete);
    }
	public int calcularValorTotalTiquetes() {
        int total = 0;
        for (Tiquete t : tiquetesSinUsar) {
            total += t.getTarifa();
        }
        for (Tiquete t : tiquetesUsados) {
            total += t.getTarifa();
        }
        return total;
    }

    public void usarTiquetes(Vuelo vuelo) {
        List<Tiquete> usadosAhora = new ArrayList<>();
        for (Tiquete t : tiquetesSinUsar) {
            if (t.getVuelo().equals(vuelo)) {
                usadosAhora.add(t);
            }
        }
        tiquetesSinUsar.removeAll(usadosAhora);
        tiquetesUsados.addAll(usadosAhora);
    }

    public List<Tiquete> getTiquetesSinUsar() {
        return tiquetesSinUsar;
    }

    public List<Tiquete> getTiquetesUsados() {
        return tiquetesUsados;
    }
}

