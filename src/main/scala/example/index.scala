package example

import org.apache.spark.sql.SparkSession


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
