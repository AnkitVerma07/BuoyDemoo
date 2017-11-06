var axios = require('axios');


var helpers = {
getFavList: function(userId){
		return axios.get('http://localhost:8080/BuoysDemoo/demoapi/userInfo/getFavList/' + userId)
  .then(function (response) {
    return response.data;
  })
  .catch(function (error) {
    console.log(error);
  });

	}
};

module.exports = helpers;
