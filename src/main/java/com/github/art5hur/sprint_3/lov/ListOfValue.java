package com.github.art5hur.sprint_3.lov;

public class ListOfValue {
    private Object value;
    private String text;
    
	public ListOfValue(Object value, String text) {		
		this.value = value;
		this.text = text;
	}
	
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
    
    
}
