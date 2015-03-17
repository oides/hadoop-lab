mvn clean package
rm -rf /home/eudes/desenvolvimento/hadoop/workspace/hadoop-lab/files/output/stackoverflow/summarize
rm -rf /home/eudes/desenvolvimento/hadoop/workspace/hadoop-lab/files/output/stackoverflow/topTen
/home/eudes/desenvolvimento/hadoop/hadoop-2.6.0/bin/hadoop jar /home/eudes/desenvolvimento/hadoop/workspace/hadoop-lab/stackoverflow/target/stackoverflow-0.0.1-SNAPSHOT.jar br.edu.ifba.gsort.inf628.topten.MainSummarize /home/eudes/desenvolvimento/hadoop/workspace/hadoop-lab/files/input/stackoverflow/stackoverflow.com-Posts-reduced-joined /home/eudes/desenvolvimento/hadoop/workspace/hadoop-lab/files/output/stackoverflow/summarize
/home/eudes/desenvolvimento/hadoop/hadoop-2.6.0/bin/hadoop jar /home/eudes/desenvolvimento/hadoop/workspace/hadoop-lab/stackoverflow/target/stackoverflow-0.0.1-SNAPSHOT.jar br.edu.ifba.gsort.inf628.topten.MainTopTen /home/eudes/desenvolvimento/hadoop/workspace/hadoop-lab/files/output/stackoverflow/summarize/part-r-00000 /home/eudes/desenvolvimento/hadoop/workspace/hadoop-lab/files/output/stackoverflow/topTen

