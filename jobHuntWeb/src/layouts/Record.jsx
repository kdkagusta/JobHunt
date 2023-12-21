import React, { useState } from "react";
import { useHistory } from "react-router";
import { Button, Form, Icon, Message, Segment, Menu } from "semantic-ui-react";

export default function Record() {
  const history = useHistory();

  const home = () => {
    history.push("/home");
  };

  return (
    <div>
      <Segment>
        <Menu>
          <Message
            attached
            header="Welcome to our site!"
            content="Fill out the form below to sign-up for a new account"
          />
          <Form className="attached fluid segment">
            <Form.Group widths="equal">
              <Form.Input
                fluid
                label="First Name"
                placeholder="First Name"
                type="text"
              />
              <Form.Input
                fluid
                label="Last Name"
                placeholder="Last Name"
                type="text"
              />
            </Form.Group>

            <Form.Group widths="equal">
              <Form.Input
                fluid
                label="DateOfBirth"
                placeholder=""
                type="Date"
              />
              <Form.Input fluid label="Email" placeholder="Email" type="text" />
              <Form.Input
                fluid
                label="NationalIdentidy"
                placeholder="NationalIdentidy"
                type="text"
              />
            </Form.Group>

            <Form.Group widths="equal">
              <Form.Input
                fluid
                label="Password"
                placeholder="Password"
                type="text"
              />
              <Form.Input
                fluid
                label="PasswordRepeat"
                placeholder="PasswordRepeat"
                type="text"
              />
            </Form.Group>

            <Form.Checkbox
              inline
              label="I accept our privacy policy and privacy policy"
            />

            <Button color="blue" onClick={home}>
              Register
            </Button>
          </Form>
        </Menu>
      </Segment>
    </div>
  );
}
