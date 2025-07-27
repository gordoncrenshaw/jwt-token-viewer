# jwt-token-viewer

## What is a JWT token

A JSON Web Token (JWT) is a compact and self-contained way for securely transmitting information between parties as a JSON object. This information can be verified and trusted because it is digitally signed. JWTs are commonly used for authentication and information exchange.

Fitbit creates JWT tokens to be used as Bearer or access tokens when calling the Web API endpoints.  This code provides a view into the contents of a JWT token, similarly to the Introspect endpoint, https://dev.fitbit.com/build/reference/web-api/authorization/introspect/.

## Compiling the code

I build this example using the IDE VS Code.  It's a java maven project, and uses the gson libraries to parse the JSON string.

## Acknowledgement

This code is based on the sample provided on https://www.baeldung.com/java-jwt-token-decode.
