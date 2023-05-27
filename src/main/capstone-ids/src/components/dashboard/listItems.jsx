import * as React from "react";
import ListItemButton from "@mui/material/ListItemButton";
import ListItemIcon from "@mui/material/ListItemIcon";
import ListItemText from "@mui/material/ListItemText";
import ListSubheader from "@mui/material/ListSubheader";
import DashboardIcon from "@mui/icons-material/Dashboard";
import HomeIcon from "@mui/icons-material/Home";
import QueryStatsIcon from "@mui/icons-material/QueryStats";
import BarChartIcon from "@mui/icons-material/BarChart";
import AssignmentIcon from "@mui/icons-material/Assignment";
import PrivacyTipIcon from "@mui/icons-material/PrivacyTip";
import GitHubIcon from '@mui/icons-material/GitHub';
import MenuBookIcon from '@mui/icons-material/MenuBook';
import ConnectWithoutContactIcon from '@mui/icons-material/ConnectWithoutContact';
import { Divider } from "@mui/material";
export function MainListItems({ handleButtonClick }) {
  return (
    <React.Fragment>
      <ListItemButton onClick={() => handleButtonClick("Home", "/old")}>
        <ListItemIcon>
          <HomeIcon />
        </ListItemIcon>
        <ListItemText primary="Home" />
      </ListItemButton>

      <ListItemButton
        onClick={() =>
          handleButtonClick(
            "Dashboard",
            "http://localhost:5601/app/dashboards#/view/91485220-f8ad-11ed-98f3-4f3518f77aef?embed=true&_g=(refreshInterval:(pause:!f,value:5000),time:(from:now-15m,to:now))&_a=()&show-time-filter=true&hide-filter-bar=true"
          )
        }
      >
        <ListItemIcon>
          <DashboardIcon />
        </ListItemIcon>
        <ListItemText primary="Dashboard" />
      </ListItemButton>
      
      <ListItemButton
        onClick={() => handleButtonClick("Anomaly Log", "Anomaly Log 주소")}
      >
        <ListItemIcon>
          <QueryStatsIcon />
        </ListItemIcon>
        <ListItemText primary="Anomaly Log" />
      </ListItemButton>
      
      <ListItemButton
        onClick={() =>
          handleButtonClick(
            "Alert",
            "http://localhost:5601/app/dashboards#/view/05268ee0-86d1-11e8-b59d-21efb914e65c-ecs?embed=true&_g=(refreshInterval:(pause:!f,value:5000),time:(from:now-15m,to:now))&_a=()&hide-filter-bar=true"
          )
        }
      >
        <ListItemIcon>
          <PrivacyTipIcon />
        </ListItemIcon>
        <ListItemText primary="Alert" />
      </ListItemButton>
      
      <ListItemButton
        onClick={() => handleButtonClick("Reports","http://localhost:5601/app/dashboards#/view/91485220-f8ad-11ed-98f3-4f3518f77aef?embed=true&_g=(refreshInterval:(pause:!f,value:5000),time:(from:now-15m,to:now))&_a=()&show-time-filter=true&hide-filter-bar=true")} // 변경필요
      >
        <ListItemIcon>
          <BarChartIcon />
        </ListItemIcon>
        <ListItemText primary="Reports" />
      </ListItemButton>
      <Divider sx={{ my: 1 }} /> 
      <ListItemButton component='a' href="https://github.com/PMiseon/capstone_demo" target="_blank">
        <ListItemIcon>
          <GitHubIcon />
        </ListItemIcon>
        <ListItemText primary="Github" />
      </ListItemButton>
      <ListItemButton component='a' href="https://kiwi-nurse-5b2.notion.site/346e6407a07643a188ab28ee03986224" target="_blank">   
        <ListItemIcon>
          <MenuBookIcon />
        </ListItemIcon>
        <ListItemText primary="Notion" />
      </ListItemButton>
      <ListItemButton component='a' href="https://kiwi-nurse-5b2.notion.site/346e6407a07643a188ab28ee03986224" target="_blank">   
        <ListItemIcon>
          <ConnectWithoutContactIcon />
        </ListItemIcon>
        <ListItemText primary="Discord" />
      </ListItemButton>
    </React.Fragment>
  );
}