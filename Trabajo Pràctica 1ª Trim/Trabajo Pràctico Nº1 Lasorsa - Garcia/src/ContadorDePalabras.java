import java.io.*;
import java.util.HashMap;
public class ContadorDePalabras{
	public static void ContarPalabras(String file)
	{
		BufferedReader input;
		System.out.println(file);
		try
		{
			// C:\Users\7ªTècnica\Desktop\agenda.txt
			// C:\Users\7°Tecnica.Pc02\Desktop\agenda.txt
			input = new BufferedReader(new FileReader(new File(file)));
		    HashMap<String, Integer> mapa = new HashMap<String,Integer>();
			String palabra ="";
			int top10[] = {0,0,0,0,0,0,0,0,0,0};
			String TOP10[] = new String[10];
			while(input.ready())
			{
				int in = input.read();
				if(in >= (int)'A' && in <= (int)'Z')
				{
					in -= (int)'A' - (int)'a';
				}
				if(EsLetra(in))
				{
					palabra += (char)in;
				}
				else if(!palabra.isEmpty())
				{
					int v = 1;
					if(mapa.containsKey(palabra))
					{ 
						v += mapa.get(palabra);
					}
					mapa.put(palabra, v);
					palabra = "";
                }
			}
			mapa.forEach((K,v) -> mover(top10,v,TOP10,K));
			for(int i = 0;i<10;i++)
			{
				System.out.println("Puesto "+(i+1)+" : "+TOP10[i]+" que aparecio "+top10[i]+" veces" );
			}
			input.close();
		}
		catch(Exception e){
	         e.printStackTrace();
	         return;
	    }
		
	}
	static boolean EsLetra(int c)
	{
		if(c >= (int)'a' && c<=(int)'z')
			return true;
		return false;
	}
	static void mover(int top10[], int v, String TOP10[], String s)
	{
		int i = 0;
		while(i<10)
		{
			if(v>top10[i])
			{
				for(int j = 9;j>i;j--)
				{
					top10[j] = top10[j-1];
					TOP10[j] = TOP10[j-1];
				}
				top10[i] = v;
				TOP10[i] = s;
				return;
			}
			i++;
		}
		return;
	}	
}
