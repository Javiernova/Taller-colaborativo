package co.edu.uptc.logic;

public class Management {
	/*
        + Cadena a usar inmutable
        */
	private static String CHAR_STRING;

	/*
     + @param constructor de la clase
     */
	public Management(String CHAR_STRING) {
		this.CHAR_STRING = CHAR_STRING;
	}

	/*
     + Método que consiste en convertir una frase es un nombre propio.
     + @return cadena como un nombre propio
     */
	public String own_Name(){
		String phrase = "";
		char first_letter = ' ';
		char characters = ' ';
		int aux = 0;

		for (int i = 0; i < CHAR_STRING.length(); i++) {
			first_letter = CHAR_STRING.charAt(0);
			characters = CHAR_STRING.charAt(i);
			if (first_letter == ' '){
				phrase = "No se puede iniciar con un espacio el nombre propio";
			}else if(!Character.isLetter(first_letter)){
				phrase = "No se puede iniciar con un caracter \n"
						+ "diferente al alfabeto" + first_letter;
			}
			if (i == 0){
				characters = Character.toUpperCase(characters);
			}
			if (i >= 1){
				characters = Character.toLowerCase(characters);
			}
			if (characters == ' '){
				aux = (i+1);
			}
			if (aux == i){
				characters = Character.toUpperCase(characters);
			}

			phrase += characters;
		}
		return phrase;
	}

	/*
     + Método que busca una palabra dada y la cantidad de veces que esta repite.
     + @return cantidad de veces encontrada la palabra en la cadena - aux
     */
	public int findCharacterString(String word){
		int aux = 0;
		String[] chars = CHAR_STRING.split("\\W+");
		for (int i = 0; i < chars.length; i++) {
			if (chars[i].equalsIgnoreCase(word)){
				aux = aux+1;
			}
		}
		return aux;
	}
	
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


    /*
    + Método para agregar un caracter segun la cantidad ed veces dada.
    + Ya sea por izquierda o por derecha
    + @param character
    + @param quantify
    + @param address
    + @return auxCharString
     */

	public String fill_Characters(char character, int quantify, String address){
		String modified_String = "";
		String auxCharString = CHAR_STRING;
		for (int i = 0; i < quantify; i++) {
			if (address.equals("Derecha")){
				modified_String = auxCharString + character;
			}else{
				modified_String = character + auxCharString;
			}
			auxCharString = modified_String;
		}
		return auxCharString;
	}

    /*
    + Metodo que elimina el caracter otorgado en el runner, en toda la cadena
    + @param del_char
    + @return result
     */

	public String delete_Characters(char del_char){
		String character = String.valueOf(del_char);
		String result = CHAR_STRING.replace(character,"");
		return result;
	}

	/**
	 * metodo que muestra la cadena ingresada sin caracteres repetidos
	 * @param sentence 
	 * @return string sin caracteres repetidos del parametro ingresado.
	 */

	public String intersection(String sentence) {
		 
		String duplicate = "";
		for (int i = 0; i < sentence.length(); i++) {
			String ct = Character.toString(sentence.charAt(i));
			if (CHAR_STRING.contains(ct)) {
				if (!duplicate.contains(ct)) {
					duplicate += ct;
				}
			}
		}
		return duplicate;
	}
}
