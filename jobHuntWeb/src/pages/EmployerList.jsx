import React, { useEffect, useState } from "react";
import { Table } from "semantic-ui-react";
import EmployerService from "../services/EmployerService";

export default function EmployerList() {
  const [employerList, setEmployerList] = useState([]);
  console.log(employerList);

  useEffect(() => {
    let employerService = new EmployerService();
    employerService.getEmployers().then((result) => {
      setEmployerList(result.data.data);
    });
  }, []);

  return (
    <div>
      <Table singleLine>
        <Table.Header>
          <Table.Row>
            <Table.HeaderCell>Company Name</Table.HeaderCell>
            <Table.HeaderCell>Web Site</Table.HeaderCell>
            <Table.HeaderCell>Phone Number</Table.HeaderCell>
            <Table.HeaderCell>Email</Table.HeaderCell>
          </Table.Row>
        </Table.Header>

        <Table.Body>
          {employerList.map((employer) => (
            <Table.Row>
              <Table.Cell>{employer.companyName}</Table.Cell>
              <Table.Cell>{employer.employerWebSite}</Table.Cell>
              <Table.Cell>{employer.employerPhoneNumber}</Table.Cell>
              <Table.Cell>{employer.employerEmail}</Table.Cell>
            </Table.Row>
          ))}
        </Table.Body>
      </Table>
    </div>
  );
}
