package uniandes.dpoo.aerolinea.persistencia;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import uniandes.dpoo.aerolinea.modelo.Aerolinea;
import uniandes.dpoo.aerolinea.modelo.Avion;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.exceptions.InformacionInconsistenteException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PersistenciaAerolineaJson implements IPersistenciaAerolinea {

    @Override
    public void cargarAerolinea(String archivo, Aerolinea aerolinea) throws IOException, InformacionInconsistenteException {
        try (FileReader reader = new FileReader(archivo)) {
            JSONObject root = new JSONObject(new JSONTokener(reader));

            // Aviones
            JSONArray avionesJson = root.getJSONArray("aviones");
            for (int i = 0; i < avionesJson.length(); i++) {
                JSONObject avionJson = avionesJson.getJSONObject(i);
                String nombre = avionJson.getString("nombre");
                int capacidad = avionJson.getInt("capacidad");
                Avion avion = new Avion(nombre, capacidad);
                aerolinea.agregarAvion(avion);
            }

            // Rutas
            JSONArray rutasJson = root.getJSONArray("rutas");
            for (int i = 0; i < rutasJson.length(); i++) {
                JSONObject rutaJson = rutasJson.getJSONObject(i);
                String codigo = rutaJson.getString("codigo");
                String horaSalida = rutaJson.getString("horaSalida");
                String horaLlegada = rutaJson.getString("horaLlegada");

                
                Ruta ruta = new Ruta(null, null, horaSalida, horaLlegada, codigo);
                aerolinea.agregarRuta(ruta);
            }

            // Vuelos
            JSONArray vuelosJson = root.optJSONArray("vuelos");
            if (vuelosJson != null) {
                for (int i = 0; i < vuelosJson.length(); i++) {
                    JSONObject vueloJson = vuelosJson.getJSONObject(i);
                    String fecha = vueloJson.getString("fecha");
                    String codigoRuta = vueloJson.getString("codigoRuta");
                    String nombreAvion = vueloJson.getString("nombreAvion");

                    Ruta ruta = aerolinea.getRuta(codigoRuta);
                    Avion avion = aerolinea.getAviones().stream()
                            .filter(a -> a.getNombre().equals(nombreAvion))
                            .findFirst()
                            .orElseThrow(() -> new InformacionInconsistenteException("Avión no encontrado: " + nombreAvion));

                    Vuelo vuelo = new Vuelo(fecha, avion, ruta);
                    aerolinea.getVuelos().add(vuelo);
                }
            }
        }
    }

    @Override
    public void salvarAerolinea(String archivo, Aerolinea aerolinea) throws IOException {
        JSONObject root = new JSONObject();

        // Aviones
        JSONArray avionesJson = new JSONArray();
        for (Avion avion : aerolinea.getAviones()) {
            JSONObject avionJson = new JSONObject();
            avionJson.put("nombre", avion.getNombre());
            avionJson.put("capacidad", avion.getCapacidad());
            avionesJson.put(avionJson);
        }
        root.put("aviones", avionesJson);

        // Rutas
        JSONArray rutasJson = new JSONArray();
        for (Ruta ruta : aerolinea.getRutas()) {
            JSONObject rutaJson = new JSONObject();
            rutaJson.put("codigo", ruta.getCodigoRuta());
            rutaJson.put("horaSalida", ruta.getHoraSalida());
            rutaJson.put("horaLlegada", ruta.getHoraLlegada());
            rutasJson.put(rutaJson);
        }
        root.put("rutas", rutasJson);

        // Vuelos
        JSONArray vuelosJson = new JSONArray();
        for (Vuelo vuelo : aerolinea.getVuelos()) {
            JSONObject vueloJson = new JSONObject();
            vueloJson.put("fecha", vuelo.getFecha());
            vueloJson.put("codigoRuta", vuelo.getRuta().getCodigoRuta());
            vueloJson.put("nombreAvion", vuelo.getAvion().getNombre());
            vuelosJson.put(vueloJson);
        }
        root.put("vuelos", vuelosJson);

        try (FileWriter writer = new FileWriter(archivo)) {
            writer.write(root.toString(4)); // 4 = indentación
        }
    }
}