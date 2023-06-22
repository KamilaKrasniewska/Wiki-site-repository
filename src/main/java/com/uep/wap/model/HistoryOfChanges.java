package com.uep.wap.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="history_of_changes")
public class HistoryOfChanges {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="history_id")
    private int history_id;

    @Column(name = "date_of_modification")
    private LocalDate date_of_modification;

    @Column(name = "author")
    private String author;

    @OneToOne
    @JoinColumn(name = "article_id")
    private Article article;

    @OneToMany(mappedBy = "history_of_changes", cascade = CascadeType.ALL)
    private List<Revision> revision;

    public HistoryOfChanges() {
    }

    public int getHistory_id() {
        return history_id;
    }

    public void setHistory_id(int history_id) {
        this.history_id = history_id;
    }

    public LocalDate getDate_of_modification() {
        return date_of_modification;
    }

    public void setDate_of_modification(LocalDate date_of_modification) {
        this.date_of_modification = date_of_modification;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public List<Revision> getRevision() {
        return revision;
    }

    public void setRevision(List<Revision> revision) {
        this.revision = revision;
    }
}
