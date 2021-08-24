package co.edu.uptc.logic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

/*
 *@author Javier Nova
 *@author Laura Tamayo
 *@author SebastiÃ¡n Matallana
 
*/
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

	/**
     + Metodo que consiste en convertir una frase es un nombre propio.
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

	/**
     + Metodo que busca una palabra dada y la cantidad de veces que esta repite.
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


    /**
    + Metodo para agregar un caracter segun la cantidad ed veces dada.
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

    /**
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
	
	/**
	 * metodo que muestra los caracteres que difieren en las dos cadenas
	 * @param sentence 
	 * @return string 
	 */
	
	public String difference(String sentence) {
		String different = "";
		
		for (int i = 0; i < CHAR_STRING.length(); i++) {
			String diff = Character.toString(CHAR_STRING.charAt(i));
		
				if(!sentence.contains(diff)) {
					different += diff;
					
				}
			
		}
		return different;
	}
	
	/**
	 * metodo que permite borrar a la derecha o la izquierda, los caracteres de la entrada
	 * @param sentence 
	 * @return string
	 */
	
	public String deleterightorfleft(String sentence,String direction) {
	String supr = "";
	String result="";
	boolean num1 = true;	
	if (direction=="right") {
	for (int i = CHAR_STRING.length()-1; i >=0; i--) { 
		supr+=CHAR_STRING.charAt(i);
	}
	for (int i = 0; i < CHAR_STRING.length(); i++) {
		if (sentence.toLowerCase().indexOf(supr.toLowerCase().charAt(i))>=0 && num1) {
		result+="";
		}else {
		num1=false;
		result+=supr.charAt(i);
		}		
	}
	supr="";
	for (int i = result.length()-1; i >=0; i--) {
		supr+=result.charAt(i);
	 }
	}else if(direction =="left") {
			for (int i = 0; i < CHAR_STRING.length(); i++) {
		if (sentence.toLowerCase().indexOf(CHAR_STRING.toLowerCase().charAt(i))>=0 && num1) {
			supr+="";
		}else {
			num1=false;
			supr+=CHAR_STRING.charAt(i);
		}	
	  }
	}
	return CHAR_STRING.length()>0?supr:"";
	}
	
	/**
	 * metodo que permite confirmar correos electrónicos
	 * @param sentence,direction
	 * @return string
	 */
	
	public String validateEmailConfirmation(String sentence) {
		String result = "";
		Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
						+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");


		Matcher mather = pattern.matcher(sentence);

		if (mather.find() == true) {
			result = "El email ingresado es válido.";
		} else {
			result = "El email ingresado es inválido.";
		}return result;
	}
}


