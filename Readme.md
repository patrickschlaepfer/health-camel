# Guerir

guérir {verb}
to cure · to recover · to treat · to heal · to remedy · to care for

After following  

http://de.slideshare.net/davsclaus/riga-dev-day-2016-microservices-with-apache-camel-fabric8-on-kubernetes?qid=63bff260-8a79-4da1-8d89-819d9b3e4226&v=&b=&from_search=1

was thinking to adapt it. Just having a plain Camel implementation.

## Docker

First install docker binaries - DockerToolbox for windows

Then start Docker

```
C:\Projects\health-spring-boot\health-spring-boot-systemone>docker-machine env default
SET DOCKER_TLS_VERIFY=1
SET DOCKER_HOST=tcp://192.168.99.100:2376
SET DOCKER_CERT_PATH=C:\Users\patrick.INTERNAL\.docker\machine\machines\default
SET DOCKER_MACHINE_NAME=default
REM Run this command to configure your shell:
REM     @FOR /f "tokens=*" %i IN ('docker-machine env default') DO @%i

C:\Projects\health-spring-boot\health-spring-boot-systemone>@FOR /f "tokens=*" %i IN ('docker-machine env default') DO @%i

C:\Projects\health-spring-boot\health-spring-boot-systemone>docker version
Client:
 Version:      1.11.1
 API version:  1.23
 Go version:   go1.5.4
 Git commit:   5604cbe
 Built:        Tue Apr 26 23:44:17 2016
 OS/Arch:      windows/amd64

Server:
 Version:      1.11.1
 API version:  1.23
 Go version:   go1.5.4
 Git commit:   5604cbe
 Built:        Wed Apr 27 00:34:20 2016
 OS/Arch:      linux/amd64
 ```
### Login to docker

```
docker login
```
