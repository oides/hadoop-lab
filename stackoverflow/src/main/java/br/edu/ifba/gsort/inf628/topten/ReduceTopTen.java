package br.edu.ifba.gsort.inf628.topten;

import java.io.IOException;
import java.util.TreeMap;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class ReduceTopTen extends Reducer<NullWritable, Text, NullWritable, Text> {
	
	private TreeMap<Integer, String> repo = new TreeMap<Integer, String>();

	public void reduce(IntWritable key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
		
		for (IntWritable val : values) {
			
			String[] users = val.toString().split("\\s+");
			
			repo.put(Integer.parseInt(users[1]), val.toString());
			
			if (repo.size() > 10) {
				repo.remove(repo.firstKey());
			}

		}

		for (String value : repo.descendingMap().values()) {
			context.write(NullWritable.get(), new Text(value));
		}
		
		
	}

}