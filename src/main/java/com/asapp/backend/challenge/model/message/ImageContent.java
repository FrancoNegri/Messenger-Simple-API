package com.asapp.backend.challenge.model.message;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Entity
@JsonDeserialize(as = ImageContent.class)
@DiscriminatorValue("image_type")
class ImageContent extends Content {


	@JsonProperty(value = "type")
	private String type;
	private String url;
	private Integer height;
	private Integer width;

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

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	@Override
	public String toString() {
		return "ImageContent [id=" + getId() + ", type=" + type + ", url=" + url + ", height=" + height + ", width=" + width + "]";
	}


}