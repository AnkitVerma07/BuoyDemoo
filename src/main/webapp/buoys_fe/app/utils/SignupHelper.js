var axios = require('axios');


var helpers = {
	insertUser: function(userData){
		console.log(userData);
		return axios.post('http://localhost:8080/BuoysDemoo/demoapi/userInfo/insertUser', userData)
  .then(function (response) {
    console.log(response);
    return response.data;
  })
  .catch(function (error) {
    console.log(error);
  });

	}
};

module.exports = helpers;
