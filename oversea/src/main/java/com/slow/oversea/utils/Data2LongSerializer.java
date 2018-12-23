package com.slow.oversea.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;
import java.util.Date;

/**
 * @author Slicing
 * @date 2018/12/19 12:52
 */
public class Data2LongSerializer extends JsonSerializer<Date> {
	@Override
	public void serialize(Date value, JsonGenerator gen, SerializerProvider serializerProvider)throws IOException{
		gen.writeNumber(value.getTime()/1000);
	}
}
