package com.erickogi14gmail.lawyer.chat;

import java.io.Serializable;

/**
 * Created by kimani kogi on 7/26/2017.
 */

public class ChatPojo implements Serializable {
    private int message_id;
    private int fromid;
    private String message_text;

    public ChatPojo(int message_id, int fromid, String message_text) {
        this.message_id = message_id;
        this.fromid = fromid;
        this.message_text = message_text;
    }

    public int getMessage_id() {
        return message_id;
    }

    public void setMessage_id(int message_id) {
        this.message_id = message_id;
    }

    public int getFromid() {
        return fromid;
    }

    public void setFromid(int fromid) {
        this.fromid = fromid;
    }

    public String getMessage_text() {
        return message_text;
    }

    public void setMessage_text(String message_text) {
        this.message_text = message_text;
    }
}
