mvn clean package
rm -rf /home/eudes/desenvolvimento/hadoop/workspace/hadoop-lab/files/output/word-count
/home/eudes/desenvolvimento/hadoop/hadoop-2.6.0/bin/hadoop jar /home/eudes/desenvolvimento/hadoop/workspace/hadoop-lab/word-count/target/word-count-0.0.1-SNAPSHOT.jar br.edu.ifba.gsort.inf628.main.WordCount /home/eudes/desenvolvimento/hadoop/workspace/hadoop-lab/files/input/word-count/profile /home/eudes/desenvolvimento/hadoop/workspace/hadoop-lab/files/output/word-count
