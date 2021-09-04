package com.asapp.backend.challenge.model.message;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Entity
@JsonDeserialize(as = TextContent.class)
@DiscriminatorValue("text_type")
class TextContent extends Content {

	@JsonProperty(value = "type")
	private String type;
	private String text;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "TextContent [id=" + getId() + ", type=" + type + ", text=" + text + "]";
	}

}