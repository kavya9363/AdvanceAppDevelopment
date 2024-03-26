import React from "react";
import Button from "../../../layouts/Button";
//import img from "../assets/img/hero.jpg";
import { Link } from "react-scroll";

const Home = () => {
  const backgroundColor = `bg-brightColor`;

  return (
    <div className=" min-h-screen lg:min-h-[90vh] flex flex-col justify-center lg:flex-row items-center md:mx-32 mx-5">
      <div className=" flex flex-col text-center lg:text-start gap-5">
        <h1 className=" font-semibold text-5xl leading-tight">
          Track in wellness Journey
        </h1>
        <p>
        Grow your personal practice at your convenience in your space. 
        Variety of classes to suit your comfort level.
        </p>

        <div className=" lg:pl-24">
          <Link to="destination" spy={true} smooth={true} duration={500}>
            <Button title="Book now" backgroundColor={backgroundColor} />
          </Link>
        </div>
      </div>
      <div className=" mt-14 lg:mt-0 w-full lg:w-4/5">
        {/* <img src={img} alt="img" className="big-img" /> */}
      </div>
    </div>
  );
};

export default Home;
