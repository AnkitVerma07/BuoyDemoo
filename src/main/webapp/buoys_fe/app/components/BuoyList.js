var React = require('react');
var ReactRouter = require('react-router');
var Link = ReactRouter.Link


function BuoyList (props) {
   	return (
    <div className="jumbotron col-sm-12 text-center" >
      <h1>{props.header}</h1>
      <form onSubmit={props.onSubmitUser}>
      <p className='lead'>Longitude Value:</p>
      <input
              id="insert-lon"
              className='form-control'
              onChange={props.onUpdatelon}
              placeholder='lon'
              type='text'
              value={props.lon} />
      <p className='lead'>Latitude Value:</p>
      <input
              id="insert-lat"
              className='form-control'
              onChange={props.onUpdatelat}
              placeholder='lat'
              type='text'
              value={props.lat} />
      <p className='lead'>Radius Value:</p>
      <input
              id="insert-radius"
              className='form-control'
              onChange={props.onUpdateradius}
              placeholder='radius'
              type='text'
              value={props.radius} />
       <div className="form-group col-sm-4 col-sm-offset-4">
            <button
              className="btn btn-block btn-success"
              type="submit">
                Submit
            </button>
          </div>
      </form>


         <div className="jumbotron col-sm-12 text-center" >
    <h2> Result: </h2>
        <ul>
              {props.buoyList.map(function(buoy,index) {
             return (
             <div className="jumbotron col-sm-12 text-center" >
             <Link to={{ pathname: '/buoys', query: { the : props.userId , ok : buoy.id } }}>
             <li key={index}>
                <p>ID: {buoy.id} : Date : {buoy.date}</p>
                <p>Location</p>
                <p>{buoy.location}</p>
             </li>
              </Link>
             </div>       
             )
})}
        </ul>
   </div>


      </div>
        );

}



module.exports = BuoyList;