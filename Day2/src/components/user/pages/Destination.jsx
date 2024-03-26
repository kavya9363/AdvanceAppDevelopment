import React from "react";
// import img1 from "../assets/img/dest1.jpg";
// import img2 from "../assets/img/dest2.jpg";
// import img3 from "../assets/img/dest3.jpg";

import DestinationCard from "../../../layouts/DestinationCard";

const Destination = () => {
  return (
    <div className=" min-h-screen flex flex-col justify-center md:mx-32 mx-5">
      <h1 className=" font-medium text-center text-4xl lg:mt-0 mt-16">
        Courses
      </h1>

      <div className=" flex flex-col lg:flex-row gap-5 mt-14">
        <DestinationCard
          // img={img1}
          title="Inner Engineering"
          para="Inner Engineering is a technology for wellbeing derived from the ancient science of yoga. An intensive program for personal growth."
        />
        <DestinationCard
          // img={img2}
          title="Hatha Yoga"
          para="Isha Hatha Yoga programs are an unparalleled opportunity to learn practices derived from a yogic tradition maintained in its full purity and vibrancy for thousands of years.To spread among the people of spritual. "
        />
        <DestinationCard
          // img={img3}
          title="Bhuta Shuddhi"
          para="There is a whole system of yoga called Bhuta Shuddhi, which means “purification of the elements” to establish wellbeing of body and mind."
        />
      </div>
    </div>
  );
};

export default Destination;
