## Spring Boot basic authentication using Spring Security
#### In memory 
- Uncomment config/springSecurityConfigInMem.java and comment other config files
- For testing use Browser/Postman; url is http://localhost:8092/sample/test
- Will work for username/password as user/pass or admin/pass; fail for others
- Remove cache from browser/postman if needed for testing
#### Using Database (MySQL)
- Uncomment config/springSecurityConfigMySQL.java and comment other config files
- Uncomment mysql-connector-java dependency in pom.xml
- Create MySQL table and insert values
```
 	CREATE TABLE Users (
	    id int,
	    userName varchar(255),
	    email varchar(255),
	    userPassword varchar(255),
	    role varchar(10),
	);
  insert into users (id, userName, email, userPassword, role) values(1,'user', 'user@test.com', 'pass','user');
```
- Uncomment mysql section in application.properties and provide correct entries
- For testing use Browser/Postman; url is http://localhost:8092/sample/test
- Will work for username/password as user/pass; fail for others
- Remove cache from browser/postman if needed for testing
#### Using Database (Oracle)
- Uncomment config/springSecurityConfigOracle.java and comment other config files
- Uncomment ojdbc6 dependency in pom.xml
- Create Oracle table and insert values
```
 	CREATE TABLE USERS (
	    ID number,
	    USERNAME varchar(255),
	    EMAIL varchar(255),
	    PASSWORD varchar(255),
	    ROLE varchar(10),
	);
  insert into users (ID, USERNAME, EMAIL, PASSWORD, ROLE) values(1,'user', 'user@test.com', 'pass','user');
```
- Uncomment oracle section in application.properties and provide correct entries
- For testing use Browser/Postman; url is http://localhost:8092/sample/test
- Will work for username/password as user/pass; fail for others
- Remove cache from browser/postman if needed for testing
#### Using Password Encoder with Oracle
- Uncomment config/springSecurityConfigOraclePassEncode.java and comment other config files
- Use pom.xml, application.properties and table structure used in last section
- Create an encoded password for a secret text (like "userpassword") using code in PasswordEncoderGenerator.java
- Delete all records from table having plain text password, insert a new record with the encoded password
- For testing use Browser/Postman; url is http://localhost:8092/sample/test
- Will work for username/password as user/userpassword; fail for others
- Here spring security encodes "userpassword" passed and matches it will the encoded password stored in DB
#### Using Basic authentication with RestTemplate


  
