var React = require('react');
var Home = require('../components/Home');

var HomeContainer = React.createClass({
  contextTypes: {
    router: React.PropTypes.object.isRequired
  },
  getInitialState: function () {
    return {
      userId: ''
    }
  },
  handleSubmitsearchByStationId: function (e) {
    e.preventDefault();
     this.context.router.push('/searchByStationId/' + this.props.routeParams.userId)
  },
  handleSubmitbuoyList: function (e) {
    e.preventDefault();
     this.context.router.push('/buoyList/' + this.props.routeParams.userId)
  },
    handleSubmitfavorites: function (e) {
    e.preventDefault();
     this.context.router.push('/favorites/' + this.props.routeParams.userId)
  },
    handleSubmitLogout: function (e) {
    e.preventDefault();
     this.context.router.push('/logout')
  },
  render: function () {
    return (
      <Home
        onSubmitsearchByStationId={this.handleSubmitsearchByStationId}
        onSubmitbuoyList={this.handleSubmitbuoyList}
         header={this.props.route.header}
        onSubmitfavorites={this.handleSubmitfavorites}
        onSubmitlogout={this.handleSubmitLogout}
        userId={this.state.userId}
         />
    )
  }
});

module.exports = HomeContainer;