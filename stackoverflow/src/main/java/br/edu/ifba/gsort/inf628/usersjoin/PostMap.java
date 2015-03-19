package br.edu.ifba.gsort.inf628.usersjoin;

import java.io.IOException;
import java.util.Map;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import br.edu.ifba.gsort.inf628.util.MRUtil;


public class PostMap extends Mapper<Object, Text, Text, Text> {

	private Text outKey = new Text();
	private Text outValue = new Text();
	
	public void map(Object key, Text value, Context context) throws IOException, InterruptedException {

		Map<String, String> lineParsed = MRUtil.transformXmlToMap(value.toString());
		
		String id = lineParsed.get("OwnerUserId");
		
		if (id != null) {
			outKey.set(id);
			outValue.set("B" + value.toString());
			
			context.write(outKey, outValue);
		}
		
		
	}
	
}