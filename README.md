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
## Preview
<table>
  <tr>
    <td><img src="https://user-images.githubusercontent.com/112768196/192103658-b405ed4f-3184-48be-b81b-233400159835.png" alt="Your image title" width="250" height="100"/></td>
    <td><img src="https://user-images.githubusercontent.com/112768196/192103737-59029501-33f2-4f20-86c6-05c585a1fba0.png" alt="Your image title" width="250" height="100"/></td>
    <td><img src="https://user-images.githubusercontent.com/112768196/192103770-7d83c4e8-a6c4-4fa8-9f47-8470024acd30.png" alt="Your image title" width="250" height="100"/></td>
  </tr>
  <tr>
    <td><img src="https://user-images.githubusercontent.com/112768196/192103783-9e5cc218-5a5d-4813-b4ce-b588d433820c.png" alt="Your image title" width="250" height="100"/></td>
    <td><img src="https://user-images.githubusercontent.com/112768196/192103819-87dc1f58-ad40-4efc-af14-e733df66e51b.png" alt="Your image title" width="250" height="100"/></td>
    <td><img src="https://user-images.githubusercontent.com/112768196/192103840-a270c3f0-193e-40ba-94f0-a5e00762bd77.png" alt="Your image title" width="250" height="100"/></td>
  </tr>
  <tr>
    <td><img src="https://user-images.githubusercontent.com/112768196/192103850-19237719-c2e3-46d2-b183-0c2f00017769.png" alt="Your image title" width="250" height="100"/></td>
    <td><img src="https://user-images.githubusercontent.com/112768196/192103968-77e98d55-8ebe-4ae3-9342-08b184570c42.png" alt="Your image title" width="250" height="100"/></td>
    <td><img src="https://user-images.githubusercontent.com/112768196/192104567-cb8cdc22-324f-496d-bd22-52884b4d631a.png" alt="Your image title" width="250" height="100"/></td>
  </tr>
</table>

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
For sample purpose, h2 database(local database) is integrated with the application so that application can run for any user.<br>
If user want to change the database, they can make relevant changes in "application.properties" file.<br>
Also, some data is pre-populated for sample purpose which can be deleted from "data.sql" file.<br>
## Sample data
* All are below information are for sample purpose.
* Three bus have already been registered. (BUSID - ABC1 , ABC2 , ABC3)
* Trips is also been scheduled for BUSID - ABC1 and ABC2 on 1st January,2025 from Jammu to Amritsar (Stoppages - Jammu -> Katra -> Amritsar).
* Some seats are already booked for representation purpose.<br>
This is enough for sample purpose.
## Application Navigation
* Bus details can be viewed by searching BUSID's.
* New bus can be registered from Bus Registration Tab.
* Customer can book seats from Customer Seat Booking Tab. Try entering Start Location as "Jammu" and End Location as "Amritsar" and Departure Date as "1st January,2025" to see the results. Choose bus and book seats.
* New Trips can be scheduled for registered bus. (Search a bus and click on bus scheduling)
* Booking details for scheduled trips/completed trips can be downloaded in the form of pdfs.(Search a bus and click on scheduled trips and then,click on View pdf)
* Try to experiment as you want to. Everthing is validated for the best performance of the user!!.
