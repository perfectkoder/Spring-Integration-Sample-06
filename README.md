# Spring-Integration-Sample-05
Spring Integration example with load balancer.

1) By default the load balancer is round robin.
2) To check the load balancer in action comment the exception line and uncomment the sysout 
in UppercaseMessageEnricher.
3) if failover="false" then the application will start trowing the exception.
and if it is true then all the request will forwarded to the running service.
<int:dispatcher failover="true" load-balancer="round-robin"></int:dispatcher>