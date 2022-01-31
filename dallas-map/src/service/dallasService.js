import axios from "axios";

class DallasService {
  findHouses(lng, lat, radius) {
    return axios.get(`https://dallas-backend.herokuapp.com/dallas/${lng}/${lat}/${radius}`);
  }
}

export default new DallasService();
