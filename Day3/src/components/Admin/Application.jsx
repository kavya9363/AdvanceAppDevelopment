import React from 'react'
import './Application.css'
const Application = () => {
  return (
    // <div className="h-screen flex-grow-1 overflow-y-lg-auto">
    <div className="container-app-fluid">
        <div className="card shadow border-0 mb-7">
                  <div className="card-header">
                    <h5 className="mb-0">Applications</h5>
                  </div>
                  <div className="table-responsive">
                    <table className="table table-hover table-nowrap">
                      <thead className="thead-light">
                        <tr>
                          <th scope="col">Name</th>
                          <th scope="col">Duration</th>
                          <th scope="col">Course</th>
                          <th scope="col">Price</th>
                          <th scope="col">status</th>
                          <th />
                        </tr>
                      </thead>
                      <tbody>
                        <tr>
                          <td>
                            <img alt="..." src="https://images.unsplash.com/photo-1608976328267-e673d3ec06ce?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=3&w=256&h=256&q=80" className="avatar avatar-sm rounded-circle me-2" />
                            <a className="text-heading font-semibold" href="#">
                              Ramesh
                            </a>
                          </td>
                          <td>
                            April-May
                          </td>
                          <td>
                            <img alt="..." src="https://preview.webpixels.io/web/img/other/logos/logo-5.png" className="avatar avatar-xs rounded-circle me-2" />
                            <a className="text-heading font-semibold" href="#">
                              Daily yoga
                            </a>
                          </td>
                          <td>
                            3500
                          </td>
                          <td>
                            <span className="badge badge-lg badge-dot">
                              <i className="bg-danger" />Canceled
                            </span>
                          </td>
                          <td className="text-end">
                            <a href="#" className="btn btn-sm btn-neutral">View</a>
                            <button type="button" className="btn btn-sm btn-square btn-neutral text-danger-hover">
                              <i className="bi bi-trash" />
                            </button>
                          </td>
                        </tr>
                        <tr>
                          <td>
                            <img alt="..." src="https://images.unsplash.com/photo-1502823403499-6ccfcf4fb453?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=3&w=256&h=256&q=80" className="avatar avatar-sm rounded-circle me-2" />
                            <a className="text-heading font-semibold" href="#">
                              Luchi
                            </a>
                          </td>
                          <td>
                            Feb-April
                          </td>
                          <td>
                            <img alt="..." src="https://preview.webpixels.io/web/img/other/logos/logo-1.png" className="avatar avatar-xs rounded-circle me-2" />
                            <a className="text-heading font-semibold" href="#">
                              Mastering in Yoga
                            </a>
                          </td>
                          <td>
                            6500
                          </td>
                          <td>
                            <span className="badge badge-lg badge-dot">
                              <i className="bg-success" />Scheduled
                            </span>
                          </td>
                          <td className="text-end">
                            <a href="#" className="btn btn-sm btn-neutral">View</a>
                            <button type="button" className="btn btn-sm btn-square btn-neutral text-danger-hover">
                              <i className="bi bi-trash" />
                            </button>
                          </td>
                        </tr>
                        <tr>
                          <td>
                            <img alt="..." src="https://images.unsplash.com/photo-1610271340738-726e199f0258?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=3&w=256&h=256&q=80" className="avatar avatar-sm rounded-circle me-2" />
                            <a className="text-heading font-semibold" href="#">
                              Aishwarya
                            </a>
                          </td>
                          <td>
                            June-July
                          </td>
                          <td>
                            <img alt="..." src="https://preview.webpixels.io/web/img/other/logos/logo-2.png" className="avatar avatar-xs rounded-circle me-2" />
                            <a className="text-heading font-semibold" href="#">
                              Ayurvedic Yoga
                            </a>
                          </td>
                          <td>
                            5750
                          </td>
                          <td>
                            <span className="badge badge-lg badge-dot">
                              <i className="bg-warning" />Postponed
                            </span>
                          </td>
                          <td className="text-end">
                            <a href="#" className="btn btn-sm btn-neutral">View</a>
                            <button type="button" className="btn btn-sm btn-square btn-neutral text-danger-hover">
                              <i className="bi bi-trash" />
                            </button>
                          </td>
                        </tr>
                        <tr>
                          <td>
                            <img alt="..." src="https://images.unsplash.com/photo-1610878722345-79c5eaf6a48c?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=3&w=256&h=256&q=80" className="avatar avatar-sm rounded-circle me-2" />
                            <a className="text-heading font-semibold" href="#">
                              Aana
                            </a>
                          </td>
                          <td>
                            March-June
                          </td>
                          <td>
                            <img alt="..." src="https://preview.webpixels.io/web/img/other/logos/logo-3.png" className="avatar avatar-xs rounded-circle me-2" />
                            <a className="text-heading font-semibold" href="#">
                              Yoga Through Ages
                            </a>
                          </td>
                          <td>
                            10000
                          </td>
                          <td>
                            <span className="badge badge-lg badge-dot">
                              <i className="bg-success" />Scheduled
                            </span>
                          </td>
                          <td className="text-end">
                            <a href="#" className="btn btn-sm btn-neutral">View</a>
                            <button type="button" className="btn btn-sm btn-square btn-neutral text-danger-hover">
                              <i className="bi bi-trash" />
                            </button>
                          </td>
                        </tr>
                        <tr>
                          <td>
                            <img alt="..." src="https://images.unsplash.com/photo-1612422656768-d5e4ec31fac0?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=3&w=256&h=256&q=80" className="avatar avatar-sm rounded-circle me-2" />
                            <a className="text-heading font-semibold" href="#">
                              Kristina
                            </a>
                          </td>
                          <td>
                            April
                          </td>
                          <td>
                            <img alt="..." src="https://preview.webpixels.io/web/img/other/logos/logo-4.png" className="avatar avatar-xs rounded-circle me-2" />
                            <a className="text-heading font-semibold" href="#">
                              Daily Serenity
                            </a>
                          </td>
                          <td>
                            500
                          </td>
                          <td>
                            <span className="badge badge-lg badge-dot">
                              <i className="bg-dark" />Not discussed
                            </span>
                          </td>
                          <td className="text-end">
                            <a href="#" className="btn btn-sm btn-neutral">View</a>
                            <button type="button" className="btn btn-sm btn-square btn-neutral text-danger-hover">
                              <i className="bi bi-trash" />
                            </button>
                          </td>
                        </tr>
                        <tr>
                          <td>
                            <img alt="..." src="https://images.unsplash.com/photo-1608976328267-e673d3ec06ce?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=3&w=256&h=256&q=80" className="avatar avatar-sm rounded-circle me-2" />
                            <a className="text-heading font-semibold" href="#">
                              Alan Watson
                            </a>
                          </td>
                          <td>
                            June-September
                          </td>
                          <td>
                            <img alt="..." src="https://preview.webpixels.io/web/img/other/logos/logo-5.png" className="avatar avatar-xs rounded-circle me-2" />
                            <a className="text-heading font-semibold" href="#">
                              Essential of Self Myofascial Release
                            </a>
                          </td>
                          <td>
                            10500
                          </td>
                          <td>
                            <span className="badge badge-lg badge-dot">
                              <i className="bg-danger" />Canceled
                            </span>
                          </td>
                          <td className="text-end">
                            <a href="#" className="btn btn-sm btn-neutral">View</a>
                            <button type="button" className="btn btn-sm btn-square btn-neutral text-danger-hover">
                              <i className="bi bi-trash" />
                            </button>
                          </td>
                        </tr>
                      </tbody>
                    </table>
                  </div>
                </div>
                </div>
   )
}

export default Application