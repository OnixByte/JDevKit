# JDevKit
JDevKit is a Java Development Kit that offers a set of convenient tools for writing code efficiently.

## Modules

> For more information, please visit the README file of each module.

### `devkit-core` <span style="font-size: 14px;">_[Learn more](devkit-core/README.md)_</span>
The core module for `JDevKit`, by now, this module contains the commonly used classes of the whole `dev-kit`.

### `guid` <span style="font-size: 14px;">_[Learn more](guid/README.md)_</span>
A module for generating globally unique IDs. It includes a facade interface and an implementation of GUID generation 
using the Snowflake algorithm. More globally unique ID generation modes will be added in the future.

### `dev-utils` <span style="font-size: 14px;">_[Learn more](dev-utils/README.md)_</span>
A collection of common utility classes to simplify Java development. It includes tools for Base64 encoding/decoding of 
strings, reducing if-else code blocks using Lambda expressions, converting between maps and arbitrary objects, 
high-precision chained mathematical calculations, and string hashing or message digest calculations.

### `simple-jwt-facade` <span style="font-size: 14px;">_[Learn more](simple-jwt-facade/README.md)_</span>
A facade for Simple JWT (JSON Web Token) implementations in Java. This module provides a unified interface to work with
JWTs regardless of the underlying implementation.

### `simple-jwt-auth0` <span style="font-size: 14px;">_[Learn more](simple-jwt-facade/README.md)_</span>
A Simple JWT implementation using the com.auth0:java-jwt library.

### `simple-jwt-spring-boot-starter` <span style="font-size: 14px;">_[Learn more](simple-jwt-spring-boot-starter/README.md)_</span>
A Spring Boot auto-configuration wrapper for the simple-jwt module, making it easier to integrate JWT functionality into
Spring Boot applications.

### `sms-sender-facade` <span style="font-size: 14px;">_[Learn more](sms-sender-facade/README.md)_</span>
A facade for sending SMS messages in Java. This module abstracts the interfaces of various SMS service providers.

### `sms-sender-aliyun` <span style="font-size: 14px;">_[Learn more](sms-sender-aliyun/README.md)_</span>
An implementation of SMS Sender using the Alibaba Cloud (Aliyun) service.

### `sms-sender-tencent` <span style="font-size: 14px;">_[Learn more](sms-sender-tencent/README.md)_</span>
An implementation of SMS Sender using the Tencent Cloud service.

### `sms-sender-spring-boot-starter` <span style="font-size: 14px;">_[Learn more](sms-sender-spring-boot-starter/README.md)_</span>
A Spring Boot auto-configuration wrapper for the sms-sender module, simplifying the integration of SMS sending
capabilities into Spring Boot applications.

## Installation and Usage
If you are using `maven`, please paste the following codes to `pom.xml` in your project.

```xml 
<dependency>
	<groupId>cn.org.codecrafters</groupId>
    <artifactId>${artifactId}</artifactId>
    <version>${version}</version>
</dependency>
```

If you are using `gradle`, please paste the following codes to `buile.gradle` in your project.

```groovy
implementation 'cn.org.codecrafters:$artifactId:$version'
```

If you want to check the available versions, please check out at our [official site]().

## Contribution
Contributions are welcome! If you encounter any issues or want to contribute to the project, please feel free to 
**[raise an issue](https://github.com/CodeCraftersCN/jdevkit/issues/new)** or **[submit a pull request]()**.

## License
This project is licensed under the [Apache License 2.0](LICENSE).

## Contact
For any questions or feedback, you can [open an issue](https://github.com/CodeCraftersCN/jdevkit/issues/new) on GitHub 
or join our [Discord community]().