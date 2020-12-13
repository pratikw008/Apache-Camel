package com.app.camel.univocity;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

import com.univocity.parsers.common.record.Record;
import com.univocity.parsers.fixed.FixedWidthFields;
import com.univocity.parsers.fixed.FixedWidthParser;
import com.univocity.parsers.fixed.FixedWidthParserSettings;

public class FixedWidthToMap {

	public static void main(String[] args) {

		File file = new File("C:\\Users\\MARK-32\\Desktop\\dummy_fixed_width.txt");

		FixedWidthFields fixedWidthFields = new FixedWidthFields(4,5,40,40,8);

		FixedWidthParserSettings settings = new FixedWidthParserSettings(fixedWidthFields);

		settings.getFormat().setPadding('_');

		FixedWidthParser parser = new FixedWidthParser(settings);

		parser.beginParsing(file);
		
		//parser.getRecordMetadata().setDefaultValueOfColumns("0000",1);
		
		LinkedHashMap<String, Object> values = new LinkedHashMap<String, Object>();
		
		Record record;
		while((record = parser.parseNextRecord()) != null) {
			record.fillFieldObjectMap(values, "Year","Make","Model","Description","Price");
			Map<String, String> fieldMap = record.toFieldMap();
			record.fillFieldObjectMap(values);
			System.out.println(fieldMap);
			System.out.println(values);
		}
		parser.stopParsing();
	}
}
