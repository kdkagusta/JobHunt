import React, { useEffect, useState } from "react";
import { Table } from "semantic-ui-react";
import JobSeekerService from "../services/jobSeekerService";

export default function JobSeekerList() {
  const [jobSeekers, setJobSeekers] = useState([]);
  console.log(jobSeekers);

  useEffect(() => {
    let jobSeekerService = new JobSeekerService();
    jobSeekerService.getJobSeekers().then((result) => {
      setJobSeekers(result.data.data);
    });
  }, []);

  return (
    <div>
      <Table singleLine>
        <Table.Header>
          <Table.Row>
            <Table.HeaderCell>First Name</Table.HeaderCell>
            <Table.HeaderCell>Last Name</Table.HeaderCell>
            <Table.HeaderCell>Email</Table.HeaderCell>
            <Table.HeaderCell>National Identity</Table.HeaderCell>
            <Table.HeaderCell>Years Of Birth</Table.HeaderCell>
          </Table.Row>
        </Table.Header>

        <Table.Body>
          {jobSeekers.map((jobSeeker) => {
            <Table.Row>
              <Table.Cell>{jobSeeker.firstName}</Table.Cell>
              <Table.Cell>{jobSeeker.lastName}</Table.Cell>
              <Table.Cell>{jobSeeker.userEmail}</Table.Cell>
              <Table.Cell>{jobSeeker.nationalIdentity}</Table.Cell>
              <Table.Cell>{jobSeeker.yearsOfBirth}</Table.Cell>
            </Table.Row>;
          })}
        </Table.Body>
      </Table>
    </div>
  );
}
