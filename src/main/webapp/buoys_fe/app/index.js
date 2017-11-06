
var React = require('react');
var ReactDOM = require('react-dom');
var routes = require('./config/routes');
// var Raven = require('raven-js')

// var sentryKey = '58b4bcb4373444a5bfb3c32292e9ec34'
// var sentryApp='101666'
// var sentryURL='http://' + sentryKey + '@app.getsentry.com' + sentryApp

// var _APP_INFO = {
//   name: 'Github Battle',
//   branch: 'video4',
//   version: '1.0'
// }

// Raven.config(sentryURL, {
//   release: _APP_INFO.version,
//   tags: {
//     branch: _APP_INFO.branch,
//   }
//}).install()

ReactDOM.render(routes, document.getElementById('app'));

