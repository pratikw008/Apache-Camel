package com.app.camel.routes;

import java.util.Arrays;

import org.apache.camel.Message;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ConvertCsvToTextSpaceseparatedRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("file:D:\\files\\Camel-Test\\ConvertCsvToTextSpaceseparatedRoute\\Source")
		.process(exchange -> {
			Message inputData = exchange.getIn();
			
			String body = inputData.getBody(String.class);
			
			StringBuilder builder = new StringBuilder();
			Arrays.stream(body.split(",")).forEach(str -> builder.append(str+ " "));
			
			Message messageOut = exchange.getMessage();
			
			messageOut.setBody(builder);
		})
		.to("file:D:\\files\\Camel-Test\\ConvertCsvToTextSpaceseparatedRoute\\Destination?fileName=us500.txt");
	}

}
