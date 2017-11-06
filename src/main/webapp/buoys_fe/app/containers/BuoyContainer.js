var React = require('react');
var Buoy = require('../components/Buoy');
var BuoyHelper = require('../utils/BuoyHelper');

var BuoyContainer = React.createClass({
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
      buoyId: '',
      userId:''
    }
  },
  handleSubmitUser: function (e) {
    e.preventDefault();
     BuoyHelper.insertFavBuoy(this.props.location.query.the, this.props.location.query.ok)
     .then(function(response){
      this.context.router.push('/home/' + this.props.location.query.the)
    }.bind(this))
  },
  componentDidMount: function (e) {
    BuoyHelper.getBuoy(this.props.location.query.ok)
    .then(function(response){
      console.log('response', response)
    this.setState({
      stationId: response.station_id,
      airtemperature: response.airTemperature,
      atmospherepressure: response.atmospherePressure,
      averageperiod: response.averagePeriod,
      date: response.date,
      dewpoint: response.dewPoint,
      dominantwaveperiod: response.dominantWavePeriod,
      location: response.location,
      meanwavedirection: response.meanWaveDirection,
      pressuretendency: response.pressureTendency,
      significantwaveheight: response.significantWaveHeight,
      station_location: response.station_location,
      watertemperature: response.waterTemperature,
      winddirection: response.windDirection,
      windgust: response.windGust,
      windspeed: response.windSpeed
    })
    }.bind(this))
  },
  render: function () {
    return (
      <Buoy
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
        buoyId={this.state.buoyId}
         />
    )
  }
});

module.exports = BuoyContainer;

