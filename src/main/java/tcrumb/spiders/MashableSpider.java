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

public class MashableSpider {
    public Set<NewsObject> parseHtml() throws Exception {
        Set<NewsObject> news = new HashSet<NewsObject>();
        news.addAll(parseStartupNewsPages());
        news.addAll(parseMobileNewsPages());

        return news;
    }

    private Set<NewsObject> parseStartupNewsPages() throws Exception {
        final String mashableStartupBaseUrl = "http://mashable.com/startups/";
        final Set<NewsObject> startupNews = new HashSet<NewsObject>();

        Document htmlDocument = Jsoup.connect(mashableStartupBaseUrl).get();
        Elements linksOnPage = htmlDocument.select("a[href]");
        for (Element link : linksOnPage) {
            String redirectUrl = link.attr("href");
            String title = link.html();

            if (!StringUtil.isBlank(redirectUrl) && redirectUrl.startsWith("http://mashable.com/") && !StringUtil.isBlank(title)) {
                startupNews.add(new NewsObject(redirectUrl, title, NewsSource.MASHABLE));
            }
        }

        return startupNews;
    }

    private Set<NewsObject> parseMobileNewsPages() throws Exception {
        final String mashableStartupBaseUrl = "http://mashable.com/mobile/";
        final Set<NewsObject> startupNews = new HashSet<NewsObject>();

        Document htmlDocument = Jsoup.connect(mashableStartupBaseUrl).get();
        Elements linksOnPage = htmlDocument.select("a[href]");
        for (Element link : linksOnPage) {
            String redirectUrl = link.attr("href");
            String title = link.html();

            if (!StringUtil.isBlank(redirectUrl) && redirectUrl.startsWith("http://mashable.com/") && !StringUtil.isBlank(title)) {
                startupNews.add(new NewsObject(redirectUrl, title, NewsSource.MASHABLE));
            }
        }

        return startupNews;
    }
}
