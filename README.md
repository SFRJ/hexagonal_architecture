hexagonal_architecture
======================

This application is just an example of a way to implement an hexagonal architecture for a Java app:
- The core contains domain objects and service ports
- The implementation module contains the adapters that implement the ports
- The endpoints module are the rest endpoints via which services will be acessed
- The glue package configures an embedded jetty server where it will register the endpoints(and some other features)
and also a service binder which will be our dependency injection manager, for the services.



