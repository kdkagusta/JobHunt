import React from "react";
import { Button, Icon } from "semantic-ui-react";

export default function SingOut({ singIn, record }) {
  return (
    <div>
      <Button.Group>
        <Button animated inverted onClick={singIn}>
          <Button.Content visible> Sign In </Button.Content>
          <Button.Content hidden>
            {" "}
            <Icon color="black" name="sign in" />{" "}
          </Button.Content>
        </Button>
        <Button.Or />
        <Button animated inverted onClick={record}>
          <Button.Content visible> Sign Up </Button.Content>
          <Button.Content hidden>
            {" "}
            <Icon color="black" name="save outline" />{" "}
          </Button.Content>
        </Button>
      </Button.Group>
    </div>
  );
}
