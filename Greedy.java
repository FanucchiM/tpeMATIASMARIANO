package tpeMATIMARIAN;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Greedy {



	//es void, tiene que devolver lista, si no tiene nada y salio mal lista vacia y sino con los results

	public static void GreedyMethod(int total, List<Maquina> maq) {
		 int llamadas = 0;




		List<Maquina> secuencia = new ArrayList<>();
		  int resto = total;
		  int candidatosConsiderados = 0;
		  //Ordenamos las maquinas por cantidad de piezas de mayor a menor.
		maq.sort((m1, m2) -> Integer.compare(m2.getPiezas(), m1.getPiezas()));

		int i = 0;
		while (i < maq.size() && resto > 0) {
			candidatosConsiderados++;

			Maquina m = maq.get(i);

			if (m.getPiezas() <= resto) {
				secuencia.add(m);
				resto -= m.getPiezas();

			} else {
				i++;
			}
		}






		// Mostrar resultados


		if (resto>0){
			//Si no hay un candidato adecuado devolvemos vacio
			secuencia.clear();
			candidatosConsiderados = 0;
			System.out.println("No hay una solucion adecuada");
		} else if (resto ==0){

				System.out.print("Solucion obtenida (secuencia de maquinas): ");
				for(Maquina m : secuencia) {
					System.out.print("["+m.getNombre() + "-" + m.getPiezas() + " piezas" + "]");
				}



			System.out.println();
			System.out.println("Cantidad de piezas producidas: " +total);

			System.out.println();


			System.out.println("Cantidad de estados generados: " + candidatosConsiderados);
		}








	}




}
