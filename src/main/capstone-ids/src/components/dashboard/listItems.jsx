import * as React from "react";
import ListItemButton from "@mui/material/ListItemButton";
import ListItemIcon from "@mui/material/ListItemIcon";
import ListItemText from "@mui/material/ListItemText";
import DashboardIcon from "@mui/icons-material/Dashboard";
import QueryStatsIcon from "@mui/icons-material/QueryStats";
import BarChartIcon from "@mui/icons-material/BarChart";
//import PrivacyTipIcon from "@mui/icons-material/PrivacyTip";
import GitHubIcon from "@mui/icons-material/GitHub";
import MenuBookIcon from "@mui/icons-material/MenuBook";
import ConnectWithoutContactIcon from "@mui/icons-material/ConnectWithoutContact";
import { Divider } from "@mui/material";
export function MainListItems({ handleButtonClick }) {

  return (
    <React.Fragment>
      {/* <ListItemButton onClick={() => handleButtonClick("Home", "/old")}>
        <ListItemIcon>
          <HomeIcon />
        </ListItemIcon>
        <ListItemText primary="Home" />
      </ListItemButton> */}

      <ListItemButton
        onClick={() =>
          handleButtonClick(
            "Dashboard",
            "http://localhost:5601/app/dashboards#/view/91485220-f8ad-11ed-98f3-4f3518f77aef?embed=true&_g=(refreshInterval:(pause:!f,value:5000),time:(from:now-15m,to:now))&_a=()&show-query-input=true&show-time-filter=true"
          )
        }
      >
        <ListItemIcon>
          <DashboardIcon />
        </ListItemIcon>
        <ListItemText primary="Dashboard" />
      </ListItemButton>

      <ListItemButton
        onClick={() => handleButtonClick("Anomaly Log", "http://localhost:5601/app/dashboards#/view/05268ee0-86d1-11e8-b59d-21efb914e65c-ecs?embed=true&_g=(refreshInterval:(pause:!t,value:60000),time:(from:now-15d,to:now))&_a=()&show-query-input=true&show-time-filter=true&hide-filter-bar=true" )}
      >
        <ListItemIcon>
          <QueryStatsIcon />
        </ListItemIcon>
        <ListItemText primary="Anomaly Log" />
      </ListItemButton>

      <ListItemButton
        component="a"
        href="http://localhost:8080/pdf/generate"
        target="_blank"
      >
        <ListItemIcon>
          <BarChartIcon />
        </ListItemIcon>
        <ListItemText primary="Reports" />
      </ListItemButton>

      <Divider sx={{ my: 1 }} />
      <ListItemButton
        component="a"
        href="https://github.com/PMiseon/capstone_demo"
        target="_blank"
      >
        <ListItemIcon>
          <GitHubIcon />
        </ListItemIcon>
        <ListItemText primary="Github" />
      </ListItemButton>

      <ListItemButton
        component="a"
        href="https://kiwi-nurse-5b2.notion.site/346e6407a07643a188ab28ee03986224"
        target="_blank"
      >
        <ListItemIcon>
          <MenuBookIcon />
        </ListItemIcon>
        <ListItemText primary="Notion" />
      </ListItemButton>

      <ListItemButton
        component="a"
        href="https://discord.gg/J2NKny6t"
        target="_blank"
      >
        <ListItemIcon>
          <ConnectWithoutContactIcon />
        </ListItemIcon>
        <ListItemText primary="Discord" />
      </ListItemButton>
    </React.Fragment>
  );
}