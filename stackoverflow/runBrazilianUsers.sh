mvn clean package
rm -rf /home/eudes/desenvolvimento/hadoop/workspace/hadoop-lab/files/output/stackoverflow/brazilianUsers
/home/eudes/desenvolvimento/hadoop/hadoop-2.6.0/bin/hadoop jar /home/eudes/desenvolvimento/hadoop/workspace/hadoop-lab/stackoverflow/target/stackoverflow-0.0.1-SNAPSHOT.jar br.edu.ifba.gsort.inf628.brazilianusers.Main /home/eudes/desenvolvimento/hadoop/workspace/hadoop-lab/files/input/stackoverflow/stackoverflow.com-Users-reduced /home/eudes/desenvolvimento/hadoop/workspace/hadoop-lab/files/output/stackoverflow/brazilianUsers
