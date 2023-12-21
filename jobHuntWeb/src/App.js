import "./App.css";
import DashBoard from "./layouts/dashboard/DashBoard";
import "semantic-ui-css/semantic.min.css";
import { Container } from "semantic-ui-react";
import Navi from "./layouts/navi/Navi";

function App() {
  return (
    <div className="App">
      <Navi />
      <Container className="main">
        <DashBoard />
      </Container>
    </div>
  );
}

export default App;
