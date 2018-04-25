import java.io.*;
public class MarcadorPrimerasLetras {
	static public void MarcarPrimerasLetras(String file)
	{
		BufferedReader input;
		BufferedWriter output, bkpoutput; 
		System.out.println(file);
		String bkpfile = file+".bkp";
		String sobre ="";
		try
		{
			// C:\Users\7°Tecnica.Pc02\Desktop\sarasa.txt
			input = new BufferedReader(new FileReader(new File(file)));
			bkpoutput = new BufferedWriter(new FileWriter(new File(bkpfile)));
			char prev = '.';
			while(input.ready())
			{
				char c = (char)input.read();
				bkpoutput.write(c);
				if(prev == '.' && c>='a' && c<='z')
					c-= 'a'-'A';
				sobre+=c;
				//output.write(c);
				prev = c;
			}
			input.close();
			//output.close();
			bkpoutput.close();
			System.out.println(sobre);
			output = new BufferedWriter(new FileWriter(new File(file)));
			output.write(sobre);
			output.close();
		}
		catch(Exception e){
	         e.printStackTrace();
	         return;
	    }
	}
}
