#include <OneWire.h>
#include <DallasTemperature.h>
#include <LiquidCrystal.h>

#define oneWireBus 2
#define rele 3

LiquidCrystal lcd(8, 9, 4, 5, 6, 7);

float temperatura = 0;
int tempMax = 45;
int tempMin = 35;

OneWire oneWire(oneWireBus);
DallasTemperature sensorTemp(&oneWire);

void setup() {
  sensorTemp.begin();
  lcd.begin(16, 2);
  Serial.begin(9600);
  pinMode(rele, OUTPUT);
  digitalWrite(rele, LOW);  // Certificar que o relé começa desligado
}

void loop() {
  sensorTemp.requestTemperatures();
  temperatura = sensorTemp.getTempCByIndex(0);
  alternarLuz();
  runLCD();
  delay(30000);
}

void alternarLuz() {
  if (temperatura < tempMin) {
    digitalWrite(rele, LOW);  // Liga o relé
  } else if (temperatura > tempMax) {
    digitalWrite(rele, HIGH);  // Desliga o relé
  }
}

void runLCD() {
  lcd.clear();
  lcd.setCursor(0, 0);
  lcd.print("Temperatura");
  lcd.setCursor(12, 0);
  lcd.print(temperatura);
  lcd.setCursor(0, 1);
  if (digitalRead(rele) == LOW) {
    lcd.print("Rele: Ligado");
  } else {
    lcd.print("Rele: Desligado");
  }
}
