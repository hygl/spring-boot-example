const React = require('react');
const ReactDOM = require('react-dom'); 
const client = require('./client'); 

class App extends React.Component { 

	constructor(props) {
		super(props);
		this.state = {posts: []};
	}

	componentDidMount() { 
		client({method: 'GET', path: '/api/posts'}).done(response => {
			this.setState({posts: response.entity._embedded.posts});
		});
	}

	render() { 
		return (
			<PostList posts={this.state.posts}/>
		)
	}
}

class PostList extends React.Component{
	render() {
		const posts = this.props.posts.map(post =>
			<Post key={post._links.self.href} post={post}/>
		);
		return (
			<table>
				<tbody>
					<tr>
						<th>Title</th>
						<th>Text</th>
						<th>Date</th>
					</tr>
					{posts}
				</tbody>
			</table>
		)
	}
}



class Post extends React.Component{
	render() {
		return (
			<tr>
				<td>{this.props.post.title}</td>
				<td>{this.props.post.text}</td>
				<td>{this.props.post.date}</td>
			</tr>
		)
	}
}

ReactDOM.render(
	<App />,
	document.getElementById('react')
)