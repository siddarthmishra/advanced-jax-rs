### Drawback of `@Singleton` of `javax.inject.Singleton`

Let's consider below example where the resource is marked as `@Singleton` and request parameters are annotated to member variable. If we have `@PathParam` and `@QueryParam` at instance level, it can be used by all the methods present in the class. If we use this as method parameters, it will be restricted only to that specific methods.

```java
@Path("{pathParam}/test")
@Singleton
public  class MyResource {

	@PathParam("pathParam") private String pathParamExample;
	@QueryParam("query") private String queryParamExample;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
	return  "It works!!!\n" + "Path Param - " + pathParamExample + "\nQuery Param - " + queryParamExample;
	}
}
```
When we try to deploy the API, we get the below error.

```java
21-Oct-2024 17:49:52.476 SEVERE [http-nio-8080-exec-111] org.apache.catalina.core.ApplicationContext.log Servlet.init() for servlet [org.siddarth.javabrains.rest.MyApp] threw exception
org.glassfish.jersey.server.model.ModelValidationException: Validation of the application resource model has failed during application initialization.
[[HINT] Cannot create new registration for component type class org.glassfish.jersey.jsonb.internal.JsonBindingProvider: Existing previous registration found for the type.; source='null', [FATAL] Parameter pathParamExample of private java.lang.String org.siddarth.javabrains.rest.MyResource.pathParamExample cannot be injected into singleton resource.; source='private java.lang.String org.siddarth.javabrains.rest.MyResource.pathParamExample', [FATAL] Parameter queryParamExample of private java.lang.String org.siddarth.javabrains.rest.MyResource.queryParamExample cannot be injected into singleton resource.; source='private java.lang.String org.siddarth.javabrains.rest.MyResource.queryParamExample']
		at org.glassfish.jersey.server.ApplicationHandler.initialize(ApplicationHandler.java:371)
		at org.glassfish.jersey.server.ApplicationHandler.lambda$initialize$1(ApplicationHandler.java:293)
		at org.glassfish.jersey.internal.Errors.process(Errors.java:292)
		at org.glassfish.jersey.internal.Errors.process(Errors.java:274)
```

Singleton resources are instantiated during application startup and way before request call comes in. So, you cannot inject request specific information to their member variable.

So, request annotation like `@PathParam` and `@QueryParam` cannot be used as member variable for Singleton request. It should only be used as method parameter since method parameter gets created at request call.

There are two ways to fix this issue. They are:
	- Remove the `@Singleton` annotation at the class level.
	- Move the request annotations as method parameters.