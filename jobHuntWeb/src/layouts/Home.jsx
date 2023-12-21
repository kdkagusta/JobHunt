import React from "react";
import { Container, Divider, Header } from "semantic-ui-react";

export default function Menu() {
  return (
    <div>
      <Container>
        <Header as="h2">HRMS</Header>
        <p></p>
        <Header as="h3">
          Welcome to our job search site. To get information about our site,
          please read the following information.
        </Header>
        <Divider />
        <p>
          Here you can find a job by looking at job postings, share your CV,
          look for job postings or CVs of job seekers to look for workers.
        </p>
        <p>
          And also, don't miss it if you haven't joined the JAVA/REACT camp made
          by Engin Demiroğ It is recommended. He was one of the best and most
          beautiful teachers in the world :).
        </p>
      </Container>
    </div>
  );
}
