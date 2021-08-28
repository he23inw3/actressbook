import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.5.1"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	id("io.gitlab.arturbosch.detekt").version("1.17.1")
	id("org.sonarqube").version("3.3")
	kotlin("jvm") version "1.5.10"
	kotlin("plugin.spring") version "1.5.10"
	jacoco
}

group = "jp.hiro72"
version = "1.0.0"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

dependencies {
	implementation("nz.net.ultraq.thymeleaf:thymeleaf-layout-dialect")
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
	implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.2.0")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	runtimeOnly("org.postgresql:postgresql")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("io.projectreactor:reactor-test")
}

buildscript {
	repositories {
		gradlePluginPortal()
	}
	dependencies {
		classpath("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.17.1")
	}
}

jacoco {
	toolVersion = "0.8.5"
}

detekt {
	toolVersion = "1.17.1"
	input = files("src/main/kotlin")
	parallel = false
	config = files("config/detekt/detekt.yml")
	buildUponDefaultConfig = false
	baseline = file("config/detekt/baseline.xml")
	allRules = false
	debug = false
	ignoreFailures = false


	reports {
		html {
			enabled = true
			destination = file("build/reports/detekt.html")
		}
	}
}

sonarqube {
	properties {
		property("sonar.projectKey", "he23inw3_actressbook")
		property("sonar.organization", "he23inw3")
		property("sonar.host.url", "https://sonarcloud.io")
	}
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<io.gitlab.arturbosch.detekt.Detekt>().configureEach {
	this.jvmTarget = "11"
}

tasks.jacocoTestReport {
	dependsOn(tasks.test)
}
