package com.asapp.backend.challenge.model.message;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Entity
@JsonDeserialize(as = VideoContent.class)
@DiscriminatorValue("video_type")
public class VideoContent extends Content {

	@JsonProperty(value = "type")
	private String type;
	private String url;
	private String source;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Override
	public String toString() {
		return "VideoContent [id=" + getId() + ", type=" + type + ", url=" + url + ", source=" + source + "]";
	}

}
