import React, { useState } from "react";
import SingOut from "./companent/SingOut";
import SingIn from "./companent/SingIn";
import { Menu, Segment } from "semantic-ui-react";
import { useHistory } from "react-router";
import Language from "./companent/Language";

export default function Navi() {
  const [isAuthenticated, setisAuthenticated] = useState(true);
  const history = useHistory();

  function handleSingOut() {
    setisAuthenticated(false);
  }

  function handleSingIn() {
    history.push("/login");
  }

  function handleRecord() {
    history.push("/record");
  }

  const jobAdvertisement = () => {
    history.push("/jobAdvertisementListed");
  };

  const jobSeeker = () => {
    history.push("/jobSeekerCvListed");
  };

  const home = () => {
    history.push("/home");
  };

  return (
    <div>
      <Segment inverted>
        <Menu inverted pointing secondary>
          <Menu.Item name="Menu" icon="home" onClick={home} />
          <Menu.Item name="Job Posting" icon="js" onClick={jobAdvertisement} />
          <Menu.Menu position="right">
            <Language />
            {isAuthenticated ? (
              <SingIn singOut={handleSingOut} />
            ) : (
              <SingOut singIn={handleSingIn} record={handleRecord} />
            )}
          </Menu.Menu>
        </Menu>
      </Segment>
    </div>
  );
}
