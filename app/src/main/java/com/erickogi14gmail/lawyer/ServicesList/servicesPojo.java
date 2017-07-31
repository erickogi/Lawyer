package com.erickogi14gmail.lawyer.ServicesList;

import java.io.Serializable;

/**
 * Created by kimani kogi on 7/26/2017.
 */

public class servicesPojo implements Serializable{
    private  int no;
    private int id;
    private String title;

    public servicesPojo() {
    }

    public servicesPojo(int no, String title) {
        this.no = no;
        this.title = title;
    }

    public servicesPojo(int no, int id, String title) {
        this.no = no;
        this.id=id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
