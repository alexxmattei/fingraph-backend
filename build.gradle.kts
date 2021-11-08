val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project

plugins {
    application
    kotlin("jvm") version "1.5.31"
    kotlin("plugin.serialization") version "1.5.31"
    id("org.flywaydb.flyway") version "5.2.4"
}

group = "com.example"
version = "0.0.1"
application {
    mainClass.set("com.example.ApplicationKt")
}

repositories {
    mavenCentral()
}

val mariadb_version = "2.7.4"
val kotlin_serialization_version = "1.5.31"
val kotlinx_serialization_json_version = "1.3.0"
val exposed_version = "0.17.14"

dependencies {
    implementation("io.ktor:ktor-server-core:$ktor_version")
    implementation("io.ktor:ktor-gson:$ktor_version")
    implementation("io.ktor:ktor-server-sessions:$ktor_version")
    implementation("io.ktor:ktor-auth:$ktor_version")
    implementation("io.ktor:ktor-locations:$ktor_version")
    implementation("io.ktor:ktor-client-core:$ktor_version")
    implementation("io.ktor:ktor-client-core-jvm:$ktor_version")
    implementation("io.ktor:ktor-client-apache:$ktor_version")
    implementation("io.ktor:ktor-auth-jwt:$ktor_version")
    implementation("io.ktor:ktor-server-netty:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    implementation("org.mariadb.jdbc:mariadb-java-client:$mariadb_version")
    implementation("org.jetbrains.kotlin:kotlin-serialization:$kotlin_serialization_version")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$kotlinx_serialization_json_version")
    implementation("org.jetbrains.exposed:exposed:$exposed_version")
    implementation("mysql:mysql-connector-java:5.1.48")
    implementation("com.zaxxer:HikariCP:3.4.2")
    testImplementation("io.ktor:ktor-server-tests:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test:$kotlin_version")
}