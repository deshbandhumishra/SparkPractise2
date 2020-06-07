
import org.apache.spark._

object Main extends App with MyConfig{

  val conf:SparkConf = new SparkConf().setAppName("wordCount").setMaster("local[*]")//"192.168.43.126:4040")  //192.168.43.126:4040
  val sc = new SparkContext(conf)

  val input = sc.textFile("hdfs://172.17.0.2:8020//user/root/deshbandhu1504/SparkPractise2/words.txt")

    //conf.read.format("txt").option("header","false").textFile("/home/deshbandhu/dummy_files/words.txt")
    //val outputFile = "/home/deshbandhu/dummy_files/output/"


    // Split up into words.
    val words = input.flatMap(line => line.split(" "))
    // Transform into word and count. Note concise "underscore" notation for lambda
    val counts = words.map(word => (word, 1)).reduceByKey( _+ _)
    // Save the word count back out to a text file, causing evaluation.
    counts.saveAsTextFile("hdfs://172.17.0.2:8020//user/root/deshbandhu1504/SparkPractise2/out/")

}