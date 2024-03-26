import React from "react";
//import img from "../assets/img/contact.jpg";
import Button from "../../../layouts/Button";

const Contact = () => {
  const backgroundColor = `bg-brightColor`;
  return (
    <div className=" min-h-screen flex flex-col items-center justify-center md:mx-32 mx-5 mt-10">
      <div className=" flex flex-col lg:flex-row justify-between w-full">
        <form className=" w-full lg:w-2/5 space-y-5 bg-[#F2F2F2] p-5 rounded-xl">
          <h1 className="text-4xl font-semibold text-center">Contact Form</h1>
          <div className=" flex flex-col">
            <label htmlFor="userName">Full Name</label>
            <input
              className=" py-3 px-2 rounded-lg hover:shadow-[rgba(0,_0,_0,_0.24)_0px_3px_8px] transition-all"
              type="text"
              name="userName"
              id="userName"
              placeholder="Enter your name"
            />
          </div>
          <div className=" flex flex-col">
            <label htmlFor="userEmail">Email</label>
            <input
              className=" py-3 px-2 rounded-lg hover:shadow-[rgba(0,_0,_0,_0.24)_0px_3px_8px] transition-all"
              type="email"
              name="userEmail"
              id="userEmail"
              placeholder="Enter your email"
            />
          </div>
          <div className=" flex flex-col">
            <label htmlFor="userMessage">Message</label>
            <textarea
              className=" py-3 px-2 rounded-lg hover:shadow-[rgba(0,_0,_0,_0.24)_0px_3px_8px] transition-all"
              name="userMessage"
              id="userMessage"
              cols="30"
              rows="3"
              placeholder="Enter your message"
            ></textarea>
          </div>

          <div className="flex flex-row justify-center">
            <Button title="Submit" backgroundColor={backgroundColor} />
          </div>
        </form>
        <div className=" flex flex-col items-center w-full lg:w-2/4 my-5">
          {/* <img className=" rounded-lg" src={img} alt="" /> */}
          <p className=" text-center text-sm pt-4 text-[#898888]">
          Get in Touch

Have questions about our yoga classes or membership options? Want to learn more about our workshops and events? Interested in booking a private session or collaborating with us? We'd love to hear from you!

Fill out the form below to reach out to our team. Whether you're a seasoned yogi or just starting your journey, we're here to support you every step of the way towards greater wellness and inner peace..
          </p>
        </div>
      </div>
    </div>
  );
};

export default Contact;
