name := "scalaForTheImpatient"

version := "1.0"

scalaVersion := "2.10.2"

scalacOptions ++= Seq("-deprecation", "-feature")

libraryDependencies ++= Seq(
    "junit" % "junit" % "4.11" % "test",
    "org.scalamock" % "scalamock-scalatest-support_2.10" % "3.1.RC1" % "test",
    "org.scalamock" % "scalamock-core_2.10" % "3.1.RC1" % "test",
    "org.scalatest" % "scalatest_2.10" % "2.1.5" % "test",
    "org.scala-sbt" % "io" % "0.13.2",
    "org.expecty" % "expecty" % "0.10"
)

resolvers += "Expecty Repository" at "https://raw.github.com/pniederw/expecty/master/m2repo/"