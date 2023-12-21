import React, { useEffect, useState } from "react";
import { Icon, Menu, Table } from "semantic-ui-react";
import JobSeekerService from "../../services/jobSeekerService";

export default function JobSeekerList() {
  const [jobSeekers, setJobSeeker] = useState([]);
  useEffect(() => {
    let jobSeekerService = new JobSeekerService();
    jobSeekerService
      .getJobSeekers()
      .then((result) => setJobSeeker(result.data.data));
  });

  return (
    <div>
      <Table celled>
        <Table.Header>
          <Table.Row>
            <Table.HeaderCell>First Name</Table.HeaderCell>
            <Table.HeaderCell>Last Name</Table.HeaderCell>
            <Table.HeaderCell>Identity Number</Table.HeaderCell>
            <Table.HeaderCell>Birt Day</Table.HeaderCell>
            <Table.HeaderCell>E-Mail</Table.HeaderCell>
          </Table.Row>
        </Table.Header>
        <Table.Body>
          {jobSeekers.map((jobseeker) => (
            <Table.Row key={jobseeker.id}>
              <Table.Cell>{jobseeker.firstName}</Table.Cell>
              <Table.Cell>{jobseeker.lastName}</Table.Cell>
              <Table.Cell>{jobseeker.identityNumber}</Table.Cell>
              <Table.Cell>{jobseeker.birthday}</Table.Cell>
              <Table.Cell>{jobseeker.mail}</Table.Cell>
            </Table.Row>
          ))}
        </Table.Body>
        <Table.Footer>
          <Table.HeaderCell colspan="5">
            <Menu floated="right" pagination>
              <Menu.Item as="a" icon>
                <Icon name="chevron left" />
              </Menu.Item>
              <Menu.Item as="a">1</Menu.Item>
              <Menu.Item as="a">2</Menu.Item>
              <Menu.Item as="a">3</Menu.Item>
              <Menu.Item as="a">4</Menu.Item>
              <Menu.Item as="a">5</Menu.Item>
              <Menu.Item as="a" icon>
                <Icon name="chevron right" />
              </Menu.Item>
            </Menu>
          </Table.HeaderCell>
        </Table.Footer>
      </Table>
    </div>
  );
}
