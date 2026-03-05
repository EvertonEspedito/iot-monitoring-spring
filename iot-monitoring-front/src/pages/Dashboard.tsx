import { useEffect, useState } from "react";
import { getDashboardSummary } from "../api/dashboard";
import type { DashboardSummary } from "../types/DashboardSummary";

import "../styles/dashboard.css";

const TEMPERATURE_LIMIT = 30;

export default function Dashboard() {
  const [summary, setSummary] = useState<DashboardSummary | null>(null);

  useEffect(() => {
    getDashboardSummary()
      .then(setSummary)
      .catch((err) =>
        console.error("Erro ao carregar dashboard", err)
      );
  }, []);

  if (!summary) {
    return <p>Carregando dados...</p>;
  }

  return (
    <div style={{ padding: "24px" }}>
      <h1>📊 Dashboard IoT</h1>

      <div style={{ display: "flex", gap: "16px", marginTop: "20px" }}>
        <div className="card">
          <h3>Total de Leituras</h3>
          <p>{summary.totalReadings}</p>
        </div>

        <div
          className={`card ${
            summary.avgTemperature > TEMPERATURE_LIMIT ? "alert" : ""
          }`}
        >
          <h3>Temperatura Média</h3>
          <p>{summary.avgTemperature.toFixed(1)} °C</p>

          {summary.avgTemperature > TEMPERATURE_LIMIT && (
            <span className="warning-text">
              ⚠ Temperatura acima do limite!
            </span>
          )}
        </div>

        <div className="card">
          <h3>Temperatura Máx</h3>
          <p>{summary.maxTemperature.toFixed(1)} °C</p>
        </div>

        <div className="card">
          <h3>Temperatura Mín</h3>
          <p>{summary.minTemperature.toFixed(1)} °C</p>
        </div>

        <div className="card">
          <h3>Umidade Média</h3>
          <p>{summary.avgHumidity.toFixed(1)} %</p>
        </div>
      </div>
    </div>
  );
}