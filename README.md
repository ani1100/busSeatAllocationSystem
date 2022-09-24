# Bus Seat Allocation System
## About
The Software system is an online seat booking as well as bus reservation system where buses can be registered, trips can be scheduled and booking details for a scheduled trip can be downloaded in the form of pdf. Also, customers can book seats according to their preference.<br>
## Technologies Used
* SpringBoot
* Java
* PostgreSQL
* AngularJS
* Git
* HTML
* CSS
* Javascript
* Bootstrap
## Features
* Bus can be registered with their bus structure and stoppage details.
* Bus can have multiple stoppages.
* Registered bus can view their details. 
* Registered bus can schedule future trips.
* Registered bus can download pdf for future/completed/on-going trips which contains booking deatils for every seat.
* Customer can book seats on selected date. On entering a date with their departure and arrival points, a list of buses scheduled will be available and the customer can choose bus and seats according to their preference.
* System is validated for smooth functioning.
## How To Use
##### Software needed to run the application
Eclipse or Spring Tool Suite(STS).
##### How to Extract Files
Files can be extracted in two ways.
1. Download ZIP File
   * Download ZIP File from Code -> Download ZIP
   * After download is completed, extract files
   * Start Eclipse/Spring Boot by choosing a workplace. Import project (Import -> Maven ->Existing Maven Projects ->Choose Root Directory) and click on finish. Project will be imported.
   * Click on portal -> src/main/java -> .com.aniket.portal -> Right click on PortalApplication.java -> Run as Java Application (Or search for PortalApplication.java and run that as java application)
   * Application will be launched on localhost. [http://localhost:8080/home]
2. Clone Git Repository
   * Use URL - https://github.com/ani1100/busSeatAllocationSystem.git for cloning.
   * Start Eclipse/Spring Boot by choosing a workplace. Go to GIT Perspective -> Clone a Git Repository -> Paste the URL for cloning -> Click on Next -> Click on Finish on next pop up. 
   * After this, a local git repository will be created. Right Click on busSeatAllocationSystem -> Select import projects -> Click on Finish. Project will be imported.
   * Go to Java Perspective , Click on portal -> src/main/java -> .com.aniket.portal -> Right click on PortalApplication.java -> Run as Java Application (Or search for PortalApplication.java and run that as java application)
   * Application will be launched on localhost. [http://localhost:8080/home]
## Database 
For sample purpose, h2 database(local database) is integrated with the application so that application can run for any user.
If user want to change the database, they can make relevant changes in "application.properties" file.
Also, some data is pre-populated for sample purpose which can be deleted from "data.sql" file.


Three buses are already registered for demo purpose.<br>
BUS ID's - <br>
ABC1 - (Jammmu -> Katra -> Amritsar)<br>
ABC2 - (Jammmu -> Katra -> Amritsar)<br>
ABC3 - (Kolkata -> Digha)<br>
Bus details can be viewed by searching bus id's. New buses can also be registered from Bus Registration Screen. <br>
Have already scheduled trips for ABC1 and ABC2 on 1st January,2025 from Jammu to Amritsar. New Trips can also be scheduled for every bus and also booking details for scheduled trips can be downloaded in the form of pdfs. <br>
Customer can book seats according to their preference from Customer Seat Booking screen. Enter departure location as "Jammu", arrival location as "Amritsar" and departure date as "1st January,2025" and book seats as you want to. <br>
Try to experiment as you want to. Everthing is validated !!.
