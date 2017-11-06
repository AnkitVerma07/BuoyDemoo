# BuoyDemoo

Hey Github users,

This is very small neat demo that accomplishes reading a RSS feader, saving the information in an organizsed DB, and making a get call to the fornt end.
Project also inserts, updates, get data from DB for all the entities and lets a user add an item as favorite.

The stack I am using in this web application project is something I am very experienced with now;

Front end: html5, css, javascript, react.js, axios, xmlreader etc..

back end: java, restful services, hibernate

database: postgresSQL

For running on your local machine,

1. please clone the drive onto your favorite IDE (eclipse for that matter). 

2. Do a clean maven build to get all the jar files needed.

3. make sure to have tomcat9 running on your machine.

4. go ahead and download java-servelet.jar (you can find that in the github project space as well).

5. in the buoy_fe folder that being our main FE component, go ahead do a npm install in terminal; this will downlaod all the FE needed componenets of react.

6. run npm run production to compline all the libraries in node module and build package.json.

7. run npm run start (only to test and run the fe application).

8. make sure to install and set up pstgresSQL. good thing is hibernate creates all the databases for us however you do need to change the hibernate.cfg.xml file to point to your local DB by editing the property tags, also need to change update to create in order to freshly create DB talbes and then change back to update in order to keep your data save while local production run.  

9. in ecipse or any given IDE right click and just run the application on server (tomcat 9).
# BuoyDemoo
