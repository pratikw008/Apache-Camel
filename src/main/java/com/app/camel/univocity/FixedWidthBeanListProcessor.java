package com.app.camel.univocity;

import java.io.File;
import java.util.List;

import com.app.camel.bean.Vehicle;
import com.univocity.parsers.common.processor.BeanListProcessor;
import com.univocity.parsers.fixed.FixedWidthFields;
import com.univocity.parsers.fixed.FixedWidthParser;
import com.univocity.parsers.fixed.FixedWidthParserSettings;

public class FixedWidthBeanListProcessor {

	public static void main(String[] args) {
		
		BeanListProcessor<Vehicle> beanListProcessor = new BeanListProcessor<>(Vehicle.class);
		
		FixedWidthFields fixedWidthFields = new FixedWidthFields(4, 5, 40, 40, 8);
		
		FixedWidthParserSettings parserSettings = new FixedWidthParserSettings(fixedWidthFields);
		
		parserSettings.getFormat().setPadding('_');
		//parserSettings.getFormat().setLineSeparator("\n");
		parserSettings.setProcessor(beanListProcessor);
		parserSettings.setHeaderExtractionEnabled(true);
		
		FixedWidthParser parser = new FixedWidthParser(parserSettings);
		
		parser.parse(new File("C:\\Users\\MARK-32\\Desktop\\fixed-width.txt"));
		
		List<Vehicle> beans = beanListProcessor.getBeans();
		
		System.out.println(beans);
	}

}
