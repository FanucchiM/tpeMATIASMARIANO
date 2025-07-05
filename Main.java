package tpeMATIMARIAN;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String archivo = "config.txt";
        LectorConfig.DatosEntrada entrada = LectorConfig.leerArchivo(archivo);

        int objetivo = entrada.objetivo;
        List<Maquina> maquinas = entrada.maquinas;


        // Ejecutamos el backtracking
            System.out.println("Solucion Backtracking: ");
            Backtracking bt = new Backtracking();
            Backtracking.Resultado resultado = bt.backtrackingOptimo(objetivo, maquinas);

            // Imprimimos los resultados
            System.out.println("Cantidad de piezas producidas: " +objetivo);
            System.out.println("Cantidad de maquinas utilizadas: " + resultado.secuencia.size());
            for (int i = 0; i < resultado.secuencia.size(); i++) {
                System.out.print("["+resultado.secuencia.get(i).getNombre() + " - "+ resultado.secuencia.get(i).getPiezas() + " piezas" +"]" );
            }

            if (resultado.secuencia.isEmpty()) {
                System.out.println("No se encontro una secuencia para producir la cantidad de piezas pedidas.");
            }
            System.out.println();

            System.out.println("Cantidad de estados generados: " + resultado.llamadas);


        System.out.println();
        System.out.println("Solucion Greedy: ");
        Greedy.GreedyMethod(objetivo, maquinas);


    }
    }
