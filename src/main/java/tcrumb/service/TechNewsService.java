package tcrumb.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tcrumb.model.NewsCache;
import tcrumb.model.NewsObject;
import tcrumb.spiders.MashableSpider;
import tcrumb.spiders.TechCrunchSpider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class TechNewsService {
    public List<NewsObject> getAllTechNews() {
        List<NewsObject> news = NewsCache.getInstance().getNewsCache();
        Collections.shuffle(news);

        return news;
    }

    @Scheduled(fixedRate = 600000)
    public void crawlAndSave() {
        List<NewsObject> news = new ArrayList<NewsObject>();

        try {
            TechCrunchSpider techCrunchSpider = new TechCrunchSpider();
            MashableSpider mashableSpider = new MashableSpider();

            news.addAll(techCrunchSpider.parseHtml());
            news.addAll(mashableSpider.parseHtml());

            NewsCache.getInstance().setNewsCache(news);
        } catch (Exception e) {
            return;
        }
    }
}
