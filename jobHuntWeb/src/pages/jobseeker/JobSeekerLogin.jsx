import React from "react";
import { NavLink } from "react-router-dom";
import { Form, Container, Button } from "semantic-ui-react";

export default function JobSeekerLogin({ SingIn }) {
  return (
    <div>
      <Button.Group>
        <Button as={NavLink} to="/pages/EmployerLogin.jsx">
          Employers
        </Button>
        <Button.Or text="or" />
        <Button as={NavLink} to="/pages/JobSeekerLogin.jsx" positive>
          JobSeeker
        </Button>
      </Button.Group>
      <hr />
      <br />
      <br />
      <br />
      <Container>
        <Form>
          <Form.Field>
            <label className="label">E-Mail</label>
            <input type="email" />
          </Form.Field>
          <Form.Field>
            <label className="label">Password</label>
            <input type="password" />
          </Form.Field>
          <Button type="submit" onClick={SingIn}>
            LogIn
          </Button>
        </Form>
        <br />
        <Button as={NavLink} to="/pages/EmployerRegister.jsx " negative>
          Create account
        </Button>
      </Container>
    </div>
  );
}
