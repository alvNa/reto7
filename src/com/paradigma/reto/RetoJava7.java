package com.paradigma.reto;

import java.util.List;

/**
 * Reto Java7 de Paradigma Tecnológico.
 * @author Álvaro Navarro
 * */
public interface RetoJava7 
{
	/**
	 * @param nombres
	 * 				ruta del fichero que contiene los nombres
	 * @param correos
	 * 				ruta del fichero que contiene las direcciones de correo
	 * @return lista con los correos que deben permanecer en la lista
	 */
	public List<String> filtrarCorreos(String nombres, String correos);
}
