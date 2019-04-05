package com.caztc.domain;

import java.util.Date;

/**
 * @author narata
 * @since 2019/03/31
 */
public class Notice {
    private int id;

    private String title;
    private String data;
    private Date createTime;
    private int isDeleted;
    private String formatTime;

    public String getFormatTime() {
        return formatTime;
    }

    public void setFormatTime(String formatTime) {
        this.formatTime = formatTime;
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getIsdeleted() {
        return isDeleted;
    }

    public void setIsdeleted(int isdeleted) {
        this.isDeleted = isdeleted;
    }
}
