import React from "react";
import { Button, Checkbox, Form } from "semantic-ui-react";
import { Container } from "semantic-ui-react";
import { NavLink } from "react-router-dom";

export default function JobSeekerRegister() {
  return (
    <div>
      <Button.Group>
        <a href="/pages/EmployerRegister.jsx">
          <Button>Employers</Button>
        </a>
        <Button.Or text="or" />
        <a href="/pages/JobSeekerRegister.jsx">
          <Button positive>JobSeeker</Button>
        </a>
      </Button.Group>
      <hr />
      <br />
      <br />
      <br />
      <Container>
        <Form>
          <Form.Field>
            <label className="label">Primary Name</label>
            <input type="text" placeholder="Primary Name" />
          </Form.Field>
          <Form.Field>
            <label className="label">Last Name</label>
            <input type="text" placeholder="Last Name" />
          </Form.Field>
          <Form.Field>
            <label className="label">Identity Number</label>
            <input type="tel" placeholder="***********" />
          </Form.Field>
          <Form.Field>
            <label className="label">BirtDay</label>
            <input type="date" placeholder="00-00-0000" />
          </Form.Field>
          <Form.Field>
            <label className="label">E-mail</label>
            <input placeholder="E-mail" type="email" />
          </Form.Field>
          <Form.Field>
            <label className="label">Password</label>
            <input type="Password" placeholder="Password" />
          </Form.Field>
          <Form.Field>
            <Checkbox
              className="label"
              label="I agree to the Terms and Conditions"
            />
          </Form.Field>
          <Button type="submit">Register</Button>
          <br />
        </Form>
        <br />
        <Button as={NavLink} to="/pages/JobSeekerLogin.jsx" negative>
          Do you already have an account ?
        </Button>
      </Container>
    </div>
  );
}
