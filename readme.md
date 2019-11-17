参考URL

- http://joytas.net/programming/jsp-servletmvc_todo

### sqlite setting
```
choco install sqlite.shell

cd \WEB-INF
sqlite3 todo.db


CREATE TABLE todos(
 id INTEGER PRIMARY KEY AUTOINCREMENT,
 title VARCHAR(30),
 importance INTEGER
 );

 .tables

  insert into todos (title,importance) values('おやすみ',1);
  select * from todos;

 .exit
```

###context.xml
```
  <Resource
  name="jdbc/tododb"
  auth="Container"
  type="javax.sql.DataSource"
  maxTotal="100"
  maxIdle="30"
  maxWaitMillis="10000"
  username=""
  password=""
  driverClassName="org.sqlite.JDBC"
  url="jdbc:sqlite:C:/00_data/90_repos/java/workspace/todoapp/WebContent/WEB-INF/todo.db" />
```

###web.xml
```
    <resource-ref>
        <res-ref-name>jdbc/tododb</res-ref-name>
        <res-type>javax.sql.DataSource</res-type>
        <!-- <res-auth>CONTAINER</res-auth>-->
    </resource-ref>
```