# Putting Spark to your applications
Inspired with Venkat's talk in GIDS2017 the repository is built around to 
experience code transformation from:

Imperative -> Declarative -> Declarative Parallel -> Declarative Distributed

# Working with examples

Repository has code using Spark and it's important that if you like to try 
it out then don't sweat it because it has docker configurations that would 
enable you to have a Spark Cluster and Worker node setup on you local using 
Docker.

>Please follow below steps for getting up and running with Spark Cluster

Use `spark.df` for creating a base image with `ubuntu`+`java8`+`spark`
configured. 
```
docker build -f ./spark.df -t spark .
```
Using above base image use `docker-compose` for creating the cluster
```
docker-compose up -d
```
Post which you can access your master on `http://localhost:8080`
![Spark Master](https://s3.ap-south-1.amazonaws.com/github-readme/spark-master.png)

After completing the setup of the spark cluster, please build
the sample application and generate a docker image from it:
```
gradle clean build
docker build -f ./spark-simple-app.df -t spark-simple-app .
```
With `spark-simple-app` docker image we can run our app's 
main file as a spark job.
```
docker run -it -p 8088:8088 -p 8042:8042 -p 4041:4040 spark-simple-app  bash
spark-submit --class SparkSimpleApp --master spark://172.17.0.3:7077 /home/divingspark-1.0.jar
```
Spark master IP needs to be figured out from these commands
```
docker ps
```
Above command would list all the containers that we made active
when our `docker-compose up` triggered from it pick `container-id`
of the container with name `divingspark_spark-master` and trigger
this command over the same
```
docker inspect <conainer-id>
```
The above command would present to you lot's of information
from which you can get the spark master ip from _Networks > IPAddress_
