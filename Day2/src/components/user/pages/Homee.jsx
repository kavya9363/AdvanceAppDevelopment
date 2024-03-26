import React from "react";
import Navbar from "../Navbar";
import Home from "./Home";
import Features from "./Features";
import Destination from "./Destination";
import About from "./About";
import Contact from "./Contact";
import Footer from "./Footer";
import Academy from "./Academy";
import { BrowserRouter } from "react-router-dom";

const Homee = () => {
  return (
    <div>
      <Navbar />

      <main>
        <div id="home">
          <Home />
        </div>

        <div id="about">
          <Features />
        </div>

        <div id="destination">
          <Destination />
        </div>

        <div id="features">
          <Academy />
        </div>

        <div id="contact">
          <Contact />
        </div>
      </main>

      <Footer />
    </div>
  );
};

export default Homee;
