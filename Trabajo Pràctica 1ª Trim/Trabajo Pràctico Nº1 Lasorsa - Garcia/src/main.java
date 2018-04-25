import javax.swing.JOptionPane;
public class main {

	public static void main(String[] args) {
		int op = -1;
		while(op!=0)
		{
			op = Integer.parseInt(JOptionPane.showInputDialog("Ingrese que punto (1, 2 o 3) evaluar. \nIngrese 0 para salir del programa.")); 
			switch(op)
			{
				case 1:
				{
					String file = JOptionPane.showInputDialog("Ingrese la ruta del archivo a contar");
					ContadorDePalabras.ContarPalabras(file);
					break;
				}
				case 2:
				{
					String file = JOptionPane.showInputDialog("Ingrese la ruta del archivo a marcar");
					MarcadorPrimerasLetras.MarcarPrimerasLetras(file);
					break;
				}
				case 3:
				{
					Agenda agenda = new Agenda();
				    agenda.menu();
				    break;
				}
			}
		}
		
	}

}
