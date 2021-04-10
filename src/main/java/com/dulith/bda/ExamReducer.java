package com.dulith.bda;

import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.io.IntWritable;
//import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import java.io.IOException;

public class ExamReducer extends Reducer<Text,IntWritable,Text,Text> {
    public void reduce(Text key, Iterable<IntWritable> values,Context context)
       throws IOException,InterruptedException {
            long sum = 0;

            for(IntWritable x: values)
            {
                sum += x.get();
            }
            context.write(key, new Text(sum + ""));
       }
}