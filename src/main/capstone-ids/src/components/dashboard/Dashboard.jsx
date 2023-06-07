import * as React from "react";
import { styled, createTheme, ThemeProvider } from "@mui/material/styles";
import CssBaseline from "@mui/material/CssBaseline";
import MuiDrawer from "@mui/material/Drawer";
import Box from "@mui/material/Box";
import MuiAppBar from "@mui/material/AppBar";
import Toolbar from "@mui/material/Toolbar";
import List from "@mui/material/List";
import Typography from "@mui/material/Typography";
import Divider from "@mui/material/Divider";
import IconButton from "@mui/material/IconButton";
import Container from "@mui/material/Container";
import Link from "@mui/material/Link";
import MenuIcon from "@mui/icons-material/Menu";
import ChevronLeftIcon from "@mui/icons-material/ChevronLeft";
import LogoutIcon from "@mui/icons-material/Logout";
import { MainListItems } from "./listItems";
import { useNavigate } from "react-router-dom";
import EmbedKibana from "../EmbedKibana";

function Copyright(props) {
  return (
    <Typography
      variant="body2"
      color="text.secondary"
      align="center"
      {...props}
    >
      {"Copyright © "}
      <Link
        color="inherit"
        href="https://github.com/PMiseon/capstone_demo"
        target="_blank"
      >
        다차자
      </Link>{" "}
      {new Date().getFullYear()}
      {"."}
    </Typography>
  );
}

const drawerWidth = 240;

const AppBar = styled(MuiAppBar, {
  shouldForwardProp: (prop) => prop !== "open",
})(({ theme, open }) => ({
  zIndex: theme.zIndex.drawer + 1,
  transition: theme.transitions.create(["width", "margin"], {
    easing: theme.transitions.easing.sharp,
    duration: theme.transitions.duration.leavingScreen,
  }),
  ...(open && {
    marginLeft: drawerWidth,
    width: `calc(100% - ${drawerWidth}px)`,
    transition: theme.transitions.create(["width", "margin"], {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.enteringScreen,
    }),
  }),
}));

const Drawer = styled(MuiDrawer, {
  shouldForwardProp: (prop) => prop !== "open",
})(({ theme, open }) => ({
  "& .MuiDrawer-paper": {
    position: "relative",
    whiteSpace: "nowrap",
    width: drawerWidth,
    transition: theme.transitions.create("width", {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.enteringScreen,
    }),
    boxSizing: "border-box",
    ...(!open && {
      overflowX: "hidden",
      transition: theme.transitions.create("width", {
        easing: theme.transitions.easing.sharp,
        duration: theme.transitions.duration.leavingScreen,
      }),
      width: theme.spacing(7),
      [theme.breakpoints.up("sm")]: {
        width: theme.spacing(9),
      },
    }),
  },
}));

const defaultTheme = createTheme();

export default function Dashboard({ setIsAuthenticated }) {
  const [selectedButton, setSelectedButton] = React.useState("Dashboard"); // state for selected button
  const [iframeSrc, setIframeSrc] = React.useState(
    "http://localhost:5601/app/dashboards#/view/91485220-f8ad-11ed-98f3-4f3518f77aef?embed=true&_g=(refreshInterval:(pause:!t,value:5000),time:(from:now-15m,to:now))&_a=()&show-query-input=true&show-time-filter=true"
  );
  const [open, setOpen] = React.useState(true); // state for open drawer

  const navigate = useNavigate();
  const handleLogout = () => {
    console.log("Logout Requested");
    setIsAuthenticated(false);
    navigate("/login");
  };
  const toggleDrawer = () => {
    setOpen(!open);
  };

  // 버튼 클릭 시 해당 버튼의 이름과 iframe 주소를 업데이트
  const handleButtonClick = (buttonName, iframeAddress) => {
    setSelectedButton(buttonName);
    setIframeSrc(iframeAddress);
    console.log(iframeSrc);
  };

  return (
    <ThemeProvider theme={defaultTheme}>
      <Box sx={{ display: "flex" }}>
        <CssBaseline />
        <AppBar position="absolute" open={open}>
          <Toolbar
            sx={{
              pr: "24px", // keep right padding when drawer closed
              "background-image": "linear-gradient(to right, #00395d, #8f8f8c)",
            }}
          >
            {/*drawer button */}
            <IconButton
              edge="start"
              color="inherit"
              aria-label="open drawer"
              onClick={toggleDrawer}
              sx={{
                marginRight: "36px",
                ...(open && { display: "none" }),
              }}
            >
              <MenuIcon />
            </IconButton>
            <Typography
              component="h1"
              variant="h6"
              color="inherit"
              noWrap
              sx={{ flexGrow: 1 }}
            >
              {selectedButton} {/* TopBar에 선택된 버튼 이름으로 표시*/}
            </Typography>
            <IconButton color="inherit" onClick={handleLogout}>
              <LogoutIcon />
            </IconButton>
          </Toolbar>
        </AppBar>
        <Drawer variant="permanent" open={open}>
          <Toolbar
            sx={{
              display: "flex",
              alignItems: "center",
              justifyContent: "flex-end",
              px: [1],
            }}
          >
            <IconButton onClick={toggleDrawer}>
              <ChevronLeftIcon />
            </IconButton>
          </Toolbar>
          <Divider />
          <List component="nav">
            <MainListItems handleButtonClick={handleButtonClick} />
            <Divider sx={{ my: 1 }} />
          </List>
          {/* 저작권 문구 */}
          {open && (
            <Typography
              variant="caption"
              sx={{
                position: "absolute",
                bottom: 0,
                left: 0,
                width: "100%",
                textAlign: "center",
                py: [2],
              }}
            >
              &copy; 2023{" "}
              <Link
                color="inherit"
                href="https://github.com/PMiseon/capstone_demo" // TODO: update github repo
                target="_blank"
              >
                다차자
              </Link>
              . All rights reserved.
            </Typography>
          )}
        </Drawer>
        <Box
          component="main"
          sx={{
            backgroundColor: (theme) =>
              theme.palette.mode === "light"
                ? theme.palette.grey[100]
                : theme.palette.grey[900],
            flexGrow: 1,
            height: "100vh",
            overflow: "auto",
          }}
        >
          <Toolbar />
          <Container maxWidth="100%" sx={{ mt: 4, mb: 4 }}>
            {" "}
            {/*최대너비 default:'lg' sx:스타일속성,mt margin-top */}
            <EmbedKibana url={iframeSrc} />
          </Container>
          <Copyright />
        </Box>
      </Box>
    </ThemeProvider>
  );
}