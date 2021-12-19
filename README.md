# Microservices

> source : [Programming Techie](https://youtube.com/playlist?list=PLSVW22jAG8pDY3lXXEv1hKVIAlnJ9nDN_)

### Table of Contents

- [Product Service Microservice](https://github.com/krishna-sk/online-shopping/tree/master/product-service)


![](images/microservices_architecture.png)

#### Config Server
- Config server reads the common properties from the GitRepository [central-config-server](https://github.com/krishna-sk/central-config-server)
- we create the application.yml in the GitRepository and the properties in this file is read by all the microservices.
- First the properties in application.yml file in the GitRepository is copied to the config server and from there all the microservices read this properties.
- We can provide microservice specific properties in the central config server(GitHub Repository) also. We need to write file name as microserviceName.yml or microSercice.properties.

##### [Hashicorp Vault](https://learn.hashicorp.com/vault)
- We store our secrets related to the microservices in the Hashicorp vault like database username, password, JWT Secret Key, API Keys.
