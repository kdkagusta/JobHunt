import React from "react";
import "../../App.css";
import { Grid, GridColumn } from "semantic-ui-react";
import { Route } from "react-router";
import Filter from "../../layouts/Filter.jsx";
import JobList from "../jobs/JobList";

export default function JobSeekerContent() {
  return (
    <div>
      <Grid>
        <Grid.Row>
          <GridColumn className="LeftMenu">
            <Route exact path="/" className="LeftMenu" component={Filter} />
          </GridColumn>
          <GridColumn width={12} className="jobsList">
            <Route exact path="/" component={JobList}></Route>
          </GridColumn>
        </Grid.Row>
      </Grid>
    </div>
  );
}
