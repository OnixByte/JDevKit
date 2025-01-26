# KeyLoader

KeyLoader provides utility methods to load keys from pem-formatted key texts.

## ECDSA-based algorithm

### Generate key pair

#### Generate private key

Generate a private key by `genpkey` command provided by OpenSSL:

```shell
openssl genpkey -algorithm EC -pkeyopt ec_paramgen_curve:P-256 -out ec_private_key.pem
```

The output of this command is a file called `ec_private_key.pem` and its content looks like the
following:

```text
-----BEGIN PRIVATE KEY-----
MIGHAgEAMBMGByqGSM49AgEGCCqGSM49AwEHBG0wawIBAQQgs79JlARgXEf6EDV7
+PHQCTHEMtqIoHOy1GZ1+ynQJ6yhRANCAARkA7GRY2i4gg8qx0XViAXUP9cPw9pn
Jg1wfrQ41FaMyqVBejNYxvaLtamErF/ySimnjafMJ+VZCh34lBj6Ez8R
-----END PRIVATE KEY-----
```

#### Generate public key by private key

Export public key from private key with `ec` command provided by OpenSSL:

```shell
openssl ec -in ec_private_key.pem -pubout -out ec_public_key.pem
```

The output of this command is a file called `ec_public_key.pem` and its content looks like the
following:

```text
-----BEGIN PUBLIC KEY-----
MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEZAOxkWNouIIPKsdF1YgF1D/XD8Pa
ZyYNcH60ONRWjMqlQXozWMb2i7WphKxf8kopp42nzCflWQod+JQY+hM/EQ==
-----END PUBLIC KEY-----
```

#### Convert private key to EC formats which could be acceptable by Java

Java's `PKCS8EncodedKeySpec` requires the private key to be in PKCS#8 format, while OpenSSL by
default generates private keys in traditional PEM format. To convert the private key, run the
following command:

```shell
openssl pkcs8 -topk8 -inform PEM -outform PEM -in ec_private_key.pem -out ec_private_key_pkcs8.pem -nocrypt
```

The converted private key will look like this:

```text
-----BEGIN PRIVATE KEY-----
MIGHAgEAMBMGByqGSM49AgEGCCqGSM49AwEHBG0wawIBAQQgs79JlARgXEf6EDV7
+PHQCTHEMtqIoHOy1GZ1+ynQJ6yhRANCAARkA7GRY2i4gg8qx0XViAXUP9cPw9pn
Jg1wfrQ41FaMyqVBejNYxvaLtamErF/ySimnjafMJ+VZCh34lBj6Ez8R
-----END PRIVATE KEY-----
```