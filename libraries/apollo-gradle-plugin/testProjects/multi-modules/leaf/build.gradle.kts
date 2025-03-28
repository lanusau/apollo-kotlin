plugins {
  id("org.jetbrains.kotlin.jvm")
  alias(libs.plugins.apollo)
  id("application")
}

dependencies {
  implementation(kotlin("stdlib"))
  implementation(libs.apollo.api)
  testImplementation(libs.kotlin.test.junit)

  implementation(project(":root"))
}

application {
  mainClass.set("LeafKt")
}

apollo {
  service("service") {
    packageNamesFromFilePaths()
    alwaysGenerateTypesMatching.set(emptyList())
    generateApolloMetadata.set(true)
  }
}

dependencies {
  add("apolloService", project(":root"))
}