package com.app.camel.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MoveSpecificFileBasedOnTextRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("file:D:\\files\\Camel-Test\\SpecificFileBasedOnText\\Source")
		.filter(bodyAs(String.class).contains("Java"))
		.to("file:D:\\files\\Camel-Test\\SpecificFileBasedOnText\\Destination");
	}

}
