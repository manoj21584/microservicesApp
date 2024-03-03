import React from "react";

function DisplayDetails({ employee }) {
  return (
    <div>
      <h2>{employee.firstName}</h2>
    </div>
  );
}

export default DisplayDetails;
