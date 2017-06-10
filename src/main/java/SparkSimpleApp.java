import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class SparkSimpleApp {
    public static void main(String[] args) {
        String readmeFile = "/usr/local/spark-2.0.0-bin-hadoop2.7/README.md";
        SparkConf conf = new SparkConf().setAppName("Simple Spark App");
        JavaSparkContext sparkContext = new JavaSparkContext(conf);
        JavaRDD<String> readmeRDD = sparkContext.textFile(readmeFile).cache();

        long numberOfAs = countOfCharInFile(readmeRDD, "a");
        long numberOfBs = countOfCharInFile(readmeRDD, "b");

        System.out.println(String.format("Lines with a:%d | Lines with b:%d", numberOfAs, numberOfBs));

        sparkContext.stop();
    }

    private static long countOfCharInFile(JavaRDD<String> readmeRDD, String characterToSerach) {
        return readmeRDD.filter(line -> line.contains(characterToSerach)).count();
    }
}
