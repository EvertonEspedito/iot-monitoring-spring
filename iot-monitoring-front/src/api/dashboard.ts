import axios from "axios";
import type { DashboardSummary } from "../types/DashboardSummary";

const API_URL = "http://localhost:8081";

export async function getDashboardSummary(): Promise<DashboardSummary> {
  const response = await axios.get<DashboardSummary>(
    `${API_URL}/dashboard/summary`
  );
  return response.data;
}