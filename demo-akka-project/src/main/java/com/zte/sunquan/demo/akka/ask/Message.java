package com.zte.sunquan.demo.akka.ask;

/**
 * Created by 10184538 on 2018/6/2.
 */
public class Message implements java.io.Serializable {

    private Long id;
    private String msg;

    public Message() {
    }

    public Message(Long id, String msg) {
        this.id = id;
        this.msg = msg;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Message{");
        sb.append("id=").append(id);
        sb.append(", msg='").append(msg).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
