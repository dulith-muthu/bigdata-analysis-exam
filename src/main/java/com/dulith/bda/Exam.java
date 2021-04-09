package com.dulith.bda;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.IntWritable;

public class Exam {
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.err.println("Please specify the input and output path");
            System.exit(-1);
        }

        /* delete the output directory before running the job */
        FileUtils.deleteDirectory(new File(args[1]));

        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);
        job.setJarByClass(Exam.class);
        job.setJobName("Exam");
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        job.setMapperClass(ExamMapper.class);
        job.setReducerClass(ExamReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}