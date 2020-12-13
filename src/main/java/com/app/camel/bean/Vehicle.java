package com.app.camel.bean;

import java.util.Set;

import com.app.camel.univocity.WordsToSetConversion;
import com.univocity.parsers.annotations.Convert;
import com.univocity.parsers.annotations.FixedWidth;
import com.univocity.parsers.annotations.Parsed;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Headers(sequence = {"Year","Make","Model","Description","Price"})
public class Vehicle {

	@Parsed(field = "Year")
	@FixedWidth(value = 4)
	private Integer year;

	@Parsed(field = "Make")
	@FixedWidth(value = 5)
	private String make;

	@Parsed(field = "Model")
	@FixedWidth(value = 40)
	private String model;

	@Convert(conversionClass = WordsToSetConversion.class, args = { ",", "true" })
	@Parsed
	@FixedWidth(value = 40)
	private Set<String> description;

	@Parsed(field = "Price")
	@FixedWidth(value = 8)
	private Double price;
}
