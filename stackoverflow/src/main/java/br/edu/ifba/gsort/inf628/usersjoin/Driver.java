package br.edu.ifba.gsort.inf628.usersjoin;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/*
 * Job responsável por implementar o join dos usuários com seus respectivos posts.
 */
public class Driver {

	public static void main(String[] args) throws Exception {

		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf, "Join");
		job.setJarByClass(Driver.class);

		MultipleInputs.addInputPath(job, new Path(args[0]),	TextInputFormat.class, UserMap.class);
		MultipleInputs.addInputPath(job, new Path(args[1]),	TextInputFormat.class, PostMap.class);

		job.setReducerClass(Reduce.class);

		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);

		FileOutputFormat.setOutputPath(job, new Path(args[2]));
		System.exit(job.waitForCompletion(true) ? 0 : 1);

	}

}