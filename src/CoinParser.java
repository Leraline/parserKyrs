
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

class CoinParser {

    private static final String URL_ADRESS = "https://coinmarketcap.com/";

    public static void main(String[] args) {
        getCoinWeeklyGraphic(getPage());
    }

    public static Document getPage() {
        Document page = null;
        try {
            page = Jsoup.connect(URL_ADRESS).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return page;
    }

    public static Elements getCoinLinkImages(Document page) {
        return page.select("div.h7vnx2-1.bFzXgl").select("img[class=coin-logo]");
    }

    public static Elements getCoinWeeklyGraphic(Document page) {
        return page.select("div.h7vnx2-1.bFzXgl").select("img[class=h7vnx2-0 bCltOL]");
    }

    public static Elements getCoinName(Document page) {
        return page.select("div.h7vnx2-1.bFzXgl").select("p[class=sc-1eb5slv-0 iworPT]");
    }

    public static Elements getCoinPrice(Document page) {
        return page.select("div.h7vnx2-1.bFzXgl").select("div[class=sc-131di3y-0 cLgOOr]").select("span");
    }

}


