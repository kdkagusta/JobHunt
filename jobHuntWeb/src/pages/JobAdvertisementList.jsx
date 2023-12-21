import React, { useState, useEffect } from "react";
import { Table } from "semantic-ui-react";
import JobAdvertisementService from "../services/jobAdvertisementService";

export default function JobAdvertisementList() {
  const [jobAdvertisementList, setJobAdvertisementList] = useState([]);
  console.log(jobAdvertisementList);

  useEffect(() => {
    let jobAdvertisementService = new JobAdvertisementService();
    jobAdvertisementService.getByIsActive().then((result) => {
      setJobAdvertisementList(result.data);
    });
  }, []);

  return (
    <div>
      <Table striped>
        <Table.Header>
          <Table.Row>
            <Table.HeaderCell>Description</Table.HeaderCell>
            <Table.HeaderCell>Position Caount</Table.HeaderCell>
            <Table.HeaderCell>Min Salary / Max Salary</Table.HeaderCell>
            <Table.HeaderCell>Application Deadline</Table.HeaderCell>
            <Table.HeaderCell>Examine</Table.HeaderCell>
          </Table.Row>
        </Table.Header>

        <Table.Body>
          {jobAdvertisementList.map((jobAdvertisement) => (
            <Table.Row key={jobAdvertisement.id}>
              <Table.Cell>{jobAdvertisement.jobDescription}</Table.Cell>
              <Table.Cell>{jobAdvertisement.positionCaount}</Table.Cell>
              <Table.Cell>{jobAdvertisement.minSalary}</Table.Cell>
              <Table.Cell>{jobAdvertisement.jobApplicationDeadline}</Table.Cell>
              <Table.Cell>
                {jobAdvertisement.isOpened ? "Opened" : "Not Opened"}
              </Table.Cell>
            </Table.Row>
          ))}
        </Table.Body>
      </Table>
    </div>
  );
}
