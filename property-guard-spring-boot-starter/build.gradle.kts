import java.net.URI

val sGroupId: String by project
val sVersion: String by project
val projectUrl: String by project
val projectGithubUrl: String by project
val licenseName: String by project
val licenseUrl: String by project

val springBootVersion: String by project

group = sGroupId
version = sVersion

dependencies {
    implementation(project(":devkit-utils"))
    implementation("org.springframework.boot:spring-boot-autoconfigure:$springBootVersion")
    implementation("org.springframework.boot:spring-boot-starter-logging:$springBootVersion")
    implementation("org.springframework.boot:spring-boot-configuration-processor:$springBootVersion")
    testImplementation("org.springframework.boot:spring-boot-starter-test:$springBootVersion")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
    withSourcesJar()
    withJavadocJar()
}

tasks.test {
    useJUnitPlatform()
}

publishing {
    publications {
        create<MavenPublication>("propertyGuardSpringBootStarter") {
            groupId = sGroupId
            artifactId = "property-guard-spring-boot-starter"
            version = sVersion

            pom {
                name = "Property Guard Spring Boot Starter"
                description = "This module is made for protecting your secret properties in your spring application properties."
                url = projectUrl

                licenses {
                    license {
                        name = licenseName
                        url = licenseUrl
                    }
                }
                
                scm {
                    connection = "scm:git:git://github.com:CodeCraftersCN/JDevKit.git"
                    developerConnection = "scm:git:git://github.com:CodeCraftersCN/JDevKit.git"
                    url = projectGithubUrl
                }

                developers {
                    developer {
                        id = "zihluwang"
                        name = "Zihlu Wang"
                        email = "really@zihlu.wang"
                        timezone = "Asia/Hong_Kong"
                    }
                }
            }

            from(components["java"])

            signing {
                sign(publishing.publications["propertyGuardSpringBootStarter"])
            }
        }

        repositories {
            maven {
                name = "sonatypeNexus"
                url = URI(providers.gradleProperty("repo.maven-central.host").get())
                credentials {
                    username = providers.gradleProperty("repo.maven-central.username").get()
                    password = providers.gradleProperty("repo.maven-central.password").get()
                }
            }

            maven {
                name = "codingNexus"
                url = URI(providers.gradleProperty("repo.coding.host").get())
                credentials {
                    username = providers.gradleProperty("repo.coding.username").get()
                    password = providers.gradleProperty("repo.coding.password").get()
                }
            }

            maven {
                name = "githubPackages"
                url = URI(providers.gradleProperty("repo.github.host").get())
                credentials {
                    username = providers.gradleProperty("repo.github.username").get()
                    password = providers.gradleProperty("repo.github.password").get()
                }
            }
        }
    }
}