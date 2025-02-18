# Property Guard

`property-guard-spring-boot-starter` is a utility that can help you protect secret values in Spring Boot configurations.

## Example usage

### 1. Implementation this module

```kotlin
dependencies {
    implementation(platform("com.onixbyte:devkit-bom:$devKitVersion"))
    implementation("com.onixbyte:devkit-utils")
    implementation("com.onixbyte:property-guard-spring-boot-starter")
}
```

### 2. Generate a secret

Use the following codes to get a random secret.

```java
@SpringBootTest
class SpringBootApplicationTest {
    
    @Test
    void contextLoads() {
        System.out.println(AesUtil.generateRandomSecret()); // Output: a 16-char long secret
    }
}
```

Or you can write a 16-char long secret by yourself.

### 3. Encrypt your secret properties and place them into your configuration file

### 4. Run application with parameter `--pg.key=$your_secret`

