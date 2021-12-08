package com.example.demo;

// Osztály, amely segítségével objektumként kezelhetjük a post requesttel érkező inputot
public class Greeting {

	  private long id;
	  private String content;

	  public long getId() {
	    return id;
	  }

	  public void setId(long id) {
	    this.id = id;
	  }

	  public String getContent() {
	    return content;
	  }

	  public void setContent(String content) {
	    this.content = content;
	  }
}
