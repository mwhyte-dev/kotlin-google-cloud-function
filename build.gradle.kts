import java.lang.invoke.MethodHandles.invoker

val invoker by configurations.creating

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.3.72"
    id("com.github.johnrengelman.shadow") version "6.0.0"
    application
}

repositories {
    jcenter()
}

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("io.github.microutils:kotlin-logging:1.11.5")
    implementation("com.google.cloud.functions:functions-framework-api:1.0.1")
    invoker("com.google.cloud.functions.invoker:java-function-invoker:1.0.0-alpha-2-rc5")

    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
    testImplementation("org.mockito:mockito-core:3.5.10")
    testImplementation("com.google.truth:truth:1.0.1")
    testImplementation("com.google.guava:guava-testlib:29.0-jre")
}

application {
    mainClassName = "com.codenerve.function.AppKt"
}

task<JavaExec>("runFunction") {
    main = "com.google.cloud.functions.invoker.runner.Invoker"
    classpath(invoker)
    inputs.files(configurations.runtimeClasspath, sourceSets["main"].output)
    args(
        "--target", project.findProperty("runFunction.target") ?: "com.codenerve.function.App",
        "--port", project.findProperty("runFunction.port") ?: 8080
    )
    doFirst {
        args("--classpath", files(configurations.runtimeClasspath, sourceSets["main"].output).asPath)
    }
}

tasks.named("build") {
    dependsOn(":shadowJar")
}

task("buildFunction") {
    dependsOn("build")
    copy {
        from("build/libs/" + rootProject.name + "-all.jar")
        into("build/deploy")
    }
}
