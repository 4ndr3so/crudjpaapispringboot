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
Business Rules
Availability Check: A new installation assignment (including its required 1-hour travel event) must not overlap with any already scheduled events for the technician.

Workload Balancing: The system should, where possible, assign work to technicians of a balanced workload.

Working Hours: All technicians are assumed to work from 8am to 6pm, Colombia time.

No Assignment Policy: If no technicians are available to handle an installation, the system should simply not assign a technician.

💻 API Reference
The backend provides three main endpoints for managing assignments and viewing schedules.

1. Assign an Installation
Receives an installation request, checks technician availability, and assigns the work to the most suitable technician.

POST /api/v1/installation_assignments

Parameter	Type	Description	Example
installation_id	String	ID of the installation to be assigned.	"bd351e0f-f2f8-4687-9008-64184a855442"
start_time	String (ISO 8601)	Start time of the installation.	"2025-05-19T10:00:00.000Z"
end_time	String (ISO 8601)	End time of the installation.	"2025-05-19T11:30:00.000Z"

Export to Sheets
Success Response (201 Created)

JSON

{
  "message": "Installation assigned successfully",
  "technician_id": "1234567890",
  "installation_id": "bd351e0f-f2f8-4687-9008-b4184a855442"
}
Error Response (4xx)

JSON

{
  "message": "Installation not assigned",
  "error": "Technicians are not available to assign the installation"
}
2. Retrieve a Technician's Schedule
Fetches the complete chronological calendar of events (installations and travel) for a single specified technician.

GET /api/v1/technicians/:technician_id/schedule

Success Response (200 OK)

JSON

{
  "events": [
    {
      "type": "installation",
      "installation_id": "bd351e0f-f2f8-4687-9008-64184a855442",
      "start_time": "2025-05-19T10:00:00.000Z",
      "end_time": "2025-05-19T11:00:00.000Z"
    },
    {
      "type": "travel",
      "installation_id": "null",
      "start_time": "2025-05-19T11:00:00.000Z",
      "end_time": "2025-05-19T12:00:00.000Z"
    }
  ]
}
3. Retrieve Multiple Technicians' Schedules
Fetches the calendars for a list of technicians identified by their IDs in the query parameters.

GET /api/v1/technicians/schedules?ids[]={id1}&ids[]={id2}

Success Response (200 OK)

JSON

[
  {
    "name": "Juan Perez",
    "id": "1",
    "events": [
      // ... events for Juan Perez
    ]
  },
  {
    "name": "Ana Luisa Martinez",
    "id": "2",
    "events": [
      // ... events for Ana Luisa Martinez
    ]
  }
]
