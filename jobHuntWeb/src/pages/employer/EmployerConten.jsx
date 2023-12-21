import React from "react";
import "../../App.css";
import { Grid, GridColumn } from "semantic-ui-react";
import { Route } from "react-router";
import Filter from "../../layouts/Filter.jsx";

export default function EmployersContent() {
  return (
    <div>
      <Grid>
        <Grid.Row>
          <GridColumn className="LeftMenu">
            <Route
              exact
              path="/pages/EmployersContent.jsx"
              className="LeftMenu"
              component={Filter}
            />
          </GridColumn>
          <Route exact path="/pages/EmployersContent.jsx"></Route>
        </Grid.Row>
      </Grid>
    </div>
  );
}
//  component={}
