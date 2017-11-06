 var React = require('react');
var ReactRouter = require('react-router');


function Logging (props) {
  return (
    <div className="jumbotron col-sm-12 text-center" >
      <h1>{props.header}</h1>
      <form onSubmit={props.onSubmitUser}>
      <p className='lead'>Email/Username</p>
      <input
              id="insert-email"
              className='form-control'
              onChange={props.onUpdateEmail}
              placeholder='email'
              type='text'
              value={props.email} />
      <p className='lead'>Password</p>
      <input
              id="insert-pass"
              className='form-control'
              onChange={props.onUpdatePassword}
              placeholder='password'
              type='text'
              value={props.password} />
       <div className="form-group col-sm-4 col-sm-offset-4">
            <button
              className="btn btn-block btn-success"
              type="submit">
                Submit
            </button>
          </div>
      </form>
    </div>
  )
}

module.exports = Logging;