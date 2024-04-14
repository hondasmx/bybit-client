plugins {
    id("java")
}

group = "com.bybit"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("org.projectlombok:lombok:1.18.32")
    annotationProcessor("org.projectlombok:lombok:1.18.32")

    implementation("org.springframework.boot:spring-boot-starter:3.2.4")
    implementation("io.github.wuhewuhe:bybit-java-api:1.2.5")
}

tasks.test {
    useJUnitPlatform()
}