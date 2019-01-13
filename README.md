# spring-boot-samples
  Commands :
  
      mvn clean install
  
      mvn spring-boot:run
#SSL certification (https)
https://www.baeldung.com/spring-boot-https-self-signed-certificate
create a JKS(Java Key Store) ssl- self signed certification by "keytool" tool for java
(for other languages we create PKCS12: Public Key Cryptographic Standards with "openSSL" tool )
using Keytool command :
keytool -genkeypair -alias baeldung -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore baeldung.p12 -validity 3650
this creates a ssl certificate by taking information like name, city, country, password(default is changeit) named 'baeldung.p12' in resources folder

we can enable and disble ssl certification by:
server.ssl.enabled=false