import React from "react";
import { useHistory } from "react-router";
import {
  Header,
  Icon,
  Image,
  Menu,
  Segment,
  Sidebar,
  Popup,
} from "semantic-ui-react";

export default function LeftBar() {
  const history = useHistory();
  const home = () => {
    history.push("/home");
  };
  const employerList = () => {
    history.push("/employerListed");
  };
  const jobSeekerList = () => {
    history.push("/jobSeekerListed");
  };
  const jobAdvertisemenetList = () => {
    history.push("/jobAdvertisementListed");
  };
  const cvList = () => {
    history.push("");
  };
  return (
    <div>
      <Menu icon="labeled" inverted color="red" pointing secondary vertical>
        <Popup
          content="Home"
          position="right center"
          trigger={<Menu.Item a="a" icon="home" onClick={home} />}
        />
        <Popup
          content="Employer Lists"
          position="right center"
          trigger={<Menu.Item a="a" icon="building" onClick={employerList} />}
        />
        <Popup
          content="Job Seeker Lists"
          position="right center"
          trigger={<Menu.Item a="a" icon="handshake" onClick={jobSeekerList} />}
        />
        <Popup
          content="Active Job Postings"
          position="right center"
          trigger={
            <Menu.Item a="a" icon="bullhorn" onClick={jobAdvertisemenetList} />
          }
        />
        <Popup
          content="Cv Lists"
          position="right center"
          trigger={<Menu.Item a="a" icon="box" onClick={cvList} />}
        />
      </Menu>
    </div>
  );
}
