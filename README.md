# Hadoop MapReduce

## Steps

1) Create EMR Cluster and ssh to master node  

2) install git
> `sudo yum install git-core`

3) Clone this repository
> `git clone https://github.com/dulith-muthu/hadoop-findaverage.git`

4) [optional] run `mvn clean install` - jar file included in this repo

5) copy inputs files to HDFS 
> `hdfs dfs -put input ./`

6) Run MapReduce command.
> `hadoop jar target/findaverage-1.0-SNAPSHOT.jar /user/hadoop/input /user/hadoop/output`  



