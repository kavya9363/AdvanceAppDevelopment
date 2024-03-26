import React from "react";
import Navbar from "./components/User/Navbar";
import Home from "./components/User/pages/Home";
import Features from "./components/User/pages/Features";
import Destination from "./components/User/pages/Destination";
import About from "./components/User/pages/About";
import Contact from "./components/User/pages/Contact";
import Footer from "./components/User/pages/Footer";
import Academy from "./components/User/pages/Academy";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Homee from "./components/User/pages/Homee";
import Login from "./components/User/Login";
import Signup from "./components/User/Signup";
import Dashboard from "./components/Admin/Dashboard";
import HomeDash from "./components/Admin/HomeDash";
// import Usersidebar from "./components/Dashboard/Usersidebar";
import Userprofile from "./components/Admin/Userprofile";
import Application from "./components/Admin/Application";
import Addcourses from "./components/Admin/Addcourses";
import Sidebar from "./components/Admin/Sidebar";
import Usersidebar from "./components/Admin/Sidebar";
import Admissionform from "./components/Admin/Admissionform";

const App = () => {
  return (
    <BrowserRouter>
    <Routes>
      <Route path="/" element={<Homee />} />
      <Route path="/login" element={<Login />} />
      <Route path="/signup" element={<Signup />} />
      <Route path="/admindash" element={<Dashboard />} />
        <Route path="/home" element={<HomeDash />} />
        <Route path="/userprofile" element={<><Usersidebar/></>} />
        <Route path="/admindash/userprofile" element={<><Usersidebar/><Userprofile /></>} />
        {/* <Route path="/applications" element={<><Usersidebar/></>} /> */}
        <Route path="/admindash/applications" element={<><Usersidebar/><Application /></>} />
        {/* <Route path="/addcourses" element={<><Usersidebar/></>} /> */}
        <Route path="/admindash/addcourses" element={<><Usersidebar/><Addcourses /></>} />
        {/* <Route path="/admission" element={<><Sidebar/></>} /> */}
        <Route path="/admindash/admission" element={<><Sidebar/><Admissionform /></>} />
    </Routes>
    </BrowserRouter>
  );
};

export default App;
{/* <Route path="/admindash" element={<Dashboard />} />
        <Route path="/home" element={<HomeDash />} />
        <Route path="/userprofile" element={<><Usersidebar/><Userprofile /></>} />
        <Route path="/applications" element={<><Usersidebar/><Application /></>} />
        <Route path="/addcourses" element={<><Usersidebar/><Addcourses /></>} />
        <Route path="/admission" element={<><Sidebar/><Admissionform /></>} /> */}