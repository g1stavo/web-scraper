package scraper;

import java.io.IOException;
import static java.lang.System.out;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * Class that acts as the Scraper, with functions to
 * print a webpage title, subtitle, published date 
 * and content.
 * 
 * @author g1stavo
 */
public class Scraper {
    private Document doc;
    
    /**
    * @param url (required) URL of the webpage to be scraped.
    */
    public Scraper(String url) throws IOException {
        this.doc = Jsoup.connect(url).get();
    }
    
    /**
    * Prints webpage title.
    */
    public void getTitle() {
        String title = "Título: " + doc.select("h1").text();
        out.println(title);
    }
    
    /**
    * Prints webpage subtitle.
    */
    public void getSubtitle() {
        String subtitle = "Subtítulo: " + doc.select("i > span").first().text();
        out.println(subtitle);
    }
    
    /**
    * Prints webpage published date in the dd-MM-yyyy format.
    */
    public void getPublishedDate() throws ParseException {
        String rawDate = doc.select("meta[property=article:published_time]").attr("content");
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date parsedDate = formatter.parse(rawDate);
        
        formatter = new SimpleDateFormat("dd/MM/yyyy");        
        String formattedDate = formatter.format(parsedDate);
        
        out.println("Data de publicação: " + formattedDate);
    }
    
    /**
    * Prints webpage clean content.
    */
    public void getContent() {
        doc.select("i > span").remove();
        doc.select(":matchesOwn(LEIA TAMBÉM:)").remove();
        String content = doc.select(".post-content").text();
        out.println("Conteúdo: " + content);
    }
}
