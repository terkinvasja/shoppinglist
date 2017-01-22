package by.kutsko;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.text.SimpleDateFormat;

@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
public class ShoppinglistApplication {

	/*Jackson*/
	@Bean
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
		MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
		ObjectMapper MAPPER = new ObjectMapper();
		MAPPER.registerModule(new Hibernate5Module());
		MAPPER.registerModule(new JavaTimeModule());
		//MAPPER.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		MAPPER.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
		MAPPER.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
		MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		jsonConverter.setObjectMapper(MAPPER);
		return jsonConverter;
	}

	public static void main(String[] args) {
		SpringApplication.run(ShoppinglistApplication.class, args);
	}
}
