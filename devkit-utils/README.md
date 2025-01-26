# Module `devkit-utils`

## Introduction

This module is part of `JDevKit`, an open-source Java Development Kit that provides a set of
convenient tools to streamline code development and enhance productivity. This module serves as the
useful toolkit for the library, contains a collection of utility classes commonly used in all Java
Application development.

## Prerequisites

This whole `JDevKit` is developed by **JDK 17**, which means you have to use JDK 17 for
better experience.

## Installation

### If you are using `Maven`

It is quite simple to install this module by `Maven`. The only thing you need to do is find your
`pom.xml` file in the project, then find the `<dependencies>` node in the `<project>` node, and add
the following codes to `<dependencies>` node:

```xml
<dependency>
	<groupId>com.onixbyte</groupId>
    <artifactId>devkit-utils</artifactId>
    <version>${devkit-utils.version}</version>
</dependency>
```

And run `mvn dependency:get` in your project root folder(i.e., if your `pom.xml` is located at
`/path/to/your/project/pom.xml`, then your current work folder should be `/path/to/your/project`),
then `Maven` will automatically download the `jar` archive from `Maven Central Repository`. This
could be **MUCH EASIER** if you are using IDE(i.e., IntelliJ IDEA), the only thing you need to do
is click the refresh button of `Maven`.

If you are restricted using the Internet, and have to make `Maven` offline, you could follow the
following steps.

1. Download the `jar` file from any place you can get and transfer the `jar` files to your 
   work computer.
2. Move the `jar` files to your local `Maven` Repository as the path of 
   `/path/to/maven_local_repo/com/onixbyte/devkit-utils/`.

### If you are using `Gradle`

Add this module to your project with `Gradle` is much easier than doing so with `Maven`.

Find `build.gradle` in the needed project, and add the following code to the `dependencies` closure
in the build script:

```groovy
implementation 'com.onixbyte:devkit-utils:${devkit-utils.version}'
```
