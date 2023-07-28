plugins {
    id("java")
}

group = "com.lukegjpotter"
version = "0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    // Cucumber Libraries.
    testImplementation(platform("io.cucumber:cucumber-bom:7.13.0"))
    testImplementation("io.cucumber:cucumber-java:7.13.0")
    testImplementation("io.cucumber:cucumber-junit:7.13.0")
    testImplementation("io.cucumber:cucumber-junit-platform-engine:7.13.0")
    testImplementation("org.junit.platform:junit-platform-suite")

    // Selenium Libraries.
    testImplementation("org.seleniumhq.selenium:selenium-java:4.10.0")
    testImplementation("io.github.bonigarcia:webdrivermanager:5.4.1")
}

tasks.test {
    useJUnitPlatform()

    // Work around. Gradle does not include enough information to disambiguate between different examples and scenarios.
    systemProperty("cucumber.junit-platform.naming-strategy", "long")
}