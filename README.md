# smartelligynt-api


####Install docker image on your machine
https://docs.docker.com/v1.13/docker-for-mac/install/


####Take latest code from github and do mvn build
```$ mvn clean install```


####On successful build build docker image
```$ mvn package docker:build```


####Confirm newly created image (36 seconds ago)
```$ docker images```

####Test docker image locally
````$ docker run -p 8080:8080 -t smartelligynt/smartelligynt-api````

####Confirm by curl or in browser
```$ curl localhost:8080/api/````

￼####Lets push newly created and successfully tested image to docker hub


####Login on docker hub
login : smartelligynt
pwd : pwd is on messenger

```$ docker login````

####Push newly created image to public docker hub
```$ docker push smartelligynt/smartelligynt-api```


Confirm image push on docker hub by visiting https://hub.docker.com/r/smartelligynt/smartelligynt-api 
￼


This link is helpful
https://spring.io/guides/gs/spring-boot-docker/#initial

