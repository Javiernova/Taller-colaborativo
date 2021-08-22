package co.edu.uptc.runner;

import javax.swing.JOptionPane;

import co.edu.uptc.logic.Management;

public class Runner {
	
	public static void menu() {
		String sentence="";
		
		Management mg = new Management();
		int menu=0;
		do {
			
			try {
				
				
			menu = Integer.parseInt(JOptionPane.showInputDialog("1. Convertir en nombre propio el contenido de la cadena\n"
							+ "2.Buscar palabra\n3.Encriptar(método estático)\n4.Desencriptar (método estático)\n5.Llenar cacarter\n6.Borrar cracteres\n"
							+ "7.Intersección\n8.Diferencia\n9.Borrar caracteres iziquierda o derecha\n10.Convertir a fecha\n11.Salir"));
			switch (menu) {
			case 1:
				
				break;
			case 2:
					
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
				
				break;
			case 6:
			
			
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
