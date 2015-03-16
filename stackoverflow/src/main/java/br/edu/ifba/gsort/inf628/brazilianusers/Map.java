package br.edu.ifba.gsort.inf628.brazilianusers;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Map extends Mapper<Object, Text, Text, Text> {

	public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
		
		String line = value.toString().toLowerCase();
		
		if (line.contains("brazil") || line.contains("brasil")) {
			context.write(new Text("Nome"), value);
		}
		
	}
}