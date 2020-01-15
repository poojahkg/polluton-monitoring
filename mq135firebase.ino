#include <ESP8266WiFi.h>
#include <FirebaseArduino.h>

// Set these to run example.
#define FIREBASE_HOST "pollutionappfinaltry.firebaseio.com"
#define FIREBASE_AUTH "nXngWkXaavpQsLvawqa3ptAzhozPguhrdgwLc5DE"
#define WIFI_SSID "One Plus 6"
#define WIFI_PASSWORD "Poojah55"
#define outputpin A0
#define supp D1

int s1;
void setup() {
  Serial.begin(115200);

  // connect to wifi.
  WiFi.begin(WIFI_SSID, WIFI_PASSWORD);
  Serial.print("connecting");
  while (WiFi.status() != WL_CONNECTED) {
    Serial.print(".");
    delay(500);
  }
  Serial.println();
  Serial.print("connected: ");
  Serial.println(WiFi.localIP());
  
  Firebase.begin(FIREBASE_HOST, FIREBASE_AUTH);
}

void loop() {
  digitalWrite(supp,HIGH); 
  int s1 = analogRead(outputpin);
    Serial.print("Air Quality: ");
    Serial.println(s1, DEC);
    delay(4000);
    Firebase.setInt("IIT M, Research Park", s1);
}
