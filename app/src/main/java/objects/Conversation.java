package objects;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gabriel on 08/12/2016.
 */
public class Conversation {
    private User user;
    private String data;
    private String time;
    private String titleMessage;
    private String contentMessage;
    List<Ticket> listTicket = new ArrayList<Ticket>();


    public Conversation(User user, String data, String time, String titleMessage) {
        this.user = user;
        this.data = data;
        this.time = time;
        this.titleMessage = titleMessage;
        this.contentMessage = contentMessage;
    }

    public Conversation(User user, String data, String time, String titleMessage, String contentMessage, List<Ticket> listTicket) {
        this.user = user;
        this.data = data;
        this.time = time;
        this.titleMessage = titleMessage;
        this.contentMessage = contentMessage;
        this.listTicket=listTicket;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }

    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }

    public String getTitleMessage() {
        return titleMessage;
    }
    public void setTitleMessage(String message) {
        this.titleMessage = titleMessage;
    }

    public String getContentMessage() {
        return contentMessage;
    }
    public void setContentMessage(String contentMessage) {
        this.contentMessage = contentMessage;
    }

    public List<Ticket> getListTicket() {
        return listTicket;
    }
    public void setListTicket(List<Ticket> listTicket) {
        listTicket = listTicket;
    }
}
