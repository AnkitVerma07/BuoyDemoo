var React = require('react');
var ReactRouter = require('react-router');
var Link = ReactRouter.Link


function Buoy (props) {
  console.log(props);
  return (
    <form onSubmit={props.onSubmitUser}>
    <div className="jumbotron col-sm-12 text-center" >
    <h1>{props.header}</h1>
    <p className='lead'>stationId : {props.stationId}</p>
    <p className='lead'>airtemperature : {props.airtemperature}</p>
    <p className='lead'>averageperiod : {props.averageperiod}</p>
    <p className='lead'>atmospherepressure : {props.atmospherepressure}</p>
    <p className='lead'>date : {props.date}</p>
    <p className='lead'>dewpoint : {props.dewpoint}</p>
    <p className='lead'>dominantwaveperiod : {props.dominantwaveperiod}</p>
    <p className='lead'>location : {props.location}</p>
    <p className='lead'>meanwavedirection : {props.meanwavedirection}</p>
    <p className='lead'>pressuretendency : {props.pressuretendency}</p>
    <p className='lead'>significantwaveheight : {props.significantwaveheight}</p>
    <p className='lead'>station_location : {props.station_location}</p>
    <p className='lead'>watertemperature : {props.watertemperature}</p>
    <p className='lead'>winddirection : {props.winddirection}</p>
    <p className='lead'>windgust : {props.windgust}</p>
    <p className='lead'>windspeed : {props.windspeed}</p>
   </div> 
          <div className="form-group col-sm-4 col-sm-offset-4">
            <button
              className="btn btn-block btn-success"
              type="submit">
                Add To Favorite
            </button>
          </div>
   </form>
  )
}

module.exports = Buoy;