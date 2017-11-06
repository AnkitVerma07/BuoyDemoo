var axios = require('axios');


var helpers = {
	getBuoyList: function(lon,lat,radius){
		return axios.get('http://localhost:8080/BuoysDemoo/demoapi/buoyInfo/getBuoyList/' + lon + '/' + lat + '/' + radius)
  .then(function (response) {
    return response.data;
  })
  .catch(function (error) {
    console.log(error);
  });

	}
};

module.exports = helpers;
