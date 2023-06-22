package com.uep.wap.model;

import javax.persistence.*;

@Entity
@Table(name="articles")

public class Article {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private long id;

    @Column(name ="title")
    private String title;

    @Column(name ="content")
private String content;

    @Column(name = "shortDescription")
    private String shortDescription;

    @Column(name = "date_of_creation")
    private String date_of_creation;


    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public Article() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }


    public String getDate() {
        return date_of_creation;
    }

    public void setDate(String date) {
        this.date_of_creation = date;
    }

    public Integer getNumberOfViews() {
        return numberOfViews;
    }

    public void setNumberOfViews(Integer numberOfViews) {
        this.numberOfViews = numberOfViews;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "numberOfViews")
    private Integer numberOfViews;

    //to bedzie klucz po relacji z User
    @Column(name = "author")
    private String author;

    @OneToOne(mappedBy = "article", cascade = CascadeType.ALL)
    private DailyFact dailyFact;

    @OneToOne(mappedBy = "article", cascade = CascadeType.ALL)
    private HistoryOfChanges historyOfChanges;

}



