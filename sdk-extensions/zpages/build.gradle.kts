plugins {
    id("otel.java-conventions")
    `maven-publish`

    id("otel.jmh-conventions")
}

description = "OpenTelemetry - zPages"
otelJava.moduleName.set("io.opentelemetry.sdk.extension.zpages")

dependencies {
    implementation(project(":api:all"))
    implementation(project(":sdk:all"))

    testImplementation("com.google.guava:guava")
    
    compileOnly("com.sun.net.httpserver:http")
}
