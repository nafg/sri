publishMavenStyle in ThisBuild := true
publishTo in ThisBuild := Some("Bintray" at "https://api.bintray.com/maven/naftoligug/maven/sri")

sys.env.get("BINTRAYKEY").toSeq map { key =>
  credentials in ThisBuild += Credentials(
    "Bintray API Realm",
    "api.bintray.com",
    "naftoligug",
    key
  )
}
