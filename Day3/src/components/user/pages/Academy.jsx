import React from "react";
// import img1 from "../assets/img/dest1.jpg";
// import img2 from "../assets/img/dest2.jpg";
// import img3 from "../assets/img/dest3.jpg";

import DestinationCard from "../../../layouts/DestinationCard";

const Academy = () => {
  return (
    <div className=" min-h-screen flex flex-col justify-center md:mx-32 mx-5">
      <h1 className=" font-medium text-center text-4xl lg:mt-0 mt-16">
        Academy
      </h1>

      <div className=" flex flex-col lg:flex-row gap-5 mt-14">
        <DestinationCard
          // img={img1}
          title="Swara yoga academy"
          para="All our courses explore transformative practices which are rooted in the energetic traditions  of Hatha Yoga, as well as Tantra, Taoism & Ayurveda."
        />
        <DestinationCard
          // img={img2}
          title="Isha Yoga"
          para="
          Isha Yoga aims to give a modern and practical method to personal growth and spiritual development that is based on the yoga philosophy.Isha refers to Sadhguru and the spiritual force that he embodies in Isha Yoga "
        />
        <DestinationCard
          // img={img3}
          title="All Yoga Bali"
          para="You will have the opportunity to explore other yoga styles such as Vinyasa, Yin Yoga, and Rocket Yoga, and learn how to creatively sequence your own classes."
        />
      </div>
    </div>
  );
};

export default Academy;
