import React from 'react';
import axios from 'axios';
//Making HTTP Requests with React: 
/*
When making HTTP requests with react, there are a couple differet 
libraries you can use to do so: axios, fetch, or even ajax. We will be leveraging
the popular Axios library

Axios is an HTTP client library based on promises (though you don't strictly have to use
promises when using Axios). it makes sending asynchronous requests to REST endpoints easier
and helps you perform CRUD operations. One of the reasons why you would use Axios is because it
works well with JSON - you often don't need to set any headers or perform the annoying task of converting
a request body to a JSON string. 
*/

const allPosts = 'https://jsonplaceholder.typicode.com/posts'; //endpoint for getting all data

export function GetSponsors() {
    const [post, setPost] = React.useState([]);

    //hooks allow you to use state inside of function components
    React.useEffect(() => {
        axios.get(allPosts).then((response) => {
            setPost(response.data);
        });
    }, []);

    if (!post) return "no quotes!";

    return (
        <div>
            {post.map((p) => (
                <div key={p.id}>
                    <p>Quote#: {p.id}</p>
                    <p>From sponsor#: {p.userId}</p>
                    <p>Title: {p.title}</p>
                    <p>Inspirational quote: {p.body}</p>
                </div>
            ))}
        </div>
    );
}


export function AddPosts() {
    const [post, setPost] = React.useState(null);
    const [title, setTitle] = React.useState('');
    const [body, setBody] = React.useState('');

    const handleSubmit = (e) => {
        e.preventDefault();
        createPost(title, body);
    };


    React.useEffect(() => {
        axios.get(`${allPosts}/`).then((response) => {
            setPost(response.data);
            setTitle('');
            setBody('');
        });
    }, []);

    function createPost() {
        axios.post(allPosts, {
            title: title,
            body: body
        })
        .then((response) => {
            setPost(response.data);
            console.log(response.data);
        });
    }

    if (!post) return "no post requested!"

    return (
        <div>
            <form onSubmit={(e) => {handleSubmit(e)}}>
                <div>
                    <label htmlFor="title">Quote title: </label>
                    <input id="title" name="title" onChange={(e) => setTitle(e.target.value)}/>
                    <br/>
                    <label htmlFor="body">Enter Quote: </label>
                    <input id="body" name="body" onChange={(e) => setBody(e.target.value)}/>
                </div>
                <button type="submit">Add Quote</button>
            </form>
        </div>
    );

}

/*
Controlled and uncontrolled components: 
Controlled components: Basically it is when data is handled directly by a React component, 
which is why usually you hear this term associated with forms.. There is a type of form where the input
element's values values and mutations are driven by event handlers, and the value of the element
is inferred from the state

Uncontrolled component: when form data is handled by the DOM itself, not through the React
component. For examlpe, usually when we want to add a file as an input, in most cases you would use 
an uncontrolled component. 
*/
