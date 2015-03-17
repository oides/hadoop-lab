package br.edu.ifba.gsort.inf628.topten;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import br.edu.ifba.gsort.inf628.util.MRUtil;

public class MapSummarize extends Mapper<Object, Text, Text, IntWritable> {

	private final static IntWritable one = new IntWritable(1);
	
	public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
		
		java.util.Map<String, String> lineParsed = MRUtil.transformXmlToMap(value.toString());
		String user = lineParsed.get("OwnerUserId");
		
		if (user != null) {
			context.write(new Text(user), one);
		}
		
	}
	
}