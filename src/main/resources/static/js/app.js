'use strict';

// tag::vars[]
const React = require('react'); 
const ReactDOM = require('react-dom');

class App extends React.Component {

	constructor(props) {
		super(props);
		this.state = { posts: [] };
		// Register Sevice Worker
		if ("serviceWorker" in navigator) {
			navigator.serviceWorker
				.register("./sw.js", { scope: '/' })
				.then(ServiceWorkerRegistration => {
					console.log("Service Worker registered: ", ServiceWorkerRegistration);
				})
				.catch(error => {
					console.error("Error registering the Service Worker: ", error);
				});
		}

	}

	componentDidMount() {
		// Simple POST request with a JSON body using fetch
		fetch("http://localhost:8080/api/posts").then(res => res.json())
			.then(data => {
				this.setState({ posts: data._embedded.posts })
			})
			.catch(console.log)		
	}
	render() {
		return (
			<PostList posts={this.state.posts} />
		)
	}
}

class PostList extends React.Component {
	render() {
		const posts = this.props.posts.map(post =>
			<Post key={post._links.self.href} post={post} />
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



class Post extends React.Component {
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