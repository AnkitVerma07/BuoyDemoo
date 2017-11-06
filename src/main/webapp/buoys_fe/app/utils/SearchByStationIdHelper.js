var axios = require('axios');


var helpers = {
	getBuoy: function(stationId){
		return axios.get('http://localhost:8080/BuoysDemoo/demoapi/buoyInfo/getBuoy/' + stationId)
  .then(function (response) {
    return response.data;
  })
  .catch(function (error) {
    console.log(error);
  });

	}
};

module.exports = helpers;
