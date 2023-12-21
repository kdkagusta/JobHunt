import axios from "axios";

export default class jobAdvertisementService {
  getJobAdvertisements() {
    return axios.get("http://localhost:8100/api/jobadvertisement/getall");
  }

  getByIsActive() {
    return axios.get(
      "http://localhost:8080/api/jobadvertisement/getByIsActive"
    );
  }

  getByAppealDeadline() {
    return axios.get(
      "http://localhost:8080/api/jobadvertisement/getByAppealDeadline"
    );
  }

  getByCompanyName(params) {
    return axios.get(
      `http://localhost:8080/api/jobadvertisement/getAllOpenedPositionByCompanyName?employerId=${params}`
    );
  }

  getByIsActive() {
    return axios.get(
      "http://localhost:8080/api/jobadvertisement/getByIsActive"
    );
  }
}
