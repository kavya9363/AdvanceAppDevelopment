import React from 'react'
import './Dashboard.css'
const Usersidebar = () => {
  return (
    <div>
        <nav className="navbar show navbar-vertical h-lg-screen navbar-expand-lg px-0 py-3 navbar-light bg-white border-bottom border-bottom-lg-0 border-end-lg" id="navbarVertical">
            <div className="container-fluid">
              {/* Toggler */}
              <button className="navbar-toggler ms-n2" type="button" data-bs-toggle="collapse" data-bs-target="#sidebarCollapse" aria-controls="sidebarCollapse" aria-expanded="false" aria-label="Toggle navigation">
            <span className="navbar-toggler-icon" />
              </button>
              <a className="navbar-brand py-lg-2 mb-lg-5 px-lg-6 me-0" href="#">
                {/* <img src="https://preview.webpixels.io/web/img/logos/clever-primary.svg" alt="..." /> */}
               <p><b>YOGA</b></p>
              </a>
             
              <div className="navbar-user d-lg-none">
              
                <div className="dropdown">
                 
                  <a href="#" id="sidebarAvatar" role="button" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <div className="avatar-parent-child">
                      <img alt="Image Placeholder" src="https://images.unsplash.com/photo-1548142813-c348350df52b?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=3&w=256&h=256&q=80" className="avatar avatar- rounded-circle" />
                      <span className="avatar-child avatar-badge bg-success" />
                    </div>
                  </a>
                  {/* Menu */}
                  {/* <div className="dropdown-menu dropdown-menu-end" aria-labelledby="sidebarAvatar">
                    <a href="#" className="dropdown-item">Profile</a>
                    <a href="#" className="dropdown-item">Settings</a>
                    <a href="#" className="dropdown-item">Billing</a>
                    <hr className="dropdown-divider" />
                    <a href="#" className="dropdown-item">Logout</a>
                  </div> */}
                </div>
              </div>
              {/* Collapse */}
              <div className="collapse navbar-collapse" id="sidebarCollapse">
                {/* Navigation */}
                <ul className="navbar-nav">
                  <li className="nav-item">
                    <a className="nav-link" href="/admindash">
                      <i className="bi bi-house" /> Dashboard
                    </a>
                  </li>
                  <li className="nav-item">
                    <a className="nav-link" href="/applications">
                      <i className="bi bi-bar-chart" />Applications
                    </a>
                  </li>
                  <li className="nav-item">
                    <a className="nav-link" href="/addcourses">
                      <i className="bi bi-chat" /> Add Courses
                      {/* <span className="badge bg-soft-primary text-primary rounded-pill d-inline-flex align-items-center ms-auto">6</span> */}
                    </a>
                  </li>
                  <li className="nav-item">
                    <a className="nav-link" href="#">
                      <i className="bi bi-bookmarks" /> Approved Courses
                    </a>
                  </li>
                  <li className="nav-item">
                    <a className="nav-link" href="#">
                      <i className="bi bi-people" /> Users
                    </a>
                  </li>
                </ul>
                {/* Divider */}
                <hr className="navbar-divider my-5 opacity-20" />
                
                <div className="mt-auto" />
                {/* User (md) */}
                <ul className="navbar-nav">
                  <li className="nav-item">
                    <a className="nav-link" href="/userprofile">
                      <i className="bi bi-person-square" /> Account
                    </a>
                  </li>
                  <li className="nav-item">
                    <a className="nav-link" href="#">
                      <i className="bi bi-box-arrow-left" /> Logout
                    </a>
                  </li>
                </ul>
              </div>
            </div>
          </nav>
    </div>
  )
}
export default Usersidebar





//can use
// import React from 'react';
// import "../layouts/Usersidebar.css";
// const Usersidebar = () => {
//   return (
//     <div>
//       <meta charSet="UTF-8" />
//       <meta name="viewport" content="width=device-width, initial-scale=1.0" />
//       <title>Bootstrap5 Sidebar</title>
//       <link
//         href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
//         rel="stylesheet"
//         integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
//         crossOrigin="anonymous"
//       />
//       <link rel="stylesheet" href="style.css" />
//       <link
//         rel="stylesheet"
//         href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
//         integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
//         crossOrigin="anonymous"
//         referrerPolicy="no-referrer"
//       />
//       <div className="container-fluid p-0 d-flex h-100">
//         <div
//           id="bdSidebar"
//           className="d-flex flex-column flex-shrink-0 p-3 bg-success text-white offcanvas-md offcanvas-start"
//         >
//           <a href="#" className="navbar-brand"></a>
//           <hr />
//           <ul className="mynav nav nav-pills flex-column mb-auto">
//             <li className="nav-item mb-1">
//               <a href="#">
//                 <i className="fa-regular fa-user" />
//                 Profile
//               </a>
//             </li>
//             <li className="nav-item mb-1">
//               <a href="#">
//                 <i className="fa-regular fa-bookmark" />
//                 Saved Articles
//                 <span className="notification-badge">5</span>
//               </a>
//             </li>
//             <li className="nav-item mb-1">
//               <a href="#">
//                 <i className="fa-regular fa-newspaper" />
//                 Articles
//               </a>
//             </li>
//             <li className="nav-item mb-1">
//               <a href="#">
//                 <i className="fa-solid fa-archway" />
//                 Institutions
//               </a>
//             </li>
//             <li className="nav-item mb-1">
//               <a href="#">
//                 <i className="fa-solid fa-graduation-cap" />
//                 Organizations
//               </a>
//             </li>
//             <li className="sidebar-item nav-item mb-1">
//               <a
//                 href="#"
//                 className="sidebar-link collapsed"
//                 data-bs-toggle="collapse"
//                 data-bs-target="#settings"
//                 aria-expanded="false"
//                 aria-controls="settings"
//               >
//                 <i className="fas fa-cog pe-2" />
//                 <span className="topic">Settings </span>
//               </a>
//               <ul id="settings" className="sidebar-dropdown list-unstyled collapse" data-bs-parent="#sidebar">
//                 <li className="sidebar-item">
//                   <a href="#" className="sidebar-link">
//                     <i className="fas fa-sign-in-alt pe-2" />
//                     <span className="topic"> Login</span>
//                   </a>
//                 </li>
//                 <li className="sidebar-item">
//                   <a href="#" className="sidebar-link">
//                     <i className="fas fa-user-plus pe-2" />
//                     <span className="topic">Register</span>
//                   </a>
//                 </li>
//                 <li className="sidebar-item">
//                   <a href="#" className="sidebar-link">
//                     <i className="fas fa-sign-out-alt pe-2" />
//                     <span className="topic">Log Out</span>
//                   </a>
//                 </li>
//               </ul>
//             </li>
//           </ul>
//           <hr />
//           <div className="d-flex">
//             <i className="fa-solid fa-book me-2" />
//             <span>
//               <h6 className="mt-1 mb-0">Geeks for Geeks Learning Portal</h6>
//             </span>
//           </div>
//         </div>
//         <div className="bg-light flex-fill">
//           <div className="p-2 d-md-none d-flex text-white bg-success">
//             <a href="#" className="text-white" data-bs-toggle="offcanvas" data-bs-target="#bdSidebar">
//               <i className="fa-solid fa-bars" />
//             </a>
//             <span className="ms-3">GFG Portal</span>
//           </div>
//           <div className="p-4">
//             <nav
//               style={{
//                 '-bsBreadcrumbDivider': '">',
//                 fontSize: '14px'
//               }}
//             >
//               <ol className="breadcrumb">
//                 <li className="breadcrumb-item">
//                   <i className="fa-solid fa-house" />
//                 </li>
//                 <li className="breadcrumb-item">Learning Content</li>
//                 <li className="breadcrumb-item">Next Page</li>
//               </ol>
//             </nav>
//             <hr />
//             <div className="row">
//               <div className="col">
//                 <p>Page content goes here</p>
//               </div>
//             </div>
//           </div>
//         </div>
//       </div>
//     </div>
//   );
// };

// export default Usersidebar;









