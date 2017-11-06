var React = require('react');
var SearchByStationId = require('../components/SearchByStationId');
var SearchByStationIdHelper = require('../utils/SearchByStationIdHelper');

var SearchByStationIdContainer = React.createClass({
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
      userId:''
    }
  },
  handleSubmitUser: function (e) {
    e.preventDefault();
    var stationId = this.state.stationId;

    SearchByStationIdHelper.getBuoy(stationId)
    .then(function(response){
      console.log(response.stationId);
            this.setState({
      stationId: response.station_id,
      airtemperature: response.airTemperature,
      atmospherepressure: response.atmospherePressure,
      averageperiod: response.averageperiod,
      date: response.date,
      dewpoint: response.dewpoint,
      dominantwaveperiod: response.dominantwaveperiod,
      location: response.location,
      meanwavedirection: response.meanwavedirection,
      pressuretendency: response.pressuretendency,
      significantwaveheight: response.significantwaveheight,
      station_location: response.station_location,
      watertemperature: response.watertemperature,
      winddirection: response.winddirection,
      windgust: response.windgust,
      windspeed: response.windspeed
    })
    }.bind(this))
  },
  handleUpdateStationId: function (event) {
    this.setState({
      stationId: event.target.value,
      userId: this.props.location.query.the
    });
  },
  render: function () {
    return (
      <SearchByStationId
        onSubmitUser={this.handleSubmitUser}
        onUpdateStationId={this.handleUpdateStationId}
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
         />
    )
  }
});

module.exports = SearchByStationIdContainer;

