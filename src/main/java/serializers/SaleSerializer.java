package serializers;

import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import models.Sale;

public class SaleSerializer implements Serializer<Sale>{

	public SaleSerializer() {
		// TODO Auto-generated constructor stub
	}
	
	// Sale -> JSON -> byte array
	public byte[] serialize(String topic, Sale data) {
		// TODO Auto-generated method stub
		try {
			return new ObjectMapper().writeValueAsBytes(data);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
