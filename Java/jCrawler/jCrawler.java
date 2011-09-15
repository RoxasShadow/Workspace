import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.net.*;
import java.security.*;
import java.math.*;

public class jCrawler {
	private String url;
	
	private void setUrl(String url) {
		this.url = url;
	}
	
	public jCrawler(String url) {
		setUrl(url);
	}
	
	private String md5(String text) throws NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance("MD5");
		digest.update(text.getBytes(), 0, text.length());
		return new BigInteger(1, digest.digest()).toString(16);
	}
	
	private boolean fileExists(String filename) {
		return ((new File(filename)).exists()) ? true : false;
	}
	
	private boolean savePage(String filename, String text) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("pages/"+filename));
			writer.write(text);
			writer.close();
			return (fileExists("pages/"+filename)) ? true : false;
		}
		catch(MalformedURLException e) {
			System.out.println("URL is not valid.");
		}
		catch(IOException e) {
			System.out.println("Error while saving.");
		}
		return false;
	}
	
	public void crawlPage() {
		String[] urls = new String[20]; // ArrayList are not thread-safe, and I have some problems to add elements while a iteration :(
		urls[0] = url; // For now only an URL, after I'll use urls[] with the urls contents in this
		Pattern pattern = Pattern.compile("\\bhref=\"[^>]*\">\\b");
		Matcher matcher;
		BufferedReader reader;
		URL urlHandler;
		String line;
		StringBuffer buffer;
		int last;
		try {
			for(int i=0; i<urls.length; ++i) {
				urlHandler = new URL(urls[i]);
				System.out.println(urls[i]+":");
				System.out.println("\tDownloading...");
				/* Reading the page. */
				reader = new BufferedReader(new InputStreamReader(urlHandler.openStream()));
				buffer = new StringBuffer("");
				while((line = reader.readLine()) != null)
					buffer.append(line);
				reader.close();
				/* Saving and parsing the page and collecting their urls. */
				if(savePage(md5(urls[i])+".php", buffer.toString())) {
					System.out.println("\tDownloaded. Parsing...");
					matcher = pattern.matcher(buffer.toString());
					/* Obtains the last element (it's null). */
					last = 0;
					for(int j=0; j<urls.length; ++j)
						if(urls[j] == null) {
							last = j;
							break;
						}
					/* Foreach url founded in the page... */
					while(matcher.find())
						/* Appends in the array the founded urls. */
						for(int j=last; j<urls.length; ++j)
							for(int k=0; k<urls.length; ++k)
								urls[j] = matcher.group().replace("href=\"", "").replace("\">", "");
					System.out.println("\tFollowing another URL...");
				}
				else
					System.out.println("\tSaving failed.");
			}
		}
		catch(NoSuchAlgorithmException e) {
			System.out.println("Error while coding in MD5.");
		}
		catch(MalformedURLException e) {
			System.out.println("Encountered errors following the URL ");
		}
		catch(IOException e) {
			System.out.println("Error while saving.");
		}
	}		
	
	public static void main(String[] args) {
		new jCrawler((args.length > 0) ? args[0] : "http://localhost/").crawlPage();
	}
}
