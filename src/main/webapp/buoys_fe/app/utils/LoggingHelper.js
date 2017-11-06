var axios = require('axios');


var helpers = {
	validUser: function(email,password){
		return axios.get('http://localhost:8080/BuoysDemoo/demoapi/userInfo/validPassword/' + email + '/' + password)
  .then(function (response) {
    return response.data;
  })
  .catch(function (error) {
    console.log(error);
  });

	}
};

module.exports = helpers;
