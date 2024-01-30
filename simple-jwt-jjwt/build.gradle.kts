import java.net.URI

val globalGroupId: String by rootProject.extra
val globalVersion: String by rootProject.extra
val projectUrl: String by rootProject.extra
val projectGithubUrl: String by rootProject.extra
val licenseName: String by rootProject.extra
val licenseUrl: String by rootProject.extra

val jacksonVersion: String by project
val javaJwtVersion: String by project
val jjwtVersion: String by project
val okhttpVersion: String by project
val springVersion: String by project
val springBootVersion: String by project

group = globalGroupId
version = globalVersion

dependencies {
    implementation(project(":devkit-utils"))
    implementation(project(":guid"))
    implementation("com.fasterxml.jackson.core:jackson-databind:$jacksonVersion")
    implementation("io.jsonwebtoken:jjwt-api:$jjwtVersion")
    implementation("io.jsonwebtoken:jjwt-impl:$jjwtVersion")
    implementation("io.jsonwebtoken:jjwt-jackson:$jjwtVersion")
    implementation(project(":simple-jwt-facade"))
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
        create<MavenPublication>("simpleJwtJjwt") {
            groupId = globalGroupId
            artifactId = "simple-jwt-jjwt"
            version = globalVersion

            pom {
                name = "Simple JWT :: JJWT"
                description = "Simple JWT implemented by io.jsonwebtoken:jjwt library."
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
                sign(publishing.publications["simpleJwtJjwt"])
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