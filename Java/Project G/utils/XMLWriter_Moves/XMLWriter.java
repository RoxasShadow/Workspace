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
			ArrayList<String> description = new ArrayList<String>();
			ArrayList<String> effect = new ArrayList<String>();
			ArrayList<String> power = new ArrayList<String>();
			ArrayList<String> type = new ArrayList<String>();
			ArrayList<String> accuracy = new ArrayList<String>();
			ArrayList<String> pp = new ArrayList<String>();
			ArrayList<String> effectaccuracy = new ArrayList<String>();
			ArrayList<String> whoaffect = new ArrayList<String>();
			ArrayList<String> priority = new ArrayList<String>();
			ArrayList<String> physical = new ArrayList<String>();
			ArrayList<String> damagetype = new ArrayList<String>();
			File file = new File("moves.txt");
			URL url = file.toURI().toURL();
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
			String line;
			String[] split;
			while((line = reader.readLine()) != null) {
				split = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
				name.add(split[2].replace("\"", ""));
				description.add(split[3].replace("\"", ""));
				effect.add(split[4]);
				power.add(split[5]);
				type.add(split[6]);
				accuracy.add(split[7]);
				pp.add(split[7]);
				effectaccuracy.add(split[9]);
				whoaffect.add(split[10]);
				priority.add(split[11]);
				physical.add(split[12]);
				damagetype.add(split[12]);
			}
			reader.close();
			BufferedWriter writer = new BufferedWriter(new FileWriter("moves.xml"));
			StringBuffer content = new StringBuffer("<moves>\n\n");		
			for(int i=0, count=name.size(); i<count; ++i)
				content.append("<move>\n<name>"+name.get(i)+"</name>\n<description>"+description.get(i)+"</description>\n<effect>"+effect.get(i)+"</effect>\n<power>"+power.get(i)+"</power>\n<type>"+type.get(i)+"</type>\n<accuracy>"+accuracy.get(i)+"</accuracy>\n<pp>"+pp.get(i)+"</pp>\n<effectaccuracy>"+effectaccuracy.get(i)+"</effectaccuracy>\n<whoaffect>"+whoaffect.get(i)+"</whoaffect>\n<priority>"+priority.get(i)+"</priority>\n<physical>"+physical.get(i)+"</physical>\n<damagetype>"+damagetype.get(i)+"</damagetype>\n</move>\n\n");
			content.append("</moves>");
			writer.write(content.toString());
			writer.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
