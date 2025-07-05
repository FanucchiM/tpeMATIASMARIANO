package tpeMATIMARIAN;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LectorConfig {
    public static class DatosEntrada {
        public int objetivo;
        public List<Maquina> maquinas;

        public DatosEntrada(int objetivo, List<Maquina> maquinas) {
            this.objetivo = objetivo;
            this.maquinas = maquinas;
        }
    }

    public static DatosEntrada leerArchivo(String rutaArchivo) {
        int objetivo = 0;
        List<Maquina> maquinas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            objetivo = Integer.parseInt(br.readLine().trim());
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                String nombre = partes[0].trim();
                int piezas = Integer.parseInt(partes[1].trim());
                maquinas.add(new Maquina(nombre, piezas));
            }
        } catch (IOException e) {
            System.out.println("Error leyendo archivo: " + e.getMessage());
        }

        return new DatosEntrada(objetivo, maquinas);
    }
}
