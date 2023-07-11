package com.newlecture.app.entity;

import java.sql.Date;

public class Notice {

    private int id;
    private String title;
    private String Content;
    private String writerId;
    private Date regDate;
    private int hit;
    private String files;
    public Notice() {
    }

    public Notice(int id, String title, String content, String writerId, Date regDate, int hit, String files) {
        this.id = id;
        this.title = title;
        Content = content;
        this.writerId = writerId;
        this.regDate = regDate;
        this.hit = hit;
        this.files = files;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getWriterId() {
        return writerId;
    }

    public void setWriterId(String writerId) {
        this.writerId = writerId;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public String getFiles() {
        return files;
    }

    public void setFiles(String files) {
        this.files = files;
    }

}