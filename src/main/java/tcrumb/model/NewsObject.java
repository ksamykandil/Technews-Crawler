package tcrumb.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
public class NewsObject {
    @Id
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    private String id;

    @Column(columnDefinition = "TEXT")
    private String redirectUrl;

    @Column(columnDefinition = "TEXT")
    private String title;

    @Column(columnDefinition = "TEXT")
    private String body;

    @Enumerated(EnumType.STRING)
    private NewsSource newsSource;

    public NewsObject() {
    }

    public NewsObject(String redirectUrl, String title, String body, NewsSource source) {
        this.redirectUrl = redirectUrl;
        this.title = title;
        this.body = body;
        this.newsSource = source;
    }

    public NewsObject(String redirectUrl, String title, NewsSource source) {
        this.redirectUrl = redirectUrl;
        this.title = title;
        this.newsSource = source;
    }
}
