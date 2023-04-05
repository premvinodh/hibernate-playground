# hibernate
<!-- 
	https://docs.github.com/en/github/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax#hiding-content-with-comments 
	https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet#tables
-->

Contains the legacy hibernate code which uses the hibernate.cfg.xml file.  
&emsp;All the examples uses mostly the same classes but placed in different packages.  
&emsp;Just uncomment the classes of the package that needs to be executed and commented out the remaining classes in hibernate.cfg.xml file.  
&emsp;Run the HibernateTest class.  
	
Apache Derby 
-----------------------------------	
1. Download the Apache Derby from url: https://db.apache.org/derby/derby_downloads.html  
   &nbsp;Select the version to download based on your JDK version.  
   &emsp;Mine is JDK 11 so downloaded version 10.15.2.0 --> db-derby-10.15.2.0-bin.zip  (As this need not be installed)  

2. Unzip the db-derby-10.15.2.0-bin.zip to its own folder

3. Navigate to the bin folder  
   &nbsp;Start the server --> By running the startNetworkServer.bat on windows or startNetworkServer on linux  
   &nbsp;Start the client --> By running the ij.bat on windows and ij on linux

4. Connect to the db using the command  
   &nbsp;connect ’jdbc:derby://localhost:1527/db;create=true’;  
   &nbsp;show tables; -- list all the tables  

Commits and their associated topics 
-----------------------------------
Refer the section below on how to [get a specific commit(https://github.com/premvinodh/microservices#how-to-get-certain-commit-from-github-project)].

| Sl.No		| Topic                                       				| Commit Hash           								|
|:---------:|-----------------------------------------------------------|:-----------------------------------------------------:|
| 	1.		| Initial Project files commit								| 968e29b8750cc6f47b27db65e87d732ad3d50019				|
| 	2.		| First Entity												| 6a7391b1f74fcc05a349943bf00a339f24c1bf48				|
| 	3.		| Fetch Data from DB										| fb8f552cc4eb60f1f9dcb0e67486e9cdf9789aea				|
| 	4.		| Id Generated												| 785b7c694edd52c4f9108b1046d4cbfab9d4a7aa				|
| 	5.		| Value Types (@Embeddable and @Embedded)					| 3a180b9866b2c816119cfa36f06c8fd7dce37fa2				|
| 	6.		| @ElementCollection										| 21204e89f54afedc9623594377a0cd0840775554				|
| 	7.		| @ElementCollection - Custom Table name					| d2cd05203230333b97b1e305e2d902f8282261ac				|
| 	8.		| Associations - One to One Mapping 						| 9b361b8f2f410cd48ddd9de2a5a1e31a96f11d22				|
| 	9.		| Associations - One to Many Mapping 						| 90368f71b72c437035546ebf57f911d329561873				|
| 	10.		| Associations - One to Many Mapping - @JoinTable			| 27d2d28d22aeed3abf1bcdbfe76262912a7d673c				|
| 	11.		| Associations - Many to One Mapping						| e21979240f442334fcd7da9a8672af4a7252d9fa				|


### How to get certain commit from GitHub project
------------------------------------------------
1. First, clone the repository using git as shown below
git clone https://github.com/premvinodh/hibernate-playground
That downloads the complete history of the repository, so you can switch to any version. Next, change into the newly cloned repository:

2. cd <complete_path_on_your_system>\hibernate-playground

3. Use git checkout <COMMIT> to change to the right commit of a particular topic
git checkout 968e29b8750cc6f47b27db65e87d732ad3d50019
