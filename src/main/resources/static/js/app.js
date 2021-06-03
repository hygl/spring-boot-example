class App extends React.Component { 

	constructor(props) {
		super(props);
		this.state = {posts: []};
	}

	componentDidMount() { 
		fetch("http://localhost:8080/api/posts").then(res => res.json())
        .then(data => {
		  this.setState({ posts: data._embedded.posts })
        })
        .catch(console.log)
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