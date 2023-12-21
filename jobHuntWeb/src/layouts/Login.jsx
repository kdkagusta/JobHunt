import React from "react";
import { Button, Form, Icon, Message } from "semantic-ui-react";

export default function Login() {
  return (
    <div>
      <Form.Group widths="equal" />

      <Message attached header="Fill in the required fields to login" />
      <Form className="attached fluid segment">
        <Form.Group widths="equal">
          <Form.Input fluid label="Email" placeholder="Email" type="text" />
        </Form.Group>

        <Form.Group widths="equal">
          <Form.Input
            fluid
            label="Password"
            placeholder="Password"
            type="text"
          />
        </Form.Group>
        <Button color="blue">Login</Button>
      </Form>

      <Message attached="bottom" warning>
        If you are not a member, &nbsp;<a href="#">Register here</a>
        &nbsp;instead.
      </Message>
    </div>
  );
}
