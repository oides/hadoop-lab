package br.edu.ifba.gsort.inf628.brazilianusers;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import br.edu.ifba.gsort.inf628.util.MRUtil;

public class Map extends Mapper<Object, Text, Text, Text> {

	public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
		
		java.util.Map<String, String> lineParsed = MRUtil.transformXmlToMap(value.toString());
		String location = lineParsed.get("Location");
		
		if (location != null && (location.contains("rasil") || location.contains("razil"))) {
			context.write(new Text(lineParsed.get("Id")), new Text(lineParsed.get("DisplayName") + " - " + location));
		}
		
	}
}