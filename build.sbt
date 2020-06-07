name := "SparkPractise2"
version := "0.1"

scalaVersion := "2.12.3"

// https://mvnrepository.com/artifact/org.apache.spark/spark-core
libraryDependencies += "org.apache.spark" %% "spark-core" % "2.4.4"
libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.4.4"
libraryDependencies += "org.apache.spark" %% "spark-streaming" % "2.4.4"

// Cloudera artifacts are published in their own remote repository
resolvers += "Cloudera" at "http://repository.cloudera.com/artifactory/cloudera-repos/"
