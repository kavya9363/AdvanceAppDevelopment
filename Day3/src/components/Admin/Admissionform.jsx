import React, { useState } from "react";
import './Admissionform.css'
const Admissionform = () => {
  const [formData, setFormData] = useState({
    name: "",
    email: "",
    course: "",
    duration: "",
    age: "",
    phoneNumber: "",
  });

  const handleChange = (event) => {
    const { name, value } = event.target;
    setFormData((prevFormData) => ({
      ...prevFormData,
      [name]: value,
    }));
  };

  const handleSubmit = (event) => {
    event.preventDefault();

    // Submit the form data to your server here
  };

  return (
    <form className="course-admission-form" onSubmit={handleSubmit}>
      <input
        type="text"
        name="name"
        placeholder="Name"
        value={formData.name}
        onChange={handleChange}
      />
      <input
        type="email"
        name="email"
        placeholder="Email"
        value={formData.email}
        onChange={handleChange}
      />
      <select
        name="course"
        value={formData.course}
        onChange={handleChange}
      >
        <option value="">Select a course</option>
        <option value="web-development">Web Development</option>
        <option value="data-science">Data Science</option>
        <option value="machine-learning">Machine Learning</option>
      </select>
      <input
        type="text"
        name="duration"
        placeholder="Duration"
        value={formData.duration}
        onChange={handleChange}
      />
      <input
        type="text"
        name="age"
        placeholder="Age"
        value={formData.age}
        onChange={handleChange}
      />
      <input
        type="tel"
        name="phoneNumber"
        placeholder="Phone Number"
        value={formData.phoneNumber}
        onChange={handleChange}
      />
      <button type="submit">Submit</button>
    </form>
  );
};

export default Admissionform;
