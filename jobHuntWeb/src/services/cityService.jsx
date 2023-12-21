import axios from "axios";

export default class cityService {
  getCity() {
    return axios.get("http://localhost:8100/api/city/getall");
  }
}
