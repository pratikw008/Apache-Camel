package com.app.camel.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class FileRoutes extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("file:D:\\files\\Camel-Test\\FileRoutes\\Source")
		.to("file:D:\\files\\Camel-Test\\FileRoutes\\Destination");
	}

}
