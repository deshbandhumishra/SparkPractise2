
import java.io.FileNotFoundException
import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem, Path}

trait MyConfig {
  //Hadoop File creation

  val myconf = new Configuration()
  myconf.set("fs.defaultFS", "hdfs://172.17.0.2:8020")
  val hadoop:FileSystem = FileSystem.get(myconf)

  val stagingpath = new Path("/user/root/deshbandhu1504/SparkPractise2")
  if (hadoop.exists(stagingpath)) hadoop.delete(stagingpath, true)
  hadoop.mkdirs(stagingpath)

  try {
    hadoop.copyFromLocalFile(new Path("/home/deshbandhu/dummy_files/words.txt"), new Path("/user/root/deshbandhu1504/SparkPractise2/words.txt"))

  }
  catch{
    case e : FileNotFoundException =>print("File not found=="+e)

  }

}

