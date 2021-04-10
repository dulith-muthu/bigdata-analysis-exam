package com.dulith.bda;

import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

import java.util.List;
import java.util.Random;
import java.io.IOException;

public class ExamMapper extends Mapper<Object,Text,Text,IntWritable> {

    public void map(Object key, Text value, Context context) throws IOException,InterruptedException{
        String[] list = value.toString().split(",");

        String country = list[7];

        context.write(new Text(country), new IntWritable(1));
    }
}