name := "scalaForTheImpatient"

version := "1.0"

scalaVersion := "2.11.6"

scalacOptions ++= Seq("-deprecation", "-feature")

libraryDependencies ++= Seq(
  "junit" % "junit" % "4.11" % "test",
  "org.scalamock" %% "scalamock-scalatest-support" % "3.2.1" % "test",
  "org.scalamock" %% "scalamock-core" % "3.2.1" % "test",
  "org.scalatest" %% "scalatest" % "2.2.1" % "test",
  "org.scala-sbt" % "io" % "0.13.2",
  "org.expecty" % "expecty" % "0.10"
)

resolvers += "Expecty Repository" at "https://raw.github.com/pniederw/expecty/master/m2repo/"