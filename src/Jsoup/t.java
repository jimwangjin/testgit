package Jsoup;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class t {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*String html = "<html><head><title>First parse</title></head>"
				  + "<body><p>Parsed HTML into a doc.</p></body></html>";
		Document doc = Jsoup.parse(html);*/

		Document doc = Jsoup.connect("http://dabingguoji.com/").get();
		String title = doc.title();
		System.out.println(title);
	}
	
	public void getElementById() throws IOException{
		File input = new File("/tmp/input.html");
		Document doc = Jsoup.parse(input, "UTF-8", "http://dabingguoji.com/");

		Element content = doc.getElementById("content");
		Elements links = content.getElementsByTag("a");
		for (Element link : links) {
		  String linkHref = link.attr("href");
		  String linkText = link.text();
		}
	}
	public void getElement() throws IOException{
		File input = new File("/tmp/input.html");
		Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");

		Elements links = doc.select("a[href]"); // a with href
		Elements pngs = doc.select("img[src$=.png]");
		  // img with src ending .png

		Element masthead = doc.select("div.masthead").first();
		  // div with class=masthead

		Elements resultLinks = doc.select("h3.r > a"); // direct a after h3
	}

}
