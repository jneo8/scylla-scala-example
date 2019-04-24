package example

import org.apache.spark.sql.SparkSession
import com.datastax.spark.connector._

object SparkSessionExample {

  def main(args: Array[String]) {
    val sparkSession = SparkSession.builder
      .appName("scylla-test")
      .getOrCreate()

    val df = sparkSession.read
      .option("header", "false")
      .csv("/fakeData/aggregated_20180923_0500.csv")
    df.show()
  }
}

object ScyllaSparkExample {
  def main(args: Array[String]): Unit = {

    val sparkSession = SparkSession.builder
      .appName("scylla-test")
      .config("spark.cassandra.connection.host", "10.140.0.60,10.140.0.61,10.140.0.62")
      .getOrCreate()

    val persons = sparkSession.sparkContext.cassandraTable("spark_example", "persons")
    val adults = persons.filter(_.getInt("age") >= 18).map(n => Tuple1(n.getString("name")))
    adults.saveToCassandra("spark_example", "adults")

    val out = s"Adults: %d\nTotal: %d\n".format(adults.count(), persons.count())
    print(out)
  }
}
