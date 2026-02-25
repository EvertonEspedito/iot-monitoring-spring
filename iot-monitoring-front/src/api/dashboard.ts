import { api } from "./api";
import { DashboardSummary } from "../types/DashboardSummary";

export async function getDashboardSummary(): Promise<DashboardSummary> {
  const response = await api.get<DashboardSummary>("/dashboard/summary");
  return response.data;
}