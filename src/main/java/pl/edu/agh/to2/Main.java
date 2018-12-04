package pl.edu.agh.to2;

public class Main {

    public static void main(String[] args) {

        String domain = args[0];

        System.out.println(domain);

        DataBase db = new DataBase();

        Crawler crawler =  new Crawler(domain, db);

        crawler.crawl();

        db.print(domain);

    }
}
