## :information_source: About this project

It's a simple converter for some units for IS default.

## :information_source: How To Use

To clone and run this application, you'll need Git, Java and Docker installed on your computer.

From your command line:

### Steps to run the project

```bash
# Clone this repository
$ git clone https://github.com/JoaoCipriano/converter-units.git

# Go into the repository
$ cd converter-units

# Install dependencies
$ mvnw install

# Execute Dockerfile
$ docker build -t spring-app .

# Start a container with the image created
$ docker run -p 8080:8080 --name challenge spring-app

# Application available in localhost:8080
```

### Endpoint available
Request example GET http://localhost:8080/units/si?units=minute
