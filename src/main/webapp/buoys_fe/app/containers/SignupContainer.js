var React = require('react');
var Signup = require('../components/Signup');
var SignupHelper = require('../utils/SignupHelper');

var SignupContainer = React.createClass({
  contextTypes: {
    router: React.PropTypes.object.isRequired
  },
  getInitialState: function () {
    return {
      firstName: '',
      lastName: '',
      email: '',
      password:'',
      userId:''
    }
  },
  handleSubmitUser: function (e) {
    e.preventDefault();
    var firstName = this.state.firstName;
    var lastName = this.state.lastName;
    var email = this.state.email;
    var password = this.state.password;

    var userData = {
      first_name: firstName,
      last_name: lastName,
      email: email,
      password: password
    };

    SignupHelper.insertUser(userData)
    .then(function(userId){
      console.log(userId);
      this.context.router.push('/home/' + userId)
    }.bind(this))
  },
  handleUpdateFirstName: function (event) {
    this.setState({
      firstName: event.target.value
    });
  },
  handleUpdateLastName: function (event) {
    this.setState({
      lastName: event.target.value
    });
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
      <Signup
        onSubmitUser={this.handleSubmitUser}
        onUpdateFirstName={this.handleUpdateFirstName}
        onUpdateLastName={this.handleUpdateLastName}
        onUpdateEmail={this.handleUpdateEmail}
        onUpdatePassword={this.handleUpdatePassword}
        header={this.props.route.header}
        firstName={this.state.firstName}
        lastName={this.state.lastName}
        email={this.state.email}
        password={this.state.password}
        userId={this.state.userId}
         />
    )
  }
});

module.exports = SignupContainer;