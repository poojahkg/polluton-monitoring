<<<<<< Pollution Monitoring >>>>>>>
________________________________________________________________________________________________________
#Technologies
Project is created with Arduino 1.6.12, Android Studio and Firebase.
________________________________________________________________________________________________________
#Description
Dynamically upload sensor values to firebase and view in it an android app (using android studio).
Find the least polluted route between two nodes.
________________________________________________________________________________________________________
#Setup

#For NodeMCU (Arduino software)

Sketch -> Include libraries -> Manage libraries -> Firebase Arduino version 0.1.0 -> install
Sketch -> Include libraries -> Manage libraries -> ArduinoJson by Benoit Blanchon -> select version 5.13.2 -> install

#For Android Studio

#Buildgrade - gradle:
	classpath 'com.google.gms:google-services:4.3.2' - under dependancies
#Buildgradle - app:
	apply plugin: 'com.google.gms.google-services'
	applicationId "com.example.pollutionappfinaltry" - your id
	Under dependencies:
		implementation fileTree(dir: 'libs', include: ['*.jar'])
    		implementation 'androidx.appcompat:appcompat:1.1.0'
    		implementation 'com.google.android.gms:play-services-maps:17.0.0'
    		implementation 'androidx.constraintlayout:constraintlayout:1.1.3'
    		implementation 'com.google.firebase:firebase-analytics:17.2.1'
    		implementation 'com.google.firebase:firebase-database:19.2.0'
    		implementation 'com.google.firebase:firebase-core:10.2.0'
    		implementation 'com.google.firebase:firebase-auth:10.2.0'
    		implementation 'com.google.maps.android:android-maps-utils:0.5+'
    		implementation 'com.google.android.gms:play-services-auth:17.0.0'
    		implementation 'com.google.maps:google-maps-services:0.1.20'
    		testImplementation 'junit:junit:4.12'
    		androidTestImplementation 'androidx.test:runner:1.2.0'
    		androidTestImplementation 'androidx.test.espresso:espresso-core:3.2.0'
________________________________________________________________________________________________________
#Files

mq135firebase.ino - Arduino file for gas sensor mq135
pollutionsensor.ino - Arduino file for pollution sensor
MapsActivity.java - Main java file for App
build.grade - for app and gradle
 
________________________________________________________________________________________________________
#How to run ?

#NodeMCU:
	Baud Rate for MCU is always 115200
	Select the COM port
	Upload the code
	Supply 12V supply after uploading

#Android Studio:
	In your phone, under developer options, enable USB Debugging
	Connect and run the android studio file.
________________________________________________________________________________________________________


 
