package ejemploA;
import java.util.*;
import javax.swing.JOptionPane;
public class main {

	public static void main(String[] args) {
		int a = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el primer numero de la secuencia"));
		int b = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el segundo numero de la secuencia"));
		int l = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el largo de la secuencia"));
		ArrayList<Integer> Fib =Fibonacci.CrearFibonacci(a,b,l);
		for(Integer K : Fib)
		{
			System.out.println(K);
		}

	}

}
