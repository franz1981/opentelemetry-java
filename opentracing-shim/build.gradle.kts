plugins {
    id("otel.java-conventions")
    `maven-publish`
}

description = "OpenTelemetry OpenTracing Bridge"
otelJava.moduleName.set("io.opentelemetry.opentracingshim")

dependencies {
    api(project(":api:all"))

    api("io.opentracing:opentracing-api")
    implementation(project(":semconv"))

    testImplementation(project(":sdk:testing"))

    testImplementation("org.slf4j:slf4j-simple")
}

tasks {
    withType(Test::class) {
        testLogging {
            showStandardStreams = true
        }
    }
}
