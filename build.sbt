import AssemblyKeys._

name := "Spark-Learn"

version := "1.0"

scalaVersion := "2.10.3"

libraryDependencies ++= Seq(
  "com.hulu.spark" % "spark-core_2.10" % "1.0.0-SNAPSHOT",
  "org.apache.hadoop" % "hadoop-client" % "2.0.0-cdh4.5.0"
)

resolvers ++= Seq(
  "Hulu snapshots" at "http://nexus.prod.hulu.com/content/repositories/snapshots/",
  "Hulu releases" at "http://nexus.prod.hulu.com/content/repositories/releases/",
  "Akka Repository" at "http://repo.akka.io/releases/",
  "Cloudera Artifactory" at "https://repository.cloudera.com/artifactory/cloudera-repos/"
)

assemblySettings

mergeStrategy in assembly <<= (mergeStrategy in assembly) { (old) =>
  {
    case PathList("javax", "servlet", xs@_*) => MergeStrategy.first
    case PathList("META-INF", _*) => MergeStrategy.discard
    case PathList("log4j.properties", "logback.xml") => MergeStrategy.last
    case x => MergeStrategy.first
  }
}

