
* Install docker image on your machine
https://docs.docker.com/v1.13/docker-for-mac/install/


* Take latest code from github and do mvn build
```
$ mvn clean install
```


* On successful build build docker image
```
$ mvn package docker:build
```


* Confirm newly created image (36 seconds ago)
```
$ docker images

```

* Test docker image locally
```
$ docker run -p 8080:8080 -t smartelligynt/smartelligynt-api
```

* Confirm by curl or in browser
```
$ curl localhost:8080/api/
```

* Lets push newly created and successfully tested image to docker hub


* Login on docker hub
login : smartelligynt
pwd : pwd is on messenger

```
$ docker login
```

* Push newly created image to public docker hub
```
$ docker push smartelligynt/smartelligynt-api
```


* Confirm image push on docker hub by visiting https://hub.docker.com/r/smartelligynt/smartelligynt-api 
￼


This link is helpful
https://spring.io/guides/gs/spring-boot-docker/#initial


###Issues
Docker can't connect to docker daemon
```
$ docker ps
Cannot connect to the Docker daemon at unix:///var/run/docker.sock. Is the docker daemon running?
```
http://stackoverflow.com/questions/21871479/docker-cant-connect-to-docker-daemon

* Check if you've docker-machine by:
  `$ docker-machine --version`
* If not, install machine binary via - OS X
	•	install via Brew: `brew install docker-machine`
	•	manually:`install -v <(curl https://github.com/docker/machine/releases/download/v0.5.3/docker-machine_linux-amd64) /usr/local/bin/docker-machine`

* Then you need to create default machine (if you don't have one):
  `docker-machine create --driver virtualbox default`
* Or check if already exists:
  `docker-machine ls`
* Set-up the environment for the Docker client:
  `eval "$(docker-machine env default)"`
* Then double-check by listing containers:
  `docker ps`

```
$ docker-machine stop
Stopping "default"...
Machine "default" was stopped.
$ docker-machine start
Starting "default"...
(default) Check network to re-create if needed...
(default) Waiting for an IP...
Machine "default" was started.
Waiting for SSH to be available...
Detecting the provisioner...
Started machines may have new IP addresses. You may need to re-run the `docker-machine env` command.
$ docker-machine env
export DOCKER_TLS_VERIFY="1"
export DOCKER_HOST="tcp://192.168.99.100:2376"
export DOCKER_CERT_PATH="/Users/<name>/.docker/machine/machines/default"
export DOCKER_MACHINE_NAME="default"
# Run this command to configure your shell: 
# eval $(docker-machine env)
$ eval $(docker-machine env)

```
