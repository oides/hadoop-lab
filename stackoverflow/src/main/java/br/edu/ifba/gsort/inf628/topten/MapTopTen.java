package br.edu.ifba.gsort.inf628.topten;

import java.io.IOException;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class MapTopTen extends Mapper<Object, Text, NullWritable, Text> {

	private TreeMap<Integer, String> repo = new TreeMap<Integer, String>();
	
	public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
		
		String[] values = value.toString().split("\\s+");
		
		repo.put(Integer.parseInt(values[1]), value.toString());
		
		if (repo.size() > 10) {
			repo.remove(repo.firstKey());
		}
		
	}

	@Override
	protected void cleanup(Mapper<Object, Text, NullWritable, Text>.Context context) throws IOException, InterruptedException {

		super.cleanup(context);
	
		for (Entry<Integer, String> entry : repo.entrySet()) {			
			context.write(NullWritable.get(), new Text(entry.getValue()));
		}
		
	}
	
}