/**
	XMLWriter.java
	(C) Giovanni Capuano 2011
*/
import java.io.*;
import java.net.URL;
import java.util.ArrayList;

/* Un tool per convertire un database testuale in tanti XML. */
public class XMLWriter {
	public static void main(String[] args) {
		try {
			ArrayList<String> name = new ArrayList<String>();
			ArrayList<String> ability1 = new ArrayList<String>();
			ArrayList<String> ability2 = new ArrayList<String>();
			ArrayList<String> number = new ArrayList<String>();
			ArrayList<String> hp = new ArrayList<String>();
			ArrayList<String> atk = new ArrayList<String>();
			ArrayList<String> dif = new ArrayList<String>();
			ArrayList<String> atksp = new ArrayList<String>();
			ArrayList<String> difsp = new ArrayList<String>();
			ArrayList<String> spe = new ArrayList<String>();
			File file = new File("pokemon.txt");
			URL url = file.toURI().toURL();
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
			String line;
			String[] split;
			while((line = reader.readLine()) != null) {
				split = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
				name.add(split[0]);
				ability1.add(split[2]);
				ability2.add(split[3]);
				number.add(split[4]);
				hp.add(split[5]);
				atk.add(split[6]);
				dif.add(split[7]);
				atksp.add(split[8]);
				difsp.add(split[9]);
				spe.add(split[10]);
			}
			reader.close();
			BufferedWriter writer = new BufferedWriter(new FileWriter("pokemon.xml"));
			StringBuffer content = new StringBuffer("<dex>\n\n");	
			for(int i=0, count=name.size(); i<count; ++i)
				content.append("<pokemon>\n<name>"+name.get(i)+"</name>\n<ability1>"+ability1.get(i)+"</ability1>\n<ability2>"+ability2.get(i)+"</ability2>\n<number>"+number.get(i)+"</number>\n<hp>"+hp.get(i)+"</hp>\n<atk>"+atk.get(i)+"</atk>\n<def>"+dif.get(i)+"</def>\n<atksp>"+atksp.get(i)+"</atksp>\n<difsp>"+difsp.get(i)+"</difsp>\n<spe>"+spe.get(i)+"</spe>\n</pokemon>\n\n");
			content.append("</dex>");
			writer.write(content.toString());
			writer.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
