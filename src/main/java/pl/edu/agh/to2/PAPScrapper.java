package pl.edu.agh.to2;

import java.util.List;

public class PAPScrapper extends Scrapper {

    public PAPScrapper(){

    }

    //kapala
    public List<String> getUrls(String html){
        return null;
    }


    //konieczny
    public boolean checkIfArticle(String html) {
        return true;
    }


    //wuju
    public Article readArticle(String html) {
        return null;
    }
}
