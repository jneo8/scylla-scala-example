import Dependencies._

ThisBuild / scalaVersion              := "2.11.12"
ThisBuild / version                   := "0.1.0-SNAPSHOT"
ThisBuild / organization              := "com.example"
ThisBuild / organizationName          := "example"

lazy val root = (project in file("."))
  .settings(
    name := "scylla-scala",
    libraryDependencies += scalaTest % Test,
    libraryDependencies += sparkCore,
    libraryDependencies += sparkSQL,
    libraryDependencies += sparkCatalyst,
    libraryDependencies += sparkDatastax
  )


// assembly settings
assemblyJarName in assembly := name.value + ".jar"

// Skip test during assembly
test in assembly := {}

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", _@_*) => MergeStrategy.discard
  case _ => MergeStrategy.first
}

// Uncomment the following for publishing to Sonatype.
// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for more detail.

// ThisBuild / description := "Some descripiton about your project."
// ThisBuild / licenses    := List("Apache 2" -> new URL("http://www.apache.org/licenses/LICENSE-2.0.txt"))
// ThisBuild / homepage    := Some(url("https://github.com/example/project"))
// ThisBuild / scmInfo := Some(
//   ScmInfo(
//     url("https://github.com/your-account/your-project"),
//     "scm:git@github.com:your-account/your-project.git"
//   )
// )
// ThisBuild / developers := List(
//   Developer(
//     id    = "Your identifier",
//     name  = "Your Name",
//     email = "your@email",
//     url   = url("http://your.url")
//   )
// )
// ThisBuild / pomIncludeRepository := { _ => false }
// ThisBuild / publishTo := {
//   val nexus = "https://oss.sonatype.org/"
//   if (isSnapshot.value) Some("snapshots" at nexus + "content/repositories/snapshots")
//   else Some("releases" at nexus + "service/local/staging/deploy/maven2")
// }
// ThisBuild / publishMavenStyle := true

