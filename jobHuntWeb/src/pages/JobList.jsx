import React, { useEffect, useState } from "react";
import { Table } from "semantic-ui-react";
import JobService from "../services/jobService";

export default function JobList() {
  const [jobs, setJobs] = useState([]);

  useEffect(() => {
    let jobService = new JobService();
    jobService.getJobs().then((result) => {
      setJobs(result.data.data);
    });
  }, []);

  return (
    <div>
      <Table singleLine>
        <Table.Header>
          <Table.Row>
            <Table.HeaderCell>Explanation</Table.HeaderCell>
            <Table.HeaderCell>Job Positions</Table.HeaderCell>
          </Table.Row>
        </Table.Header>

        <Table.Body>
          {jobs.map((jobs) => (
            <Table.Row key={jobs.id}>
              <Table.Cell>{jobs.explanation}</Table.Cell>
              <Table.Cell>{jobs.positions}</Table.Cell>
            </Table.Row>
          ))}
        </Table.Body>
      </Table>
    </div>
  );
}
