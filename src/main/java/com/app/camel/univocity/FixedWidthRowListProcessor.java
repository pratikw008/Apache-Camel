package com.app.camel.univocity;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.univocity.parsers.common.processor.RowListProcessor;
import com.univocity.parsers.fixed.FixedWidthFields;
import com.univocity.parsers.fixed.FixedWidthParser;
import com.univocity.parsers.fixed.FixedWidthParserSettings;

public class FixedWidthRowListProcessor {

	public static void main(String[] args) {
		
		/**
		 *  A RowListProcessor stores each parsed row in a List.
		 */
		RowListProcessor rowListProcessor = new RowListProcessor();
		
		FixedWidthFields fixedWidthFieldsLength = new FixedWidthFields(4, 5, 40, 40, 8);
		
		FixedWidthParserSettings parserSettings = new FixedWidthParserSettings(fixedWidthFieldsLength);
		
		parserSettings.getFormat().setPadding('_');
		
		/**
		 *  You can configure the parser to automatically detect, 
		 *  what line separator sequence is in the input.
		 */
		parserSettings.setLineSeparatorDetectionEnabled(true);
		
		/**
		 *  set the RowProcessor that will process the values of each parsed row.
		 *  You can create your own or use any pre-defined RowProcessor
		 *  in the 'com.univocity.parsers.common.processor' package
		 */
		parserSettings.setProcessor(rowListProcessor);
		
		/**
		 *  flag to consider the first parsed row as the headers of each column in the file
		 */
		parserSettings.setHeaderExtractionEnabled(true);
		
		/**
		 *  creates a parser instance with the given settings
		 */
		FixedWidthParser parser = new FixedWidthParser(parserSettings);
		
		/**
		 *  the 'parse' method will parse the file and 
		 *  delegate each parsed row to the RowProcessor you defined
		 */
		parser.parse(new File("C:\\Users\\MARK-32\\Desktop\\dummy_fixed_width.txt"));
		
		String[] headers = rowListProcessor.getHeaders();
		
		List<String[]> rows = rowListProcessor.getRows();
		
		System.out.println("Headers");
		Arrays.stream(headers).forEach(System.out::println);
		
		
		System.out.println(rows);
		List<String> collect = rows.stream().flatMap(Arrays::stream).collect(Collectors.toList());
		
		System.out.println(collect);
		
		
	}
}
