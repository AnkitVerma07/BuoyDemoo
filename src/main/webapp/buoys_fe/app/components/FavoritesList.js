var React = require('react');
var ReactRouter = require('react-router');
var Link = ReactRouter.Link


function FavoritesList (props) {
   	return (
        <div className="jumbotron col-sm-12 text-center" >
    <h2>{props.header}</h2>
        <ul>
              {props.favList.map(function(buoy,index) {
             return (
             <div className="jumbotron col-sm-12 text-center" >
             <li key={index}>
                <p>{buoy.id} + Date + {buoy.date}</p>
                <p>Location</p>
                <p>{buoy.location}</p>
             </li>
             </div>       
             )
      })}
        </ul>
        </div>
        );

}



module.exports = FavoritesList;