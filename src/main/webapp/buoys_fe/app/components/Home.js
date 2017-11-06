var React = require('react');
var ReactRouter = require('react-router');
var Link = ReactRouter.Link


function Home (props) {
  return (
    <div className="jumbotron col-sm-12 text-center" >
      <h1>{props.header}</h1>
      <p className='lead'>Welcome!</p>
      <div className="jumbotron col-sm-12 text-center" >
        <button type='button' className='btn btn-lg btn-success' onClick={props.onSubmitsearchByStationId}>Search Bouy By Station ID</button>
      </div>
      <div className="jumbotron col-sm-12 text-center" >
        <button type='button' className='btn btn-lg btn-success' onClick={props.onSubmitbuoyList}>Look up Buoys</button>
      </div>
      <div className="jumbotron col-sm-12 text-center" >
        <button type='button' className='btn btn-lg btn-success' onClick={props.onSubmitfavorites}>My Favorite List</button>
      </div>
      <div className="jumbotron col-sm-12 text-center" >
        <button type='button' className='btn btn-lg btn-success' onClick={props.onSubmitlogout}>LOGOUT</button>
      </div>
    </div>
  )
}

module.exports = Home;