# 🛠️ Installation Assignment and Technician Schedule Management System

---

This project implements a backend system designed to manage the **efficient assignment of installations** to a team of technicians and provide **real-time visibility into their schedules**. The primary goal is to optimize workload distribution, ensuring installations are assigned to available technicians based on a **workload balancing** approach while adhering to strict time and logistical constraints.

---

## 🎯 Core 

The system manages technician schedules, which are composed of time-based events. These events are stored in an array and can be of two types: `installation` or `travel`.

### Event Structure

The system handles two main event types:

| Event Type | Purpose | Key Constraint |
| :--- | :--- | :--- |
| **`installation`** | The time required for the installation itself. | Must not overlap with any existing event. |
| **`travel`** | The mandatory travel time following an installation. | Assumed to be **one (1) hour** and must always follow an `installation` event. |

**Example Event Object:**
```json
{
  "type": "installation",
  "installation_id": "bd351e0f-f2f8-4687-9008-b4184a855442",
  "start_time": "2025-05-19T10:00:00.000Z",
  "end_time": "2025-05-19T11:00:00.000Z"
}
