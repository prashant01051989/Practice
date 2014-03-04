package com.test.hibernate.persis;

public class Message {
private Long id;
private String text;
private Message nextMessage;
public Message() {
	super();
}
public Message(String text) {
	super();
	this.text = text;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getText() {
	return text;
}
public void setText(String text) {
	this.text = text;
}
public Message getNextMessage() {
	return nextMessage;
}
public void setNextMessage(Message nextMessage) {
	this.nextMessage = nextMessage;
}

}