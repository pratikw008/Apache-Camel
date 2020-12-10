package com.app.camel.routes;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MoveSpecificFileRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		from("file:D:\\files\\Camel-Test\\SpecificFileRoutes\\Source")
		.filter(header(Exchange.FILE_NAME).startsWith("myFile"))
		.to("file:D:\\files\\Camel-Test\\SpecificFileRoutes\\Destination");
	}

}
