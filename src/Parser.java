
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;

class Parser {

    public static void main(String[] args) {
        getInfoFromPage(getPage());
    }

private static Document getPage(){
        String url = "https://coinmarketcap.com/";

        Document page = null;
        try {
            page = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return page;
    }

    private static void getInfoFromPage(Document page){
        Crypto[] list = new Crypto[50];
        Elements linkImagesCoins = page.select("div.h7vnx2-1.bFzXgl").select("img[class=coin-logo]"); // ссылки иконок и кратких названий
        Elements namesCoins = page.select("div.h7vnx2-1.bFzXgl").select("div[class=sc-131di3y-0 cLgOOr]").select("span"); // цены между спанами

        for(Element element:linkImagesCoins){
            System.out.println(element);
        }
    }
}


