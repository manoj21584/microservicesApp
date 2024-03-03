import { useState } from "react";
import EmployeeComponent from "./service/components/EmployeeComponent";
import "./App.css";

function App() {
  const [count, setCount] = useState(0);

  return (
    <>
      <div className="container">
        <EmployeeComponent />
      </div>
    </>
  );
}

export default App;
