### `@Singleton` of `javax.inject.Singleton`

By Default, every call to API is request scope. This means a new reference to the resource class will be created for each call. If we create a variable `private  int  count` and increase this count for every call to a specific method, the value returned will always will be `1` since new reference will be created for every call and the value will be set to `0`.

This can be avoided by using the annotation `@Singleton` of `javax.inject.Singleton`. This will always return the same reference and the count keeps increasing for every request.