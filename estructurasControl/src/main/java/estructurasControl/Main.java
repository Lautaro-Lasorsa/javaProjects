package estructurasControl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Creo una lista e ingreso una serie de valores
		ArrayList<Integer> lista = new ArrayList<Integer>();
		// Scanner me permite obtener valores desde la consola
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese 10 n�meros enteros:");
		// Itero 10 veces para leer los valores ingresados por el usuario
		for (int i = 1; i < 11; i++) {
			System.out.print(i + ") ");
			int a = sc.nextInt();
			lista.add(a);
		}
		/*
		 * En este punto la lista contiene los 10 enteros. Notese que en ningun
		 * momento se defini� el tama�o de la lista, sino que din�micamente se
		 * asigna el espacio necesario seg�n los elementos que se van agregando.
		 */

		// Ahora vamos a jugar un poco con los valores de la lista.
		// Recorremos la lista de punta a punta y mostramos los valores que
		// tiene.
		mostrarListaCompleta(lista);
		// Buscamos el mayor n�mero en esa lista.
		buscarMayor(lista);

		// Creamos una nueva lista con los valores ordenados.
		// Ordenamiento manual de las listas.
		ArrayList<Integer> listaOrdenadaAsc = ordenarLista(lista, Ordenamiento.ASCENDENTE);
		mostrarListaCompleta(listaOrdenadaAsc);
		ArrayList<Integer> listaOrdenadaDesc = ordenarLista(lista, Ordenamiento.DESCENDENTE);
		mostrarListaCompleta(listaOrdenadaDesc);

		// Mostramos los valores ordenados seg�n el m�todo de la collection.
		mostrarListaOrdenada(lista, Ordenamiento.ASCENDENTE);
		mostrarListaOrdenada(lista, Ordenamiento.DESCENDENTE);
	}

	private static void mostrarListaOrdenada(ArrayList<Integer> lista, Ordenamiento modo) {
		ArrayList<Integer> listaOrdenada = new ArrayList<Integer>();
		for (Integer val : lista) {
			listaOrdenada.add(val);
		}

		if (modo == Ordenamiento.ASCENDENTE) {
			System.out.println("Lista ordenada con el m�todo Collection de forma Ascendente");
			Collections.sort(listaOrdenada);
		} else {
			System.out.println("Lista ordenada con el m�todo Collection de forma Descendente");
			Collections.sort(listaOrdenada, Collections.reverseOrder());
		}

		mostrarListaCompleta(listaOrdenada);
	}

	private static ArrayList<Integer> ordenarLista(ArrayList<Integer> lista, Ordenamiento modo) {
		ArrayList<Integer> listaOrdenada = new ArrayList<Integer>();
		for (Integer val : lista) {
			listaOrdenada.add(val);
		}

		if (modo == Ordenamiento.ASCENDENTE)
			ordenarListaAscendente(listaOrdenada);
		else
			ordenarListaDescendente(listaOrdenada);
		
		return listaOrdenada;
	}

	private static void ordenarListaDescendente(ArrayList<Integer> listaOrdenada) {
		System.out.println("Ordenando lista de forma Descendente");
		
		int tmp;

		for (int i = 0; i < listaOrdenada.size() - 1; i++) {
			for (int j = i; j < listaOrdenada.size(); j++) {
				if (listaOrdenada.get(j) > listaOrdenada.get(i)) {
					tmp = listaOrdenada.get(i);
					listaOrdenada.set(i, listaOrdenada.get(j));
					listaOrdenada.set(j, tmp);
				}
			}
		}
	}

	private static void ordenarListaAscendente(ArrayList<Integer> listaOrdenada) {
		System.out.println("Ordenando lista de forma Ascendente");
		
		int tmp;

		for (int i = 0; i < listaOrdenada.size() - 1; i++) {
			for (int j = i; j < listaOrdenada.size(); j++) {
				if (listaOrdenada.get(j) < listaOrdenada.get(i)) {
					tmp = listaOrdenada.get(i);
					listaOrdenada.set(i, listaOrdenada.get(j));
					listaOrdenada.set(j, tmp);
				}
			}
		}
	}

	private static void mostrarListaCompleta(ArrayList<Integer> lista) {
		System.out.println("Los valores de la lista son:");
		for (Integer val : lista) {
			System.out.println(val);
		}
	}

	private static void buscarMayor(ArrayList<Integer> lista) {
		int mayor = 0;

		for (Integer val : lista) {
			if (val > mayor)
				mayor = val;
		}

		System.out.println("El mayor n�mero de la lista es: " + mayor);
	}

}
