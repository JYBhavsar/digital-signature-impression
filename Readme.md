# Guide for this project

### Access project via swaggger ui
[Swagger SMARTBEAR](http://localhost:8084/swagger-ui/index.html)


## RSA Key generator
- openssl genpkey -algorithm RSA -out private_key.pem -pkeyopt rsa_keygen_bits:2048
- openssl rsa -pubout -in private_key.pem -out public_key.pem
 