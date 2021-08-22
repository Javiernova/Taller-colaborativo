package co.edu.uptc.logic;

public class Management {
	
private static String CHAR_STRING;

	
	/**
	 * Metodo el cual muestra los caracteres encriptados de la cadena de caracteres
	  ingresada por parametro
	 * @param sentenc
	 * @return string
	 */
	public static String encrypt (String sentenc) {

		char array[] = sentenc.toCharArray();
		for (int i = 0; i < array.length; i++) {
			array[i] = (char) (array[i] + (char) 8);
		}
		String encrypted = String.valueOf(array);
		return encrypted;
	}
	
	/**
	 * metodo el cual desencripta cadena del metodo anterior
	 * @param sentenc
	 * @return retorna cadena desncriptada del metodo anterior
	 */
	
	public static String decrypt(String sentenc) {
		char array[] = sentenc.toCharArray();
		for (int i = 0; i < array.length; i++) {
			array[i] = (char) (array[i] - (char) 8);
		}
		String encrypted = String.valueOf(array);
		return encrypted;
	}
	
	/**
	 * metodo que muestra la cadena ingresada sin caracteres repetidos
	 * @param sentence 
	 * @return string sin caracteres repetidos del parametro ingresado.
	 */
	
	public String intersection(String sentence) {
		String duple =sentence; 
		String duplicate = "";
		for (int i = 0; i < sentence.length(); i++) {
			String ct = Character.toString(sentence.charAt(i));
			if (duple.contains(ct)) {
				if (!duplicate.contains(ct)) {
					duplicate += ct;
				}
			}
		}
		return duplicate;
	}
	

}
