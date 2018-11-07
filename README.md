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
  insert into users (id, userName, email, userPassword, role) values(1,'user', 'user@test.com', 'pass','ADMIN');
```
- Uncomment mysql section in application.properties and provide correct entries
- For testing use Browser/Postman; url is http://localhost:8092/sample/test
- Will work for username/password as user/pass or admin/pass; fail for others
- Remove cache from browser/postman if needed for testing

  
