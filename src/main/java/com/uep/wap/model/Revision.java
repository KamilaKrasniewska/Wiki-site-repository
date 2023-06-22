package com.uep.wap.model;

import javax.persistence.*;

@Entity
@Table(name="revision")
public class Revision {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "revision_id")
    private long revisionId;

    @Column(name = "previous_image")
    private String previousImage;

    @Column(name = "previous_content")
    private String previousContent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "history_id", nullable = false)
    private HistoryOfChanges history_of_changes;

    public Revision() {
    }

    // Getter and setter methods

    public long getRevisionId() {
        return revisionId;
    }

    public void setRevisionId(long revisionId) {
        this.revisionId = revisionId;
    }

    public String getPreviousImage() {
        return previousImage;
    }

    public void setPreviousImage(String previousImage) {
        this.previousImage = previousImage;
    }

    public String getPreviousContent() {
        return previousContent;
    }

    public void setPreviousContent(String previousContent) {
        this.previousContent = previousContent;
    }

    public HistoryOfChanges getHistoryOfChanges() {
        return history_of_changes;
    }

    public void setHistoryOfChanges(HistoryOfChanges history_of_changes) {
        this.history_of_changes = history_of_changes;
    }
}
