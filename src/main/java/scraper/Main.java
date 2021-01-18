package scraper;

import java.io.IOException;
import java.text.ParseException;

/**
 * Knewin programming challenge main class.
 * Only functionality is to run the 
 * Scraper class.
 * 
 * @author g1stavo
 */
public class Main {

    /**
    * Prints webpage title, subtitle, published date 
    * and content.
    */
    public static void main(String[] args) throws IOException, ParseException {
        String url = "http://scinova.com.br/inseed-amplia-participacao-em-sc-com-investimento-de-r-3-milhoes-na-startup-knewin/";
        Scraper scraper = new Scraper(url);
        scraper.getTitle();
        scraper.getSubtitle();
        scraper.getPublishedDate();
        scraper.getContent();
    }
}