var React = require('react');
var ReactRouter = require('react-router');
var Link = ReactRouter.Link


function Login () {
  return (
    <div className="jumbotron col-sm-12 text-center" >
      <h1>Buoys Demo</h1>
      <p className='lead'>Please Signup/Login</p>
      <Link to='/signup'>
        <button type='button' className='btn btn-lg btn-success'>SIGN UP</button>
      </Link>
      <Link to='/logging'>
        <button type='button' className='btn btn-lg btn-success'>LOG IN</button>
      </Link>
    </div>
  )
}

module.exports = Login;