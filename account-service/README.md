
The process followed to solve this problem, is:

1- Understand the problem:

Trying to understnd the points which are unclear.

2- Mental schema:

Transforming the problem into models. For example:

Account: class.
Properties: attributes.
Requirements: restrictions:
Actions: methods.

Once we have our mental schema, we tried to fit the problem into the spring boot framework. For example:

- Rest api: using the controller then http methods, like: get, post and so on.
- Database communication: as we have basic operations, CRUD, we use directly JPA Repository without adding custom functionalities.
- Server: spring boot comes with the embedded tomcat.
- Configurations: spring boot does all the configuration in order to focus about the problem itself.

and so on with other technicals situations like tests, etc.

3- Get it done!

Once we have the schema, we transformed the solution to the code. Which has required some investigation about spring boot, how to create some specifique features and so on. Once the knowledge is there, put it together et voilá!

4- Testing is a duty(NO, testing menans good work)

We tried to test the application, once we have checked that the requirements are fullfilled, then we made some tests.

We didn't test every single detail, because we consider that the goal of this exercise is not making the whole application 100% perfect. So we did the main tests, in order to show some testing skills.

Also, we could refactor the code, like creating constants with text or enums. We are also conscious about the granularity of commits.


NOTE: is possible that we could have missed some situation in the requirements. We have developed the solution taking into account that we have understood it.

PD: We, means I ;)
