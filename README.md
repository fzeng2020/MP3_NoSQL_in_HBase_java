# MP3_java


Part I: Platform Setup
   A: Install Docker 
      docker-machine env
      docker-machine start default
      
   B: Download Docker file, run the docker image
      cd Docker_MP3
       docker build -t mp3 .   
        docker run -it mp3 bin/bash
   
   C: Start HBase
      start-hbase.sh
   
Part II: Coding for HBase

   A: Create HBase Tables
      a table named “powers” in HBase with three column families as given below.
      a table named “food” in HBase with two column families
      
   B: List HBase Tables
      insert data in the “powers“ table created in the previous part A with following schema according to input.csv. 
   
   C: Populate HBase Table with Data
      
     
   D: Read Data
   
   E: Scan Data
   
   F: A JOIN SQL query in HBase
      implement a SQL query in Java and run this query
