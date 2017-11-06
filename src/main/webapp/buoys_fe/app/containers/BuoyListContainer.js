var React = require('react');
var BuoyList = require('../components/BuoyList');
var BuoyListHelper = require('../utils/BuoyListHelper');
var XmlReader = require('xml-reader');
var reader = XmlReader.create();

var BuoyListContainer = React.createClass({
  contextTypes: {
    router: React.PropTypes.object.isRequired
  },
  getInitialState: function () {
    return {
      stationId: '',
      airtemperature: '',
      atmospherepressure: '',
      averageperiod: '',
      date: '',
      dewpoint: '',
      dominantwaveperiod: '',
      location: '',
      meanwavedirection: '',
      pressuretendency: '',
      significantwaveheight: '',
      station_location: '',
      watertemperature: '',
      winddirection: '',
      windgust: '',
      windspeed: '',
      lon: '',
      lan: '',
      radius: '',
      buoyList: [],
      userId:''
    }
  },
  handleSubmitUser: function (e) {
    e.preventDefault();
    var lon = this.state.lon;
    var lat = this.state.lat;
    var radius = this.state.radius;


     BuoyListHelper.getBuoyList(lon,lat,radius)
     .then(function(response){
         this.setState({
      buoyList: response.list
    });
    }.bind(this))
  },
  handleUpdatelon: function (event) {
    this.setState({
      lon: event.target.value
    });
  },
    handleUpdatelat: function (event) {
    this.setState({
      lat: event.target.value
    });
  },
    handleUpdateradius: function (event) {
    this.setState({
      radius: event.target.value,
      userId: this.props.routeParams.userId
    });
  },
  render: function () {
    return (
      <BuoyList
        onSubmitUser={this.handleSubmitUser}
        onUpdatelon={this.handleUpdatelon}
        onUpdatelat={this.handleUpdatelat}
        onUpdateradius={this.handleUpdateradius}
        header={this.props.route.header}
        stationId={this.state.stationId}
        airtemperature={this.state.airtemperature}
        averageperiod={this.state.averageperiod}
        atmospherepressure={this.state.atmospherepressure}
        date={this.state.date}
        dewpoint={this.state.dewpoint}
        dominantwaveperiod={this.state.dominantwaveperiod}
        location={this.state.location}
        meanwavedirection={this.state.meanwavedirection}
        pressuretendency={this.state.pressuretendency}
        significantwaveheight={this.state.significantwaveheight}
        station_location={this.state.station_location}
        watertemperature={this.state.watertemperature}
        winddirection={this.state.winddirection}
        windgust={this.state.windgust}
        windspeed={this.state.windspeed}
        userId={this.state.userId}
        lon={this.state.lon}
        lat={this.state.lat}
        radius={this.state.radius}
        buoyList={this.state.buoyList}
         />
    )
  }
});

module.exports = BuoyListContainer;

