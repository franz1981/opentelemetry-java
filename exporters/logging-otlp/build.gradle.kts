plugins {
    id("otel.java-conventions")
    `maven-publish`

    id("ru.vyarus.animalsniffer")
}

description = "OpenTelemetry Protocol JSON Logging Exporters"
otelJava.moduleName.set("io.opentelemetry.exporter.logging.otlp")

dependencies {
    compileOnly(project(":sdk:trace"))
    compileOnly(project(":sdk:metrics"))

    implementation(project(":exporters:otlp:common"))

    implementation("org.curioswitch.curiostack:protobuf-jackson")

    testImplementation(project(":sdk:testing"))

    testImplementation("org.skyscreamer:jsonassert")
}
