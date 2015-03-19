package br.edu.ifba.gsort.inf628.usersjoin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class Reduce extends Reducer<Text, Text, Text, Text> {
	
	private List<Text> listaA = new ArrayList<Text>();
	private List<Text> listaB = new ArrayList<Text>();

	public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
		
		listaA.clear();
		listaB.clear();
		
		for (Text text : values) {
		
			if (text.charAt(0) == 'A') {
				listaA.add(new Text(text.toString().substring(1)));
			}
			if (text.charAt(0) == 'B') {
				listaB.add(new Text(text.toString().substring(1)));
			}
		}
		
		executeJoin(context);
		
	}

	/*
	 * Implementação de inner join.
	 */
	private void executeJoin(Context context) throws IOException, InterruptedException {
		
		if (!listaA.isEmpty() && !listaB.isEmpty()) {
			
			for (Text textA : listaA) {
				for (Text textB : listaB) {
					context.write(textA, textB);
				}				
			}
			
		}
		
	}

}