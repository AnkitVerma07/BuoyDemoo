var React = require('react');
var ReactRouter = require('react-router');
var Link = ReactRouter.Link


function Logout (props) {
  return (
    <div className="jumbotron col-sm-12 text-center" >
      <Link to='/'>
        <button type='button' className='btn btn-lg btn-success'>{props.route.header}</button>
      </Link>
    </div>
  )
}

module.exports = Logout;