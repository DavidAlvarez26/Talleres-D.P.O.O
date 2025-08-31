package uniandes.dpoo.estructuras.logica;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre
 * arreglos de enteros y de cadenas.
 *
 * Todos los métodos deben operar sobre los atributos arregloEnteros y
 * arregloCadenas.
 * 
 * No pueden agregarse nuevos atributos.
 * 
 * Implemente los métodos usando operaciones sobre arreglos (ie., no haga cosas
 * como construir listas para evitar la manipulación de arreglos).
 */
public class SandboxArreglos {
	/**
	 * Un arreglo de enteros para realizar varias de las siguientes operaciones.
	 * 
	 * Ninguna posición del arreglo puede estar vacía en ningún momento.
	 */
	private int[] arregloEnteros;

	/**
	 * Un arreglo de cadenas para realizar varias de las siguientes operaciones
	 * 
	 * Ninguna posición del arreglo puede estar vacía en ningún momento.
	 */
	private String[] arregloCadenas;

	/**
	 * Crea una nueva instancia de la clase con los dos arreglos inicializados pero
	 * vacíos (tamaño 0)
	 */
	public SandboxArreglos() {
		arregloEnteros = new int[] {};
		arregloCadenas = new String[] {};
	}

	/**
	 * Retorna una copia del arreglo de enteros, es decir un nuevo arreglo del mismo
	 * tamaño que contiene copias de los valores del arreglo original
	 * 
	 * @return Una copia del arreglo de enteros
	 */
	public int[] getCopiaEnteros() {
		int[] copiaEnteros = new int[arregloEnteros.length];
		for (int i = 0; i < arregloEnteros.length; i++) {
			copiaEnteros[i] = arregloEnteros[i];
		}
		return copiaEnteros;
	}

	/**
	 * Retorna una copia del arreglo de cadenas, es decir un nuevo arreglo del mismo
	 * tamaño que contiene copias de los valores del arreglo original
	 * 
	 * @return Una copia del arreglo de cadenas
	 */
	public String[] getCopiaCadenas() {

		String[] copiaCadenas = new String[arregloCadenas.length];
		for (int i = 0; i < arregloCadenas.length; i++) {
			copiaCadenas[i] = arregloCadenas[i];
		}
		return copiaCadenas;
	}

	/**
	 * Retorna la cantidad de valores en el arreglo de enteros
	 * 
	 * @return
	 */
	public int getCantidadEnteros() {
		return arregloEnteros.length;
	}

	/**
	 * Retorna la cantidad de valores en el arreglo de cadenas
	 * 
	 * @return
	 */
	public int getCantidadCadenas() {
		return arregloCadenas.length;
	}

	/**
	 * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre
	 * debería aumentar en 1 la capacidad del arreglo.
	 * 
	 * @param entero El valor que se va a agregar.
	 */
	public void agregarEntero(int entero) {
		int[] nuevo = new int[arregloEnteros.length + 1];
		for (int i = 0; i < arregloEnteros.length; i++) {
			nuevo[i] = arregloEnteros[i];

		}
		nuevo[nuevo.length - 1] = entero;
		arregloEnteros = nuevo;

	}

	/**
	 * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre
	 * debería aumentar en 1 la capacidad del arreglo.
	 * 
	 * @param cadena La cadena que se va a agregar.
	 */
	public void agregarCadena(String cadena) {
		String[] nuevo = new String[arregloCadenas.length + 1];
		for (int i = 0; i < arregloCadenas.length; i++) {
			nuevo[i] = arregloCadenas[i];
		}
		nuevo[nuevo.length - 1] = cadena;
		arregloCadenas = nuevo;
	}

	/**
	 * Elimina todas las apariciones de un determinado valor dentro del arreglo de
	 * enteros
	 * 
	 * @param valor El valor que se va eliminar
	 */
	public void eliminarEntero(int valor) {
		// creamos arreglo con el numero de valores que no son iguales a el valor a eliminar
		int contador= 0;
		for(int i = 0; i < arregloEnteros.length; i++) {
			if(arregloEnteros[i]!=valor) {
				contador++;	}		
		}
		//nuevo arreglo copiando los que nos son iguales
		int[] arregloeliminar= new int[contador];
		int j=0;
		for (int i = 0; i < arregloEnteros.length; i++) {
			if (arregloEnteros[i]!=valor) {
				arregloeliminar[j]=arregloEnteros[i];
				j++;
			}
		}
		
		arregloEnteros=arregloeliminar;
	}

	/**
	 * Elimina todas las apariciones de un determinado valor dentro del arreglo de
	 * cadenas
	 * 
	 * @param cadena La cadena que se va eliminar
	 */
	public void eliminarCadena(String cadena) {
	    int contador = 0;
	    for (int i = 0; i < arregloCadenas.length; i++) {
	        if (!arregloCadenas[i].equals(cadena)) {
	            contador++;
	        }
	    }

	    String[] eliminarcadena = new String[contador];
	    int j = 0;
	    for (int i = 0; i < arregloCadenas.length; i++) {
	        if (!arregloCadenas[i].equals(cadena)) {
	            eliminarcadena[j] = arregloCadenas[i];
	            j++;
	        }
	    }

	    arregloCadenas = eliminarcadena;
	}
	

	/**
	 * Inserta un nuevo entero en el arreglo de enteros.
	 * 
	 * @param entero   El nuevo valor que debe agregarse
	 * @param posicion La posición donde debe quedar el nuevo valor en el arreglo
	 *                 aumentado. Si la posición es menor a 0, se inserta el valor
	 *                 en la primera posición. Si la posición es mayor que el tamaño
	 *                 del arreglo, se inserta el valor en la última posición.
	 */
	public void insertarEntero(int entero, int posicion) {
		int[] nuevo=new int[arregloEnteros.length+1];
		if(posicion<0) {
			for (int i = 0; i < arregloEnteros.length; i++) {
				nuevo[i+1]=arregloEnteros[i];
			}
			nuevo[0]=entero;
			arregloEnteros=nuevo;
			
			
		}
		else if(posicion>arregloEnteros.length){
			agregarEntero(entero);
			
		}
		else {
		for (int i = 0; i < posicion; i++) {//tengo el arreglo hast la posicion falta copiar los demas
			nuevo[i]=arregloEnteros[i];
		}
		nuevo[posicion]=entero;
		for (int i = posicion; i < arregloEnteros.length; i++) {
			nuevo[i+1]=arregloEnteros[i];
		}
		arregloEnteros=nuevo;
		
		}
		
		
	}	
	

	/**
	 * Elimina un valor del arreglo de enteros dada su posición.
	 * 
	 * @param posicion La posición donde está el elemento que debe ser eliminado. Si
	 *                 el parámetro posicion no corresponde a ninguna posición del
	 *                 arreglo de enteros, el método no debe hacer nada.
	 */
	public void eliminarEnteroPorPosicion(int posicion) {
		
		if(posicion>=arregloEnteros.length ||posicion<0) {
			
		}
		else {
			int[] eliminado=new int[arregloEnteros.length-1];
			for (int i = 0; i < posicion; i++) {//arreglo hasta el valor a eliminar
				eliminado[i]=arregloEnteros[i];
				}
			for (int i = posicion+1; i < arregloEnteros.length; i++) {
				eliminado[i-1]=arregloEnteros[i];
			}
			arregloEnteros=eliminado;
		}
	}

	/**
	 * Reinicia el arreglo de enteros con los valores contenidos en el arreglo del
	 * parámetro 'valores' truncados.
	 * 
	 * Es decir que si el valor fuera 3.67, en el nuevo arreglo de enteros debería
	 * quedar el entero 3.
	 * 
	 * @param valores Un arreglo de valores decimales.
	 */
	public void reiniciarArregloEnteros(double[] valores) {
		int[] nuevo=new int[valores.length];
		for (int i = 0; i < valores.length; i++) {
			nuevo[i]=(int)Math.floor(valores[i]);
		}
		arregloEnteros=nuevo;
	}

	/**
	 * Reinicia el arreglo de cadenas con las representaciones como Strings de los
	 * objetos contenidos en el arreglo del parámetro 'objetos'.
	 * 
	 * Use el método toString para convertir los objetos a cadenas.
	 * 
	 * @param valores Un arreglo de objetos
	 */
	public void reiniciarArregloCadenas(Object[] objetos) {
		String[]nuevo=new String[objetos.length];
		for (int i = 0; i < objetos.length; i++) {
			nuevo[i]=objetos[i].toString();
		}
		arregloCadenas=nuevo;
	}

	/**
	 * Modifica el arreglo de enteros para que todos los valores sean positivos.
	 * 
	 * Es decir que si en una posición había un valor negativo, después de ejecutar
	 * el método debe quedar el mismo valor muliplicado por -1.
	 */
	public void volverPositivos() {
		int[]positivo= new int[arregloEnteros.length];
		for (int i = 0; i < arregloEnteros.length; i++) {
			if(arregloEnteros[i]<0) {
				positivo[i]=arregloEnteros[i]*-1;
				
			}
			else {
			positivo[i]=arregloEnteros[i];
		}
		}	
		arregloEnteros=positivo;		
	}

	/**
	 * Modifica el arreglo de enteros para que todos los valores queden organizados
	 * de menor a mayor.
	 */
	public void organizarEnteros() {
	    for (int i = 0; i < arregloEnteros.length - 1; i++) {
	        for (int j = 0; j < arregloEnteros.length - 1 - i; j++) {
	            if (arregloEnteros[j] > arregloEnteros[j + 1]) {
	                int temp = arregloEnteros[j];
	                arregloEnteros[j] = arregloEnteros[j + 1];
	                arregloEnteros[j + 1] = temp;
	            }
	        }
	    }
	}

	/**
	 * Modifica el arreglo de cadenas para que todos los valores queden organizados
	 * lexicográficamente.
	 */
	public void organizarCadenas() {
	    for (int i = 0; i < arregloCadenas.length - 1; i++) {
	        for (int j = 0; j < arregloCadenas.length - 1 - i; j++) {	            
	            if (arregloCadenas[j].compareTo(arregloCadenas[j + 1]) > 0) {
	                String temp = arregloCadenas[j];
	                arregloCadenas[j] = arregloCadenas[j + 1];
	                arregloCadenas[j + 1] = temp;
	            }
	        }
	    }
	}

	/**
	 * Cuenta cuántas veces aparece el valor recibido por parámetro en el arreglo de
	 * enteros
	 * 
	 * @param valor El valor buscado
	 * @return La cantidad de veces que aparece el valor
	 */
	public int contarApariciones(int valor) {
		int contador=0;
		for (int i = 0; i < arregloEnteros.length; i++) {
			if(arregloEnteros[i]==valor) {
				contador++;
			}
		}
		return contador;
	}

	/**
	 * Cuenta cuántas veces aparece la cadena recibida por parámetro en el arreglo
	 * de cadenas.
	 * 
	 * La búsqueda no debe diferenciar entre mayúsculas y minúsculas.
	 * 
	 * @param cadena La cadena buscada
	 * @return La cantidad de veces que aparece la cadena
	 */
	public int contarApariciones(String cadena) {
		int contador=0;
		for (int i = 0; i < arregloCadenas.length; i++) {
			if(arregloCadenas[i].equalsIgnoreCase(cadena)) {
				contador++;
			}
		}
		return contador;
	}
		

	/**
	 * Busca en qué posiciones del arreglo de enteros se encuentra el valor que se
	 * recibe en el parámetro
	 * 
	 * @param valor El valor que se debe buscar
	 * @return Un arreglo con los números de las posiciones del arreglo de enteros
	 *         en las que se encuentra el valor buscado. Si el valor no se
	 *         encuentra, el arreglo retornado es de tamaño 0.
	 */
	public int[] buscarEntero(int valor) {
		int contador=0;
		for (int i = 0; i < arregloEnteros.length; i++) {
			if (arregloEnteros[i]==valor) {
				contador++;
			}
		}
		int[] posiciones=new int[contador];
		int j=0;
		for (int i = 0; i < arregloEnteros.length; i++) {
			if (arregloEnteros[i]==valor) {
				posiciones[j]=i;
				j++;
			}
		}
		
		
		return posiciones;
	}

	/**
	 * Calcula cuál es el rango de los enteros (el valor mínimo y el máximo).
	 * 
	 * @return Un arreglo con dos posiciones: en la primera posición, debe estar el
	 *         valor mínimo en el arreglo de enteros; en la segunda posición, debe
	 *         estar el valor máximo en el arreglo de enteros. Si el arreglo está
	 *         vacío, debe retornar un arreglo vacío.
	 */
	public int[] calcularRangoEnteros() {
		if (arregloEnteros == null || arregloEnteros.length == 0) {
			return new int[0];
		}
		Arrays.sort(arregloEnteros);
		int[] minmax = new int[2];
		minmax[0] = arregloEnteros[0];
		minmax[1] = arregloEnteros[arregloEnteros.length - 1];

		return minmax;
	}

	/**
	 * Calcula un histograma de los valores del arreglo de enteros y lo devuelve
	 * como un mapa donde las llaves son los valores del arreglo y los valores son
	 * la cantidad de veces que aparece cada uno en el arreglo de enteros.
	 * 
	 * @return Un mapa con el histograma de valores.
	 */
	public HashMap<Integer, Integer> calcularHistograma() {
	    HashMap<Integer, Integer> histograma = new HashMap<>();

	    for (int num : arregloEnteros) {
	        if (histograma.containsKey(num)) {
	            histograma.put(num, histograma.get(num) + 1);
	        } else {
	            histograma.put(num, 1);
	        }
	    }

	    return histograma;
	}
	   
	

	/**
	 * Cuenta cuántos valores dentro del arreglo de enteros están repetidos.
	 * 
	 * @return La cantidad de enteos diferentes que aparecen más de una vez
	 */
	public int contarEnterosRepetidos() {
		HashMap<Integer, Integer> frecuencia = new HashMap<>();
		int contador = 0;

		for (int num : arregloEnteros) {
			frecuencia.put(num, frecuencia.getOrDefault(num, 0) + 1);
		}

		for (int valor : frecuencia.values()) {
			if (valor > 1) {
				contador++;
			}
		}

		return contador;
	}

	/**
	 * Compara el arreglo de enteros con otro arreglo de enteros y verifica si son
	 * iguales, es decir que contienen los mismos elementos exactamente en el mismo
	 * orden.
	 * 
	 * @param otroArreglo El arreglo de enteros con el que se debe comparar
	 * @return True si los arreglos son idénticos y false de lo contrario
	 */
	public boolean compararArregloEnteros(int[] otroArreglo) {
		if (this.arregloEnteros.length != otroArreglo.length) {
			return false;
		}

		for (int i = 0; i < this.arregloEnteros.length; i++) {
			if (this.arregloEnteros[i] != otroArreglo[i]) {
				return false;
			}
		}

		return true;
	}

	/**
	 * Compara el arreglo de enteros con otro arreglo de enteros y verifica que
	 * tengan los mismos elementos, aunque podría ser en otro orden.
	 * 
	 * @param otroArreglo El arreglo de enteros con el que se debe comparar
	 * @return True si los elementos en los dos arreglos son los mismos
	 */
	public boolean mismosEnteros(int[] otroArreglo) {
		if (this.arregloEnteros.length != otroArreglo.length) {
			return false;
		}

		HashMap<Integer, Integer> freqMap1 = new HashMap<>();
		HashMap<Integer, Integer> freqMap2 = new HashMap<>();

		for (int num : this.arregloEnteros) {
			freqMap1.put(num, freqMap1.getOrDefault(num, 0) + 1);
		}

		for (int num : otroArreglo) {
			freqMap2.put(num, freqMap2.getOrDefault(num, 0) + 1);
		}

		return freqMap1.equals(freqMap2);
	}

	/**
	 * Cambia los elementos del arreglo de enteros por una nueva serie de valores
	 * generada de forma aleatoria.
	 * 
	 * Para generar los valores se debe partir de una distribución uniforme usando
	 * Math.random().
	 * 
	 * Los números en el arreglo deben quedar entre el valor mínimo y el máximo.
	 * 
	 * @param cantidad La cantidad de elementos que debe haber en el arreglo
	 * @param minimo   El valor mínimo para los números generados
	 * @param maximo   El valor máximo para los números generados
	 */
	public void generarEnteros(int cantidad, int minimo, int maximo) {
		this.arregloEnteros = new int[cantidad];

		for (int i = 0; i < cantidad; i++) {
			this.arregloEnteros[i] = (int) (Math.random() * (maximo - minimo + 1)) + minimo;
		}
	}

}
