import React from 'react';
import './HomeDash.css'
const yogaClasses = [
  {
    title: 'Hatha Yoga (Level I)',
    time: '10 Minutes',
    description: 'Gentle introduction to yoga poses for beginners.',
    instructor: 'Anisha Chirmute',
  },
  {
    title: 'Serene Spine (Level I)',
    time: '20 Minutes',
    description: 'Focus on flexibility and posture alignment.',
    instructor: 'Nichais Golden',
  },
  {
    title: 'Restorative Yoga',
    time: '30 Minutes',
    description: 'Gentle poses and breathing exercises for deep relaxation.',
    instructor: 'Liam Patel',
  },
  {
    title: 'Vinyasa Flow (Level II)',
    time: '45 Minutes',
    description: 'Flowing sequence of postures to build strength and stamina.',
    instructor: 'Maria Santana',
  },
  {
    title: 'Yin Yoga',
    time: '60 Minutes',
    description: 'Passive stretches targeting deep connective tissues.',
    instructor: 'David Chen',
  },
  {
    title: 'Prenatal Yoga',
    time: '45 Minutes',
    description: 'Safe and gentle poses for expectant mothers.',
    instructor: 'Dr. Sarah Moore',
  }
  
];

const YogaClassCard = ({ title, time, description, instructor }) => {
  return (
    <div className="class-card">
      <h3>{title}</h3>
      <p>{time}</p>
      <p>{description}</p>
      <p>Instructor: {instructor}</p>
      <button>Book Now</button>
    </div>
  );
};

const HomeDash = () => {
  return (
    <div className="container">
      <h1 className="heading">Engaging and Convenient Online Yoga Classes</h1>
      <div className="class-grid">
        {yogaClasses.map((yogaClass) => (
          <YogaClassCard key={yogaClass.title} {...yogaClass} />
        ))}
      </div>
    </div>
  );
};

export default HomeDash;
