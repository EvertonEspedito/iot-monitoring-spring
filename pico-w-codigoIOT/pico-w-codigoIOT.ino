#include <WiFi.h>
#include <HTTPClient.h>

// ===== WIFI =====
const char* ssid = "DEUS E AMOR";
const char* password = "20304060";

// ===== SERVIDOR =====
const char* serverUrl = "http://192.168.0.106:8081/api/readings";

void setup() {
  Serial.begin(115200);
  delay(2000);

  Serial.println("Conectando ao WiFi...");
  WiFi.begin(ssid, password);

  while (WiFi.status() != WL_CONNECTED) {
    delay(1000);
    Serial.println("Conectando...");
  }

  Serial.println("WiFi conectado!");
  Serial.print("IP do Pico: ");
  Serial.println(WiFi.localIP());
}

void loop() {

  if (WiFi.status() == WL_CONNECTED) {

    HTTPClient http;
    http.begin(serverUrl);
    http.addHeader("Content-Type", "application/json");

    // ===== DADOS SIMULADOS =====
    float temperature = random(250, 350) / 10.0;  // 25.0 a 35.0
    float humidity = random(400, 800) / 10.0;     // 40.0 a 80.0

    String json = "{";
    json += "\"temperature\":" + String(temperature) + ",";
    json += "\"humidity\":" + String(humidity) + ",";
    json += "\"deviceId\":\"pico-w-01\"";
    json += "}";

    Serial.println("Enviando JSON:");
    Serial.println(json);

    int httpResponseCode = http.POST(json);

    Serial.print("Código HTTP: ");
    Serial.println(httpResponseCode);

    if (httpResponseCode > 0) {
      String response = http.getString();
      Serial.println("Resposta:");
      Serial.println(response);
    } else {
      Serial.println("Erro na requisição");
    }

    http.end();
  }

  delay(10000); // envia a cada 10 segundos
}