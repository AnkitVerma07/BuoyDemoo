var React = require('react');
var PropTypes = React.PropTypes;

function Signup (props) {
  return (
    <div className="jumbotron col-sm-6 col-sm-offset-3 text-center">
      <h1>{props.header}</h1>
      <div className="col-sm-12">
        <form onSubmit={props.onSubmitUser}>
          <div className="form-group">
            <p className='lead'>First Name</p>
            <input
              id="insert-firstname"
              className='form-control'
              onChange={props.onUpdateFirstName}
              placeholder='first name'
              type='text'
              value={props.firstName} />
          </div>
          <div className="form-group">
            <p className='lead'>Last Name</p>
            <input
              id="insert-lastname"
              className='form-control'
              onChange={props.onUpdateLastName}
              placeholder='last name'
              type='text'
              value={props.lastName} />
          </div>
           <div className="form-group">
            <p className='lead'>Email/Username</p>
            <input
              id="insert-email"
              className='form-control'
              onChange={props.onUpdateEmail}
              placeholder='e mail'
              type='text'
              value={props.email} />
          </div>
          <div className="form-group">
            <p className='lead'>Choose a Password</p>
            <input
              id="insert-password"
              className='form-control'
              onChange={props.onUpdatePassword}
              placeholder='password'
              type='text'
              value={props.password} />
          </div>
          <div className="form-group col-sm-4 col-sm-offset-4">
            <button
              className="btn btn-block btn-success"
              type="submit">
                Register
            </button>
          </div>
        </form>
      </div>
    </div>
  )
}

Signup.propTypes = {
  onSubmitUser: PropTypes.func.isRequired,
  onUpdateFirstName: PropTypes.func.isRequired,
  onUpdateLastName: PropTypes.func.isRequired,
  onUpdateEmail: PropTypes.func.isRequired,
  onUpdatePassword: PropTypes.func.isRequired,
  header: PropTypes.string.isRequired,
  firstName: PropTypes.string.isRequired,
  lastName: PropTypes.string.isRequired,
  email: PropTypes.string.isRequired,
  password: PropTypes.string.isRequired
}


module.exports = Signup;