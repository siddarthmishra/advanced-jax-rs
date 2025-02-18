### `javax.ws.rs.core.Application` and `@ApplicationPath` of `javax.ws.rs.ApplicationPath`

In the previous JAX-RS tutorial, we had configured Jersey Servlet and servlet mapping pattern `/webapi/*` in the **web.xml** and then deployed the WAR.

There is another way to run the application without the need for having servlet container and servlet mapping pattern in the **web.xml**. Jersey allows the application to be bootstrapped and run it like plain java class.

All we have to do is create a class and extend the class with `javax.ws.rs.core.Application`. Then we have to annotate the class with `@ApplicationPath`. If we want to add additional mapping like we did in the web.xml, then we can add like this `@ApplicationPath("webapi")`. The REST API path for this will look like `http://localhost:8080/advanced-jaxrs-01/webapi/test`. If we omit the pattern, then the REST API will be `http://localhost:8080/advanced-jaxrs-01/test`.
In this case, the **web.xml** does not contain anything related to servlet container or servlet mapping patter. We can deploy the generated WAR and use the APIs.