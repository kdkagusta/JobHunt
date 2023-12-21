import React from "react";
import { Dropdown } from "semantic-ui-react";

export default function Language() {
  return (
    <div>
      <Dropdown item text="Language">
        <Dropdown.Menu>
          <Dropdown.Item>English</Dropdown.Item>
          <Dropdown.Item>Türkçe</Dropdown.Item>
          <Dropdown.Item>Deutsche</Dropdown.Item>
          <Dropdown.Item>عربى</Dropdown.Item>
          <Dropdown.Item>русский</Dropdown.Item>
        </Dropdown.Menu>
      </Dropdown>
    </div>
  );
}
