package tcrumb.model;

import lombok.Data;

import java.util.List;

@Data
public class NewsCache {
    private static NewsCache instance;
    private volatile List<NewsObject> newsCache;

    private NewsCache() {
    }

    public static NewsCache getInstance() {
        if (instance == null)
            instance = new NewsCache();

        return instance;
    }
}
