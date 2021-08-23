package co.edu.uptc.runner;

import javax.swing.JOptionPane;

import co.edu.uptc.logic.Management;

public class Runner {
	
	public static void menu() {
		String sentence="";
		boolean aux = true;
		while(aux == true){
			sentence = JOptionPane.showInputDialog("Ingrese la frase con la que desea utilizar el programa");
			if (sentence == null){
				JOptionPane.showMessageDialog(null, "Ha ocurrido un error, por lo tanto se cerrara la aplicacion", "ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
				System.exit(0);
			}
			if (sentence.equals("")){
				JOptionPane.showMessageDialog(null, "Asegurese de haber ingresado una frase o cadena de texto", "ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
			}else{
				aux = false;
			}
		}
		Management mg = new Management(sentence);
		int menu = 0;
		do {
			try {
				menu = Integer.parseInt(JOptionPane.showInputDialog("1. Convertir en nombre propio el contenido de la cadena \n"
						+ "2. Buscar palabra \n 3. Encriptar(método estático) \n 4. Desencriptar (método estático) \n 5. Llenar caracteres \n6. Borrar caracteres \n"
						+ "7. Intersección \n 8. Diferencia \n 9. Borrar caracteres iziquierda o derecha \n 10. Validar dirección de correo electronico \n 11. Salir"));
				switch (menu) {
					case 1:
						JOptionPane.showMessageDialog(null, "Sentencia : " + sentence + "\n Sentencia modificada: " + mg.own_Name());
						break;
					case 2:
						boolean auxP2 = false;
						while (auxP2 == false){
							String word = JOptionPane.showInputDialog("Ingrese la palabra que desea buscar en la cadena de texto");
							if (word != null){
								if (word.equals("")){
									JOptionPane.showMessageDialog(null, "Opcion invalida, debe escribir algun texto","ERROR",JOptionPane.ERROR_MESSAGE);
								}else{
									JOptionPane.showMessageDialog(null, word + " Se encuentra: " + mg.findCharacterString(word) + " veces");
									auxP2 = true;
								}
							}else{
								JOptionPane.showMessageDialog(null, "Volviendo al menú", "ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
								auxP2 = true;
							}
						}
						break;
					case 3:
						sentence=JOptionPane.showInputDialog("escriba palabra u oracion a encriptar");
						sentence=mg.encrypt(sentence);
						JOptionPane.showMessageDialog(null, sentence);
						break;
					case 4:
						JOptionPane.showMessageDialog(null, mg.decrypt(sentence));
						break;
					case 5:
						boolean menu2 = false;
						while(menu2 == false){
							try {
								int options2 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese: \n 1. Para llenar caracteres por derecha\n"
										+ "2. Para llenar caracteres por izquerda"));
								String stringOptions2 = String.valueOf(options2);
								if (stringOptions2 != null){
									if (stringOptions2.equals("")){
										JOptionPane.showMessageDialog(null, "Opcion invalida, debe elegir alguna opcion","ERROR",JOptionPane.ERROR_MESSAGE);
									}else {
										switch (options2){
											case 1:
												String address = "Derecha";
												String character = JOptionPane.showInputDialog("Ingrese el caracter que se agregara a la sentencia indicada al inicio");
												char character2 = character.charAt(0);
												int limit = Integer.parseInt(JOptionPane.showInputDialog("Ingrese (en número) de la cantidad de caracteres a añadir"));
												JOptionPane.showMessageDialog(null, mg.fill_Characters(character2, limit,address));
												menu2 = true;
												break;

											case 2:
												String addressLeft = "Izquierda";
												String characterLeft = JOptionPane.showInputDialog("Ingrese el caracter que se agregara a la sentencia indicada al inicio");
												char character2Left = characterLeft.charAt(0);
												int limitLeft = Integer.parseInt(JOptionPane.showInputDialog("Ingrese (en número) de la cantidad de caracteres a añadir"));
												JOptionPane.showMessageDialog(null, mg.fill_Characters(character2Left, limitLeft,addressLeft));
												menu2 = true;
												break;
										}
									}
								}else{
									JOptionPane.showMessageDialog(null, "Volviendo al menú", "ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
									menu2 = true;
								}
							}catch (Exception e){
								JOptionPane.showMessageDialog(null, "Debe ingresar algun dato");
							}
						}
						break;
					case 6:
						boolean continueP6 = true;
						while (continueP6 == true){
							try {
								String del_Char = JOptionPane.showInputDialog("Ingrese el caracter que desea eliminar");
								if (del_Char != null) {
									if (del_Char.equals("")) {
										JOptionPane.showMessageDialog(null, "Opcion invalida, debe escribir algun caracter valido", "ERROR", JOptionPane.ERROR_MESSAGE);
									} else {
										char del_char = del_Char.charAt(0);
										JOptionPane.showMessageDialog(null, mg.delete_Characters(del_char));
										continueP6 = false;
									}
								}else{
									JOptionPane.showMessageDialog(null, "Volviendo al menú", "ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
									continueP6 = false;
								}
							}catch (Exception e){
								JOptionPane.showMessageDialog(null, "Debe ingresar algun dato");
							}
						}
						break;
					case 7:
						sentence=JOptionPane.showInputDialog("escriba palabra a intersectar");
						JOptionPane.showMessageDialog(null, mg.intersection(sentence));
						break;
					case 8:

						break;
					case 9:

						break;
					case 10:

						break;
					case 11:
						JOptionPane.showMessageDialog(null, "Ha salido del programa","ADVERTENCIA",JOptionPane.WARNING_MESSAGE);

						break;
					default: JOptionPane.showMessageDialog(null, "Opcion invalida","ERROR",JOptionPane.ERROR_MESSAGE);
				}
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Error");
			}
		}while(menu!=11);
	}

	public static void main(String[] args) {
		menu();

	}

}
