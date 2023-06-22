package com.uep.wap.model;

import javax.persistence.*;

@Entity
@Table(name="daily_fact")
public class DailyFact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="daily_id")
    private int daily_id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "article_id")
    private Article article;

    public DailyFact() {
    }

    public int getDaily_id() {
        return daily_id;
    }

    public void setDaily_id(int daily_id) {
        this.daily_id = daily_id;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
