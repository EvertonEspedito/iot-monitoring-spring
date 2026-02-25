interface Props {
  title: string;
  value: string | number;
}

function DashboardCard({ title, value }: Props) {
  return (
    <div
      style={{
        border: "1px solid #ddd",
        borderRadius: "8px",
        padding: "1rem",
        minWidth: "180px",
      }}
    >
      <h4>{title}</h4>
      <strong style={{ fontSize: "1.5rem" }}>{value}</strong>
    </div>
  );
}

export default DashboardCard;