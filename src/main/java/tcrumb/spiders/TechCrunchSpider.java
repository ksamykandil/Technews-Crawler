package tcrumb.spiders;

import org.jsoup.Jsoup;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import tcrumb.model.NewsObject;
import tcrumb.model.NewsSource;

import java.util.HashSet;
import java.util.Set;

public class TechCrunchSpider {
    public Set<NewsObject> parseHtml() throws Exception {
        Set<NewsObject> news = new HashSet<NewsObject>();
        news.addAll(parseHomeNewsPages());
        news.addAll(parseStartupNewsPages());
        news.addAll(parseMobileNewsPages());

        return news;
    }

    private Set<NewsObject> parseHomeNewsPages() throws Exception {
        final String techCrunchBaseUrl = "https://techcrunch.com/";

        Document htmlDocument = Jsoup.connect(techCrunchBaseUrl).get();
        Elements linksOnPage = htmlDocument.select("ul");

        return getObjectsFromElement(linksOnPage);
    }

    private Set<NewsObject> parseStartupNewsPages() throws Exception {
        final String techCrunchStartupBaseUrl = "https://techcrunch.com/startups/page/";
        final Set<NewsObject> startupNews = new HashSet<NewsObject>();

        for (int i = 1; i <= 4; i++) {
            Document htmlDocument = Jsoup.connect(techCrunchStartupBaseUrl + i + "/").get();
            Elements linksOnPage = htmlDocument.select("ul");

            startupNews.addAll(getObjectsFromElement(linksOnPage));
        }

        return startupNews;
    }

    private Set<NewsObject> parseMobileNewsPages() throws Exception {
        final String techCrunchStartupBaseUrl = "https://techcrunch.com/mobile/page/";
        final Set<NewsObject> mobileNews = new HashSet<NewsObject>();

        for (int i = 1; i <= 4; i++) {
            Document htmlDocument = Jsoup.connect(techCrunchStartupBaseUrl + i + "/").get();
            Elements linksOnPage = htmlDocument.select("ul");

            mobileNews.addAll(getObjectsFromElement(linksOnPage));
        }

        return mobileNews;
    }

    private Set<NewsObject> getObjectsFromElement(Elements elements) {
        final Set<NewsObject> news = new HashSet<NewsObject>();

        for (Element link : elements) {
            if (!link.attr("class").contains("river"))
                continue;

            Elements liLinks = link.select("li");
            for (Element element : liLinks) {
                if (!element.attr("class").contains("river"))
                    continue;

                try {
                    String redirectUrl = element.attr("data-permalink");
                    String title = element.attr("data-sharetitle");
                    String body = element.children().select("p").get(0).getAllElements().get(0).ownText();

                    if (!StringUtil.isBlank(redirectUrl) && !StringUtil.isBlank(body)) {
                        news.add(new NewsObject(redirectUrl, title, body.replace("&nbsp;", " "), NewsSource.TECH_CRUNCH));
                    }
                } catch (Exception e) {

                }
            }
        }

        return news;
    }
}
