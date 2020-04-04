package com.garage48.covid19.projecturban.util;

import java.io.IOException;
import java.util.Map;

import javax.persistence.AttributeConverter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MaptoJsonString implements AttributeConverter<Map<String, Object>, String> {

	private static final Log logger = LogFactory.getLog(MaptoJsonString.class);
	
	@Autowired
	ObjectMapper mapper;
	
	@Override
	public String convertToDatabaseColumn(Map<String, Object> map) {
		String jsonStr = null;
		try {
			jsonStr = mapper.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			logger.error("Exception occurred while converting itemsMap to json before inserting into DB {}",e);
		}
		return jsonStr;
	}

	@Override
	public Map<String, Object> convertToEntityAttribute(String dbValue) {
		 Map<String, Object> customerOderInfo = null;
	        try {
	        	customerOderInfo = mapper.readValue(dbValue, new TypeReference<Map<String, Object>>() {});
	        } catch (final IOException e) {
	            logger.error("JSON reading error", e);
	        }
	 
	        return customerOderInfo;
	}

}
