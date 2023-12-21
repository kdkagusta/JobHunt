import React from "react";
import { Dropdown, Image, Label, Icon, Menu } from "semantic-ui-react";

export default function SingIn({ singOut }) {
  return (
    <div>
      <Menu.Item>
        <Image
          avatar
          spaced="right"
          src="https://cdn.discordapp.com/attachments/823620516832870421/853349587283738644/20200322_154904.jpg"
        />
        <Dropdown pointing="top right" text="Hilmi">
          <Dropdown.Menu>
            <Dropdown.Item>
              <Icon name="address card outline" /> My Information
            </Dropdown.Item>
            <Dropdown.Item text="My Job Applications" icon="briefcase" />
            <Dropdown.Item
              onClick={singOut}
              text="Log Out"
              icon="sign-out alternate"
            />
          </Dropdown.Menu>
        </Dropdown>
      </Menu.Item>
    </div>
  );
}
