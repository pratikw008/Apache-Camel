package com.app.univocity;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.univocity.parsers.common.record.Record;
import com.univocity.parsers.fixed.FixedWidthFields;
import com.univocity.parsers.fixed.FixedWidthParser;
import com.univocity.parsers.fixed.FixedWidthParserSettings;

public class FixedWidth {

	public static void main(String[] args) throws IOException {
		
		File file = new File("C:\\Users\\MARK-32\\Desktop\\dummy_fixed_width.txt");
		
		FixedWidthFields fixedWidthFields = new FixedWidthFields(4,5,40,40,8);
		
		FixedWidthParserSettings settings = new FixedWidthParserSettings(fixedWidthFields);
		
		settings.getFormat().setPadding('_');
		//settings.getFormat().setLineSeparator("\n");
		
		FixedWidthParser parser = new FixedWidthParser(settings);
		
		List<Record> records = parser.parseAllRecords(file);
		records.stream().forEach(System.out::println);
	}

}
