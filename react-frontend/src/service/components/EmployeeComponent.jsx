import React, { useState, useEffect } from "react";
import DisplayDetails from "./DisplayDetails";
const EMPLOYEE_BASE_URL = "http://localhost:9191/api/employees/";
const EMPLOYEE_ID = 2;
function EmployeeComponent() {
  const [employee, setEmployee] = useState({});
  const [department, setDepartment] = useState({});
  const [organization, setOrganization] = useState({});

  useEffect(() => {
    fetch(EMPLOYEE_BASE_URL + "/" + EMPLOYEE_ID)
      .then((response) => response.json())
      .then((data) => {
        setEmployee(data.employee);
        setDepartment(data.department);
        setOrganization(data.organisation);

        console.log(data.employee);
        console.log(data.department);
        console.log(data.organisation);
      })
      .catch((error) => console.error("Error fetching data:", error));
  }, []);

  return (
    <div>
      <br />
      <br />
      <div className="card col-md-6 offset-md-3">
        <h3 className="text-center card-header"> View Employee Details</h3>
        <div className="card-body">
          <div className="row">
            <p>
              <strong>Employee First Name: </strong> {employee.firstName}
            </p>
          </div>
          <div className="row">
            <p>
              <strong>Employee Last Name: </strong> {employee.lastName}
            </p>
          </div>
          <div className="row">
            <p>
              <strong>Employee Email: </strong> {employee.email}
            </p>
          </div>
        </div>
        <h3 className="text-center card-header"> View Department Details</h3>
        <div className="card-body">
          <div className="row">
            <p>
              <strong>Department Name: </strong> {department.departmentName}
            </p>
          </div>
          <div className="row">
            <p>
              <strong>Department Description: </strong>{" "}
              {department.departmentDescription}
            </p>
          </div>
          <div className="row">
            <p>
              <strong>Department code: </strong> {department.departmentCode}
            </p>
          </div>
        </div>
        <h3 className="text-center card-header"> View Organization Details</h3>
        <div className="card-body">
          <div className="row">
            <p>
              <strong> Organization Name: </strong>{" "}
              {organization.organisationName}
            </p>
          </div>
          <div className="row">
            <p>
              <strong> Organization Description: </strong>{" "}
              {organization.organisationDescription}
            </p>
          </div>
          <div className="row">
            <p>
              <strong> Organization Code: </strong>{" "}
              {organization.organisationCode}
            </p>
          </div>
        </div>
      </div>
    </div>
  );
}

export default EmployeeComponent;
