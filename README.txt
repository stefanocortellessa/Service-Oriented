APPLICATION BACKEND SETUP:

1) download or clone source from https://github.com/stefanocortellessa/Service-Oriented
2) import in Eclipse each directory under Service-Oriented/guidApp_backend/ (es: accountManager, provider, ...) as existing project
3) create guidApp db on MySQL (port 3306 user=root, password=root)
4) populate guidApp db importing the the file dump.sql in MySQL
5) deploy projects on servers in the following way:
	- Tomcat 8.5.3 port 8080 -> prosumer; loadBalancer
	- Tomcat 8.5.3 port 8100, port 8110, port 8120 -> accountManager; researchManager; eventManager; attractionManager; balanceAgent;
6) run servers in the following order:
	- Tomcat 8.5.3 port 8100, port 8110, port 8120
	- Tomcat 8.5.3 port 8080;
7) run researchManager as Java Application (port 8090)


