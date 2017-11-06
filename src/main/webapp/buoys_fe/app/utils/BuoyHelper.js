var axios = require('axios');


var helpers = {
insertFavBuoy: function(userId, buoyId){
		return axios.get('http://localhost:8080/BuoysDemoo/demoapi/buoyInfo/insertFavBuoy/' + userId + '/' + buoyId)
  .then(function (response) {
    return response.data;
  })
  .catch(function (error) {
    console.log(error);
  });

	},
getBuoy: function(buoyid){
		return axios.get('http://localhost:8080/BuoysDemoo/demoapi/buoyInfo/getBuoyInfo/' + buoyid)
  .then(function (response) {
    return response.data;
  })
  .catch(function (error) {
    console.log(error);
  });

	}
};

module.exports = helpers;
