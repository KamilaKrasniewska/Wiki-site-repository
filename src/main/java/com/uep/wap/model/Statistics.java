package com.uep.wap.model;

import javax.persistence.*;

@Entity
@Table(name="statistics")
public class Statistics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="statistics_id")
    private long statisticsId;

    @ManyToOne
    @JoinColumn(name="complaint_id", nullable=false)
    private Complaint complaint;

    @ManyToOne
    @JoinColumn(name="history_id", nullable=false)
    private HistoryOfChanges historyOfChanges;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @ManyToOne
    @JoinColumn(name="article_id", nullable=false)
    private Article article;

    public Statistics() {
    }

    public long getStatisticsId() {
        return statisticsId;
    }

    public void setStatisticsId(long statisticsId) {
        this.statisticsId = statisticsId;
    }

    public Complaint getComplaint() {
        return complaint;
    }

    public void setComplaint(Complaint complaint) {
        this.complaint = complaint;
    }

    public HistoryOfChanges getHistory() {
        return historyOfChanges;
    }

    public void setHistory(HistoryOfChanges history) {
        this.historyOfChanges = history;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
