plugins {
    id("org.springframework.boot") version "3.2.2"
    id("io.spring.dependency-management") version "1.1.4"
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // ✅ Spring Boot Web for MVC
    implementation("org.springframework.boot:spring-boot-starter-web")

    // ✅ Thymeleaf for Views
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")

    // ✅ Validation for @Valid and BindingResult
    implementation("org.springframework.boot:spring-boot-starter-validation")

    // ✅ Spring Boot Test Dependencies
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    // ✅ JUnit 5 for Unit Testing
    testImplementation("org.junit.jupiter:junit-jupiter")

    // ✅ MockMvc for Web Controller Tests
    testImplementation("org.springframework.boot:spring-boot-starter-webflux")
}

tasks.test {
    useJUnitPlatform()
}
