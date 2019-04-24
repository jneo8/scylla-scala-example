import sbt._

object Dependencies {
  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.0.5"
  lazy val sparkCore = "org.apache.spark" %% "spark-core" % "2.4.0" % "provided"
  lazy val sparkSQL = "org.apache.spark" %% "spark-sql" % "2.4.0" % "provided"
  lazy val sparkCatalyst = "org.apache.spark" %% "spark-catalyst" % "2.4.0" % "provided"
  lazy val sparkDatastax = "com.datastax.spark" %% "spark-cassandra-connector" % "2.4.0"
}
