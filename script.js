const API_URL = "http://127.0.0.1:1872/api/v1/employee/";

// Fetch employees and display them in the table
function fetchEmployees() {
  fetch(API_URL)
    .then(response => response.json())
    .then(data => {
      const employeeTable = document.getElementById("employeeTable");
      employeeTable.innerHTML = ""; // Clear previous table rows
      data.forEach(employee => {
        const row = document.createElement("tr");
        row.innerHTML = `
          <td>${employee.employeeid || "N/A"}</td>
          <td>${employee.employeename || "N/A"}</td>
          <td>${employee.email}</td>
          <td>
            <button onclick="deleteEmployee(${employee.employeeid})">Delete</button>
          </td>
        `;
        employeeTable.appendChild(row);
      });
    })
    .catch(error => console.error("Error fetching employees:", error));
}

// Add new employee
document.getElementById("employeeForm").addEventListener("submit", function (e) {
  e.preventDefault();

  const employee = {
    employeename: document.getElementById("name").value, // Match property names
    email: document.getElementById("email").value,
    password: document.getElementById("password").value
  };

  fetch(API_URL, {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(employee)
  })
    .then(response => {
      if (!response.ok) {
        throw new Error("Failed to add employee");
      }
      return response.json();
    })
    .then(() => {
      alert("Employee added successfully!");
      fetchEmployees(); // Refresh the employee list
    })
    .catch(error => console.error("Error adding employee:", error));
});

// Delete employee by ID
function deleteEmployee(id) {
  if (confirm("Are you sure you want to delete this employee?")) {
    fetch(API_URL + id, {
      method: "DELETE"
    })
      .then(() => {
        alert("Employee deleted successfully!");
        fetchEmployees(); // Refresh the employee list
      })
      .catch(error => console.error("Error deleting employee:", error));
  }
}

// Initial fetch of employees when the page loads
window.onload = fetchEmployees;
