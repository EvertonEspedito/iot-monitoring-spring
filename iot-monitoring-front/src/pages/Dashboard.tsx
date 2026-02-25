import { useEffect, useState } from "react";
import { getDashboardSummary } from "../api/dashboard";
import { DashboardSummary } from "../types/DashboardSummary";
import DashboardCard from "../components/DashboardCard";

function Dashboard() {
  const [summary, setSummary] = useState<DashboardSummary | null>(null);

  useEffect(() => {
    getDashboardSummary()
      .then(setSummary)
      .catch((err) => console.error("Erro ao carregar dashboard", err));
  }, []);

  if (!summary) {
    return <p>Carregando dados...</p>;
  }

  return (
    <div>
      <h2>Dashboard</h2>

      <div style={{ display: "flex", gap: "1rem", marginTop: "1rem" }}>
        <DashboardCard
          title="Temperatura Média (°C)"
          value={summary.avgTemperature.toFixed(1)}
        />
        <DashboardCard
          title="Umidade Média (%)"
          value={summary.avgHumidity.toFixed(1)}
        />
        <DashboardCard
          title="Total de Leituras"
          value={summary.totalReadings}
        />
        <DashboardCard
          title="Último Dispositivo"
          value={summary.lastDeviceId}
        />
      </div>
    </div>
  );
}

export default Dashboard;