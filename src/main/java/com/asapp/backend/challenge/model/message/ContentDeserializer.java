package com.asapp.backend.challenge.model.message;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

class ContentDeserializer extends JsonDeserializer<Content> {

	@Override
	public Content deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
		ObjectMapper mapper = (ObjectMapper) p.getCodec();
		ObjectNode root = mapper.readTree(p);
		if (root.has("type")) {
			String fieldValue = root.get("type").asText();
			if (fieldValue.equals("video")) {
				return mapper.readValue(root.toString(), VideoContent.class);
			}
			if (fieldValue.equals("image")) {
				return mapper.readValue(root.toString(), ImageContent.class);
			}
			if (fieldValue.equals("text")) {
				return mapper.readValue(root.toString(), TextContent.class);
			}
		}
		throw new RuntimeException("Invalid content type");
	}
}