val ScalaVer = "2.11.7"

val ScalaJSDom = "0.9.1"
val SubScript  = "3.0.5-SNAPSHOT"

scalaVersion in ThisBuild := ScalaVer

val jsPath = file("assets") / "js"

lazy val commonSettings = Seq(
  name    := "JS Hello World"
, version := "0.1.0"
, scalaVersion := ScalaVer
, scalacOptions ++= Seq(
      "-deprecation",
      "-encoding", "UTF-8",
      "-feature",
      "-language:existentials",
      "-language:higherKinds",
      "-language:implicitConversions",
      "-language:experimental.macros",
      "-unchecked",
      // "-Xfatal-warnings",
      "-Xlint",
      // "-Yinline-warnings",
      "-Ywarn-dead-code",
      "-Xfuture")
)

lazy val root = project.in(file(".")).
  aggregate(js, jvm)
  .settings(
    publish := {},
    publishLocal := {}
  )

lazy val jshelloworld = crossProject.in(file("."))
  .settings(commonSettings)
  .settings(SubscriptSbt.projectSettings)
  .settings(
    initialCommands := "import jshelloworld._"
  , libraryDependencies += "org.subscript-lang" %%% "subscript-core" % SubScript
  )
  .jsSettings(
    scalaJSUseMainModuleInitializer := true
  , libraryDependencies ++= Seq(
      "org.scala-js"  %%% "scalajs-dom" % ScalaJSDom
    )
  , artifactPath in (Compile, fastOptJS) := jsPath / "application.js"
  )


lazy val jvm = jshelloworld.jvm
lazy val js  = jshelloworld.js
