# Module `devkit-utils`

## Introduction

This module is part of `JDevKit`, an open-source Java Development Kit that provides a set of convenient tools to streamline code development and enhance productivity. This module serves as the useful toolkit for the library, contains a collection of utility classes commonly used in all Java Application development.

## Prerequisites

This whole `JDevKit` is developed by **JDK 17**, which means you have to use JDK 17 for better experience.

## Installation

### If you are using `Maven`

It is quite simple to install this module by `Maven`. The only thing you need to do is find your `pom.xml` file in the project, then find the `<dependencies>` node in the `<project>` node, and add the following codes to `<dependencies>` node:

```xml
<dependency>
	<groupId>cn.org.codecrafters</groupId>
    <artifactId>devkit-utils</artifactId>
    <version>${devkit-utils.version}</version>
</dependency>
```

And run `mvn dependency:get` in your project root folder(i.e., if your `pom.xml` is located at `/path/to/your/project/pom.xml`, then your current work folder should be `/path/to/your/project`), then `Maven` will automatically download the `jar` archive from `Maven Central Repository`. This could be **MUCH EASIER** if you are using IDE(i.e., IntelliJ IDEA), the only thing you need to do is click the refresh button of `Maven`.

If you are restricted using the Internet, and have to make `Maven` offline, you could follow the following steps.

1. Download the `jar` file from any place you can get and transfer the `jar` files to your work computer.
2. Move the `jar` files to your local `Maven` Repository as the path of `/path/to/maven_local_repo/cn/org/codecrafters/devkit-utils/`.

### If you are using `Gradle`

Add this module to your project with `Gradle` is much easier than doing so with `Maven`.

Find `build.gradle` in the needed project, and add the following code to the `dependencies` closure in the build script:

```groovy
implementation 'cn.org.codecrafters:devkit-utils:${devkit-utils.version}'
```

### If you are not using `Maven` or `Gradle`

1. Download the `jar` file from the Internet.
2. Create a folder in your project and name it as a name you like(i.e., for me, I prefer `vendor`).
3. Put the `jar` file to the folder you just created in Step 2.
4. Add this folder to your project `classpath`.

### Base64 Encode and Decode

If you are trying to encode a string to Base64 string or decode a Base64 string to normal string, then you can try this:

```java
import utils.com.onixbyte.devkit.Base64Util;

// To reduce sample codes, let me use the simplified main method that is upcoming in Java 21
void main(String... args) {
    var aString = "The string you need to encode.";
    // Encode it from original text.
    var encodedString = Base64Util.encode(aString);
    // Decode the encoded text.
    var decodedString = Base64Util.decode(encodedString);
}
```

## Reduce `if...else...`

I believe those `if...else...` blocks make you headache, and Java imported lambda since Java 8, why not try to replace those `if...else` with lambda expressions?

```java
import utils.com.onixbyte.devkit.BranchUtil;

void main(String... args) {
    var a = 1;
    var b = 2;
    
    if (a < b) {
        // do something...
    } else {
        // do something different...
    }
    // The codes above is really annoying, have a try of the lambda version.
    
    BranchUtil.or(a < b) // If multiple logical expressions are combined using the OR operator.
        .handle(() -> {
            // do something if a < b.
        }, () -> {
            // do something if a > b.
        });
    
    BranchUtil.and(a < b) // If multiple logical expressions are combined using the AND operator
        .handle(() -> {
            // do something if a < b.
        }, () -> {
            // do something if a > b.
        });
}
```

What if you have to get some data from this branch? Don't worry, those **lambda supports Supplier**. Just add a return in those lambda is fine.

## CHAINED High-precision Calculation

If you have faced high-precision mathematical calculation in Java, you might know it is very troubled to do it in **ANY** programming languages. I'm certain you remember that `0.1 + 0.2 != 0.3` right?

In Java, we usually do high-precision mathematical calculation with `BigDecimal` which is quite tricky when using it.

```java
import utils.com.onixbyte.devkit.ChainedCalcUtil;

void main(String... args) {
    // If you are trying to calculate the expression of 1 * 2 / 2 - 3 + 4
    ChainedCalcUtil.startWith(1).multiply(2).divide(2).subtract(3).add(4).getInteger(); // you can also get a double by getDouble([int scale]), get a BigDecimal by getDecimal([int scale]) or get a long by getLong().
}
```

If you are facing a divide calculation which has an infinite decimal expansion, then DON'T use `divide(dividend)`, use `divideWithScale(dividend, scale, [beforeOperateScale])`.

## Hash a `String`

As is well known, storing plain text passwords in a database is very insecure. Therefore, you need to encrypt the passwords stored in the database, or at least make it difficult for hackers to see the real password at a glance. As a result, hash calculation is often used in database password obfuscation due to its ease of use.

This `HashUtil` supports these following hash or message digest algorithms:

- MD2
- MD5
- SHA-1
- SHA-224
- SHA-256
- SHA-384
- SHA-512

If you want to run a hash calculation to a string, you can use the following codes:

```java
import utils.com.onixbyte.devkit.HashUtil;

void main(String... args) {
    var plaintext = "This is a plain text";
    var hashedText = HashUtil.md2(plaintext); //  if you want to use other algorithm, just change the method name such as md5, sha1, sha224 and so on.
}
```

Besides, if you want to use other character set to do the hash calculation, you can add the specified charset after the text to be calculated.

```java
HashUtil.$algorithm$(String textToCalculate, Charset charset);
```

## Convert a Map to Any Object and Vice Versa

A Map is a data structure that allows you to store key-value pairs. The keys can be of any type and the values can be of any type. In this case, the key is the user's name and the value is the user's profile.

Imagine you are developing a website where users can register an account and store their profile. A profile can contain information like their name, age, address, and email address. You store the user's profile in a Map. When the user registers an account, you need to store their profile in a database. A database is a system for storing data. A database can store any type of data, including Maps.

In order to store the Map in a database, you need to convert the Map to an Object. An Object is a generic data type that can store any type of data.

```java
import utils.com.onixbyte.devkit.MapUtil;

class Data {
    private String name;
    private Long id;
    private Integer age;
    
    // Setters and getters here.
    
    // No-args constructor and all-args constructor here.
}

void main(String... args) {
    // Create a map.
    var dataMap = new HashMap<String, Object>();
    dataMap.put("name", "Zihlu Wang");
    dataMap.put("id", 1L);
    dataMap.put("age", 18);
    
    // Convert this map to an instance of class Data
    var data = MapUtil.mapToObject(dataMap, Data.class); // Then you got an instance of Data("Zihlu Wang", 1L, 18);
    
    // Then you can convert this object to a map.
    var anotherDataMap = MapUtil.objectToMap(data)
}
```

## Contact

If you have any suggestions, ideas, don't hesitate contacting us via [GitHub Issues](https://github.com/CodeCraftersCN/jdevkit/issues/new) or [Discord Community](https://discord.gg/NQK9tjcBB8). 

If you face any bugs while using our library and you are able to fix any bugs in our library, we would be happy to accept pull requests from you on [GitHub](https://github.com/CodeCraftersCN/jdevkit/compare).
