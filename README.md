# Hadoop MapReduce

## Steps

1) Create EMR Cluster and ssh to master node  

2) install git
> `sudo yum install git-core`

3) Clone this repository
> `git clone https://github.com/dulith-muthu/bigdata-analysis-exam.git`  
> `cd bigdata-analysis-exam`

4) [optional] run `mvn clean install` - jar file included in this repo

5) copy inputs files to HDFS 
> `hdfs dfs -put input ./`

6) Run MapReduce command.
> `hadoop jar target/bda-exam-1.0-SNAPSHOT.jar /user/hadoop/input /user/hadoop/output`  

7) Get output files
> `hdfs dfs -get output ./`
> `cat output/part-00000`



