var React = require('react');
var ReactRouter = require('react-router');
var Router = ReactRouter.Router;
var Route = ReactRouter.Route;
var hashHistory = ReactRouter.hashHistory;
var IndexRoute = ReactRouter.IndexRoute;
var Main = require('../components/Main');
var HomeContainer = require('../containers/HomeContainer');
var Login = require('../components/Login');
var SignupContainer = require('../containers/SignupContainer');
var LoginContainer = require('../containers/LoginContainer');
var SearchByStationIdContainer = require('../containers/SearchByStationIdContainer');
var BuoyListContainer = require('../containers/BuoyListContainer');
var BuoyContainer = require('../containers/BuoyContainer');
var FavoritesListContainer = require('../containers/FavoritesListContainer');
var Logout = require('../components/Logout');

var routes = (
  <Router history={hashHistory}>
    <Route path='/' component={Main}>
      <IndexRoute component={Login} />
      <Route path='logout' header='You are now logged out!' component={Logout} /> 
      <Route path='signup' header='SIGNUP For Buoys Demo' component={SignupContainer} />
      <Route path='home/:userId' header='Buoys Demo Home Page' component={HomeContainer} />
       <Route path='logging' header='Please LOG IN'component={LoginContainer} />
       <Route path='buoyList/:userId'  header='Look up Buoys near you' component={BuoyListContainer} />
        <Route path='buoys' path='/:the' path='/:ok' header='Selected Buoy' component={BuoyContainer} />
      <Route path='favorites/:userId' header='Favorite List' component={FavoritesListContainer} />
          
     <Route path='searchByStationId/:userId' header='Look up Buoys with a station ID' component={SearchByStationIdContainer} />


    </Route>
  </Router>
);

module.exports = routes;