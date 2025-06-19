package tpeMATIMARIAN;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Greedy {
	
	
	public static void GreedyMethod(int total, List<Maquina> maq) {

		//es void, tiene que devolver lista, si no tiene nada y salio mal lista vacia y sino con los results
		System.out.println("Cantidad de de candidatos considerados: " + maq.size());

		List<Maquina> secuencia = new ArrayList<>();
		  int resto = total;
		  int candidatosConsiderados = 0;
		  //Ordenamos las maquinas por cantidad de piezas de mayor a menor.
		  Collections.sort(maq);

		  while(!maq.isEmpty() && resto > 0) {
				  Maquina mejor = mejorCandidato(maq, resto);
				  if(mejor != null) {
					  secuencia.add(mejor);
					  resto = resto - mejor.getPiezas();
				  }
		  }
		  if (maq.isEmpty()){
			//Si no hay un candidato adecuado devolvemos null
			secuencia.clear();
			System.out.println("No hay una solucion adecuada");

		}

	        // Mostrar resultados

			if(!secuencia.isEmpty()) {
				System.out.print("Solucion obtenida (secuencia de maquinas): ");
				for(Maquina m : secuencia) {
					System.out.print("["+m.getNombre() + "-" + m.getPiezas() + " piezas" + "]");
				}

			}

			System.out.println();
			System.out.println("Cantidad de piezas producidas: " +total);



	}

	public static Maquina mejorCandidato(List<Maquina> machine, int objetivo){
		for(int i = 0; i < machine.size(); i++){
			//si la maquina hace mas piezas de las que necesito no la necesito mas
			if(machine.get(i).getPiezas() <= objetivo) {
				return machine.get(i);
			}else {
				machine.remove(i);
				return null;
			}
		}
		return null;
	}




}
