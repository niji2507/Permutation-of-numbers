# Permutation-of-numbers
Backend service which uses Spring boot framework and Inmemory database (h2) to find permutation for a given number or a list of numbers

<h2>Technologies</h2>
<ul>
 <li>Java</li>
 <li>Spring boot</li>
 <li>JPA</li>
 <li>H2 database (in memory database)</li>
 <li>Docker</li>
 <li>Spock for Unit testing</li> 
 <li>SonarLint and PWD for code quality analysis</li>
 <li>Swagger for documentation</li>
</ul>

 <h2>Running Demo</h2>
 
 <h3>Uploaded a Gif to view the demo</h3> 
 
 <h2>To run a demo</h2>
 Web server:
 <ul>
  <li>Install Maven and set the environmental variables</li>
  <li>Clone the project</li>
  <li>Import as a maven project in IDE (used Eclipse)</li>
  <li>Do right click project -> maven -> download sources -> to download dependencies in pom.xml</li>
  <li>Run as Java Application</li>
  <li>Web Service will run in localhost on port 8080</li>
 </ul>
  
 API endpoints:
 <ul>
  <li>GET method - /permutation/permutations/{input} - input param -> For a given input Integer, permutaions are calcualted and response is retruned as a JSON response.Input should be an Integer, else error resposne will be returned</li>
  <li>POST method - /permutation/permutations/list - for given set of integer values, permuataions are calculated and response is returned. Input values are given as payload as part of post request.</li>
 </ul>
  
 Unit test cases:
 <ul>
  <li>Spock teesting using Groovy</li>
  <li>Run as a junit test application to get the result based on test cases written</li>
  <li>Attached test coverage report with 100% code test coverage</li>
 </ul>
 
  Swagger documentaion:
  <ul>
  <li>Run web server</li>
  <li>Swagger api ui will run on localhost:8080/swwagger-ui.html</li>
  </ul>
  
  <h2>Docker:</h2>  
  Steps to Deploy jar in docker and run (in linux)
  <ul>
    <li>Install docker and docker compose</li>
    <li>Create the docker file -<sample docker file is uploaded above></li>
    <li>Create image using command docker build -t <imageName> in the directory where docker file is present</li>
    <li>Execute command docker-compose up, this will take images from docker.yml file and run all the images which is mentioned in that.Docker compose will run all the services paralley thereby reducing the effort to run each service seperately</li>
  <li>Once application is started, it can be accessed in the ip where docker is running</li>
  </ul>
 
 
 

 
  

 
 

