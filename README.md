irfanstore-apigateway
=======================
This is the sample API Gateway written to run in the Pivotal Cloud Foundry. This application uses the Spring Zuul which implements the Netflix Zuul. API Gateway calls the product-service. It implements the filters, routing and Hystrix fallback.

This application uses following features / services in the Pivotal Cloud Foundry:

### Spring Cloud Connectors 
This application uses Spring Cloud Connectors to discover binded services and connectivity to the MySql or RabbitMQ when services are binded in Cloud Foundry. 

### Spring Zuul
This application uses the Spring Zuul which implements the Netflix Zuul. API Gateway calls the product-service. It implements the filters, routing and Hystrix fallback.

### Service Discovery 
This application uses Service Discovery service of Pivotal Cloud Foundry which internally uses the Netflix Eureka and provides the rich features for example service registration method (registrationMethod) of direct which registers the container’s IP address in the service registry instead of public route for direct service to service (container to container) communication. This feature is handy for the internal service communication instead of service call go out to the public internet and back to the service. 

### Distributed Tracing
This application uses the Spring Cloud Sleuth to enable the Zipkin distributed tracing. 

## Running application inside Pivotal Cloud Foundry
### Service Binding
Service binding is defined in the manifest.yml file. Create the following services inside the Cloud Foundry with the name provided as below:

* `Service Registry` service name: `ostore-service-registry`
* `CloudAMQP` service name: `ostore-rabbitmq`

### Routing the call through the Gateway 
To route the call through the Gateway, configure the routing in the application-cloud.yml file in the `zuul.routes` section. Currently, in the application-cloud.yml file routing for product-service and product-price-service is enabled. To enable all the routes comment out/remove the setting `zuul.ignoredServices` in the yml file. 
Format of URL to route the call through Gateway is as follow:
`http://<<api gateway URL>>/<<service name>>/<<service URL>>`
For example:
`http://irfanstore-apigateway.cfapps.io/product-service/api/product`

Gateway discover the service through the service registry for the application name defined in the URL.

### Push the application
After creating the services push the application using the `cf push` command. 

