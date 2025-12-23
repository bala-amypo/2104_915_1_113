coder@2d19be7057d6:~/Workspace/demo$ mvn spring-boot:run
[INFO] Scanning for projects...
[WARNING] 
[WARNING] Some problems were encountered while building the effective model for com.example:demo:jar:0.0.1-SNAPSHOT
[WARNING] 'dependencies.dependency.(groupId:artifactId:type:classifier)' must be unique: com.mysql:mysql-connector-j:jar -> duplicate declaration of version (?) @ line 74, column 21
[WARNING] 'dependencies.dependency.(groupId:artifactId:type:classifier)' must be unique: com.mysql:mysql-connector-j:jar -> duplicate declaration of version (?) @ line 79, column 13
[WARNING] 
[WARNING] It is highly recommended to fix these problems because they threaten the stability of your build.
[WARNING] 
[WARNING] For this reason, future Maven versions might no longer support building such malformed projects.
[WARNING] 
[INFO] 
[INFO] --------------------------< com.example:demo >--------------------------
[INFO] Building demo 0.0.1-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] >>> spring-boot-maven-plugin:3.2.5:run (default-cli) > test-compile @ demo >>>
[INFO] 
[INFO] --- maven-resources-plugin:3.3.1:resources (default-resources) @ demo ---
[INFO] Copying 1 resource from src/main/resources to target/classes
[INFO] Copying 0 resource from src/main/resources to target/classes
[INFO] 
[INFO] --- maven-compiler-plugin:3.11.0:compile (default-compile) @ demo ---
[INFO] Changes detected - recompiling the module! :source
[INFO] Compiling 46 source files with javac [debug release 17] to target/classes
[INFO] 
[INFO] --- maven-resources-plugin:3.3.1:testResources (default-testResources) @ demo ---
[INFO] skip non existing resourceDirectory /home/coder/Workspace/demo/src/test/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.11.0:testCompile (default-testCompile) @ demo ---
[INFO] No sources to compile
[INFO] 
[INFO] <<< spring-boot-maven-plugin:3.2.5:run (default-cli) < test-compile @ demo <<<
[INFO] 
[INFO] 
[INFO] --- spring-boot-maven-plugin:3.2.5:run (default-cli) @ demo ---
[INFO] Attaching agents: []

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v3.2.5)

2025-12-23T08:46:55.892Z  INFO 42919 --- [demo] [           main] com.example.demo.DemoApplication         : Starting DemoApplication using Java 17.0.17 with PID 42919 (/home/coder/Workspace/demo/target/classes started by coder in /home/coder/Workspace/demo)
2025-12-23T08:46:55.898Z  INFO 42919 --- [demo] [           main] com.example.demo.DemoApplication         : No active profile set, falling back to 1 default profile: "default"
2025-12-23T08:47:00.698Z  INFO 42919 --- [demo] [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.
2025-12-23T08:47:01.390Z  INFO 42919 --- [demo] [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 595 ms. Found 7 JPA repository interfaces.
2025-12-23T08:47:04.090Z  INFO 42919 --- [demo] [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port 9001 (http)
2025-12-23T08:47:04.126Z  INFO 42919 --- [demo] [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2025-12-23T08:47:04.126Z  INFO 42919 --- [demo] [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.20]
2025-12-23T08:47:04.903Z  INFO 42919 --- [demo] [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2025-12-23T08:47:04.906Z  INFO 42919 --- [demo] [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 8700 ms
2025-12-23T08:47:06.804Z  INFO 42919 --- [demo] [           main] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [name: default]
2025-12-23T08:47:06.935Z  INFO 42919 --- [demo] [           main] org.hibernate.Version                    : HHH000412: Hibernate ORM core version 6.4.4.Final
2025-12-23T08:47:07.113Z  INFO 42919 --- [demo] [           main] o.h.c.internal.RegionFactoryInitiator    : HHH000026: Second-level cache disabled
2025-12-23T08:47:07.916Z  INFO 42919 --- [demo] [           main] o.s.o.j.p.SpringPersistenceUnitInfo      : No LoadTimeWeaver setup: ignoring JPA class transformer
2025-12-23T08:47:08.017Z  INFO 42919 --- [demo] [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2025-12-23T08:47:08.687Z  INFO 42919 --- [demo] [           main] com.zaxxer.hikari.pool.HikariPool        : HikariPool-1 - Added connection com.mysql.cj.jdbc.ConnectionImpl@5072e638
2025-12-23T08:47:08.692Z  INFO 42919 --- [demo] [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2025-12-23T08:47:08.798Z  WARN 42919 --- [demo] [           main] org.hibernate.orm.deprecation            : HHH90000025: MySQL8Dialect does not need to be specified explicitly using 'hibernate.dialect' (remove the property setting and it will be selected by default)
2025-12-23T08:47:08.800Z  WARN 42919 --- [demo] [           main] org.hibernate.orm.deprecation            : HHH90000026: MySQL8Dialect has been deprecated; use org.hibernate.dialect.MySQLDialect instead
2025-12-23T08:47:13.812Z  INFO 42919 --- [demo] [           main] o.h.e.t.j.p.i.JtaPlatformInitiator       : HHH000489: No JTA platform available (set 'hibernate.transaction.jta.platform' to enable JTA platform integration)
2025-12-23T08:47:14.404Z  INFO 42919 --- [demo] [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
2025-12-23T08:47:16.090Z  WARN 42919 --- [demo] [           main] ConfigServletWebServerApplicationContext : Exception encountered during context initialization - cancelling refresh attempt: org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'studentProfileController': Unsatisfied dependency expressed through field 'studentProfileService': No qualifying bean of type 'com.example.demo.service.StudentProfileService' available: expected at least 1 bean which qualifies as autowire candidate. Dependency annotations: {@org.springframework.beans.factory.annotation.Autowired(required=true)}
2025-12-23T08:47:16.092Z  INFO 42919 --- [demo] [           main] j.LocalContainerEntityManagerFactoryBean : Closing JPA EntityManagerFactory for persistence unit 'default'
2025-12-23T08:47:16.098Z  INFO 42919 --- [demo] [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
2025-12-23T08:47:16.114Z  INFO 42919 --- [demo] [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.
2025-12-23T08:47:16.117Z  INFO 42919 --- [demo] [           main] o.apache.catalina.core.StandardService   : Stopping service [Tomcat]
2025-12-23T08:47:16.210Z  INFO 42919 --- [demo] [           main] .s.b.a.l.ConditionEvaluationReportLogger : 

Error starting ApplicationContext. To display the condition evaluation report re-run your application with 'debug' enabled.
2025-12-23T08:47:16.391Z ERROR 42919 --- [demo] [           main] o.s.b.d.LoggingFailureAnalysisReporter   : 

***************************
APPLICATION FAILED TO START
***************************

Description:

Field studentProfileService in com.example.demo.controller.StudentProfileController required a bean of type 'com.example.demo.service.StudentProfileService' that could not be found.

The injection point has the following annotations:
        - @org.springframework.beans.factory.annotation.Autowired(required=true)


Action:

Consider defining a bean of type 'com.example.demo.service.StudentProfileService' in your configuration.

[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  52.030 s
[INFO] Finished at: 2025-12-23T08:47:16Z
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.springframework.boot:spring-boot-maven-plugin:3.2.5:run (default-cli) on project demo: Process terminated with exit code: 1 -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoExecutionException