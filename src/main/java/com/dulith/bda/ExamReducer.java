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
            int count = 0;
            String output;

            for(IntWritable x: values)
            {
                sum += x.get();
                count++;
            }
            long average = sum/count;
            if (average > 80) {
                output = "First-CLASS";
            } else if (average > 70) {
                output = "Second-CLASS";
            } else {
                output = "General-PASS";
            }
            context.write(new Text(output), key);
       }
}