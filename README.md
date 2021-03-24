# Steps to reproduce

1. Start a local mongodb instance
2. Start the application and initialize the database -  The `CommandLineAppStartupRunner` will create two projects and retrieve them
3. Browse http://localhost:8080 and it will get the projects. So far so good
4. Stop the application   
5. Remove @Component from `CommandLineAppStartupRunner`
6. Start the application
7. Browse http://localhost:8080. It will fail with the exception
8. If you downgrade to 2.4.3 it will work fine

NOTE: We are customizing Mongodb in `MongoDbClientConfiguration`
