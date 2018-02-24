# Configuration
    Setup Instructions used to prepare the environment for program-execution.

# ActiveMq Dockerfile 
`FROM webcenter/activemq`

`LABEL Kudzai Sean Huni <kudzai@bcs.org>`

`ENV ACTIVEMQ_CONFIG_MINMEMORY 512`
`ENV ACTIVEMQ_CONFIG_MAXMEMORY 2048`

`RUN apt-get install -y vim`

## Docker build command                          
cmd$ `docker build -f Dockerfile -t activemq-img .`

## Run the activemq docker instance from the activemq-img mapped to the published random ports.
cmd$: `docker run --name='activemq' -d -it -P activemq-img`

## Run the activemq docker instance from the activemq-img mapped to the dedicated published & random ports.
cmd$: `docker run --name='activemq' -d -it -p 8081:8161 -p 8091:61616 -P activemq-img`

# RabbitMq Dockerfile
`FROM rabbitmq:latest`

`LABEL Kudzai Sean Huni <kudzai@bcs.org>`

`ENV RABBITMQ_DEFAULT_USER admin`
`ENV RABBITMQ_DEFAULT_PASS admin`

`RUN apt-get update`

## Build the RabbitMq custom-img
cmd$: `docker build -f Dockerfile -t rabbitmq-img .`

## Run the rabbitmq docker instance from the rabbitmq-img mapped to the random ports only. 
cmd$: `docker run --name='rabbitmq' -d -it -P rabbitmq-img`

## Run the rabbitmq docker instance from the rabbitmq-img mapped to the designated & random ports.
cmd$: `docker run --name='rabbitmq' -d -it -p 8082:15672 -p 8092:5672 -P rabbitmq-img`

## Queue
    Create sms queues both in activeMq & in RabbitMq.
    
## JFrog-Artifactory

### Dockerfile
`FROM docker.bintray.io/jfrog/artifactory-oss:latest`

`LABEL Kudzai Sean Huni <kudzai@bcs.org>`

`RUN apt-get update -y`

### Run CMD
`docker build -f Dockerfile -t jfrog-img .`
`docker run --name='jfrog' -d -it -p 8083:8081 jfrog-img`

### JFrog-Artifactory Configuration
On the web-console initialise gradle Jfrog plugin.
username & password: admin

# Git
- Remove cached file/folders:
- **cmd$: `git rm -r --cached --force ".idea/"`**