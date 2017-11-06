var React = require('react');
var Logging = require('../components/Logging');
var LoggingHelper = require('../utils/LoggingHelper');

var LoginContainer = React.createClass({
  contextTypes: {
    router: React.PropTypes.object.isRequired
  },
  getInitialState: function () {
    return {
      email: '',
      password:'',
      userId:''
    }
  },
  handleSubmitUser: function (e) {
    e.preventDefault();
    var email = this.state.email;
    var password = this.state.password;

    LoggingHelper.validUser(email,password)
    .then(function(response){
      if(response === 'Email does not exist'){
        alert ('Email does not exist');
      } else if ( response === 'wrong password..'){
        alert ('wrong password..');
      } else if ( response === 'nothing worked..'){
        alert ('oops! something went wrong, try again..');
      } else {
           var userId = response;
           this.context.router.push('/home/' + userId)
      }
    }.bind(this))
  },
  handleUpdateEmail: function (event) {
    this.setState({
      email: event.target.value
    });
  },
  handleUpdatePassword: function (event) {
    this.setState({
      password: event.target.value
    });
  },
  render: function () {
    return (
      <Logging
        onSubmitUser={this.handleSubmitUser}
        onUpdateEmail={this.handleUpdateEmail}
        onUpdatePassword={this.handleUpdatePassword}
        header={this.props.route.header}
        email={this.state.email}
        password={this.state.password}
        userId={this.state.userId}
         />
    )
  }
});

module.exports = LoginContainer;