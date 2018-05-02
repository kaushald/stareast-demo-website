# Java Mem Leaky Web Server

> A sample project to demo performance and monitoring at STAREAST 2018

* [Pre-requisites](#pre-requisites)
* [Build](#build)
* [Run](#run)
* [Performance-Test](#performance-test)

---

## Pre-requisites

To get started you need a running docker installation. If you don't have one, you can download Docker for [Mac](https://www.docker.com/docker-mac) or [Windows](https://www.docker.com/docker-windows), or follow the installation instructions for Docker CE for your [Linux distribution](https://docs.docker.com/engine/installation/#server).

Also, [Node](https://nodejs.org/en/download/) would be needed to be able to run the load generation tool - Artillery that can be installed by running -

```shell
$ npm install -g artillery  
```

---

## Build

```console
$ ./gradlew build
$ docker build -t kaushald/se-demo .
```

---

### Run

```console
$ docker run -d -p 8080:8080 --name=se-demo kaushald/se-demo
```

---

## Performance-Test

#### Run the test

```
artillery run -o memleak.json config.yml
```

#### Create a report

```console
$ artillery report memleak.json
```

---
