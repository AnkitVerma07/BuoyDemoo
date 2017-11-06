var React = require('react');
var FavoritesList = require('../components/FavoritesList');
var FavoritesListHelper = require('../utils/FavoritesListHelper');

var FavoritesListContainer = React.createClass({
  contextTypes: {
    router: React.PropTypes.object.isRequired
  },
  getInitialState: function () {
    return {
      favList:[],
      userId:''
    }
  },
  componentDidMount: function (e) {
    console.log('id', this.props.routeParams.userId);
    FavoritesListHelper.getFavList(this.props.routeParams.userId)
    .then(function(response){
    this.setState({
      favList: response.list
    })
    }.bind(this))
  },
  render: function () {
    return (
      <FavoritesList
        favList={this.state.favList}
        header={this.props.route.header}
        userId={this.state.userId}
         />
    )
  }
});

module.exports = FavoritesListContainer;

