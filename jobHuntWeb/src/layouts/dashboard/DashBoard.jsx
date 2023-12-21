import React from "react";
import { Grid } from "semantic-ui-react";
import { Route } from "react-router";
import EmployerList from "../../pages/EmployerList";
import JobAdvertisementList from "../../pages/JobAdvertisementList";
import JobList from "../../pages/JobList";
import JobSeekerList from "../../pages/JobSeekerList";
import Record from "../../layouts/Record";
import Login from "../../layouts/Login";
import Home from "../../layouts/Home";
import LeftBar from "../LeftBar";

export default function DashBoard() {
  return (
    <div>
      <Grid>
        <Grid.Row>
          <Grid.Column width={2}>
            <LeftBar />
          </Grid.Column>
          <Grid.Column width={14}>
            <Route exact path="/record" component={Record} />
            <Route exact path="/login" component={Login} />
            <Route exact path="/home" component={Home} />
            <Route exact path="/employerListed" component={EmployerList} />
            <Route
              exact
              path="/jobAdvertisementListed"
              component={JobAdvertisementList}
            />
            <Route exact path="/jobsListed" component={JobList} />
            <Route exact path="/jobSeekerListed" component={JobSeekerList} />
          </Grid.Column>
        </Grid.Row>
      </Grid>
    </div>
  );
}
