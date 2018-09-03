package knewinchallenge;

import java.io.IOException;
import java.text.ParseException;

/**
 * Knewin programming challenge main class.
 * Only functionality is to run the 
 * Scraper class.
 * 
 * @author Gustavo de Castro Salvador
 */
public class KnewinChallenge {

    /**
    * Print webpage title, subtitle, published date 
    * and content.
    */
    public static void main(String[] args) throws IOException, ParseException {
        Scraper scraper = new Scraper("http://scinova.com.br/inseed-amplia-participacao-em-sc-com-investimento-de-r-3-milhoes-na-startup-knewin/");
        scraper.getTitle();
        scraper.getSubtitle();
        scraper.getPublishedDate();
        scraper.getContent();
    }
    
}
