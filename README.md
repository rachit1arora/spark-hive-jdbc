## Reading and writing Spark Dataframe via jdbc with Apache Hive

#### Introduction
Apache Hive is very popular data warehouse software. It is widely used for reading, writing, and managing large datasets residing in distributed storage which could be HDFS or S3 bucket using SQL. Structure can be projected onto data already in storage.

Typically you will have multiple use cases where the will need to connect to Apache Hive from Spark service running in IBM Cloud Pak for Data. There are multiple and very efficient ways to connect to Apache hive from Apache Spark.

Although connecting with Apache Hive via jdbc is not very efficient way and should only be used in scenario where we want to get a small snapshot of result set in Spark as the computation to run the Select query will be run in Hive and we should fetch only a very small data set in Spark and in most of the case writing back data from Spark dataframe to Apache Hive via jdbc is not recommended and even fails with most of the available Hive jdbc drivers specifically for the reason that Spark will use addBatch API to write back but most of the hive jdbc drivers have not implemented this method and they can see the error like Method Not Supported but if some users who have very tight requirement that they only want to use jdbc and no other means to write back a spark data frame to Apache hive table they can use following to achieve the same. 

Before proceeding to use code from this repository, a caution statement that this implementation is not efficient and also not recommended and to be used in scnarios where other ways to access Apache Hive is not an option for your use case and need to access Apache hive via jdbc only.

This Blog Story explain the changes in detail  https://medium.com/ibm-data-ai/reading-and-writing-spark-dataframe-via-jdbc-with-apache-hive-178fd01e0218

#### Building the code

#### Using JDBC Dialect for reading Hive table in Spark via jdbc

#### Using Scala functions to create Hive table and save Spark data frame in Hive table via jdbc

#### Using write Data Source to save the Spark data frame in Hive table
