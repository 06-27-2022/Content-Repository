import './App.css';
import React from 'react';

//there is another type of component called a class component
//Just so you know, the class component is still seen, however the function component 
//is the better way to utilize components in React
export class WeLovePandas extends React.Component {
  render() { //this is a method that will render our view
    return <h1>Pandas are the best!</h1>;
  }
}

//This PandaPics function is a component - basically a component is just a function that
//represents a tiny portion of the view along with it's logic
//this is technically a function component

//Event Handling: JSX can also handle event listeners - it's actually really common in 
//react apps. We can create an event listener by giving the JSX element a special attribute 
//that begins with the word 'on'. First step we should create a method that can be passed
// to the event listener


export function PandaPics() {
  //when writing funcitons need to write function keyword
  function handleClick() {
   alert("Don't touch the picture!");
  }

  const pics = {
    panda:"https://media.istockphoto.com/photos/cute-panda-bear-climbing-in-tree-picture-id523761634?k=20&m=523761634&s=612x612&w=0&h=fycQb31QlRoNLdJWWddooJ94a-54YLYQ3ggTLPkhvmk=",
    owl: "https://images.pexels.com/photos/53977/eagle-owl-raptor-falconry-owl-53977.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"
  };
  const sideLength = "200px";

  const panda = (
    <img 
      src={pics.panda} 
      alt="cute panda" 
      onClick={handleClick}
      height={sideLength} 
      width={sideLength}/>
  );

  return <p>I love pandas!!!!!!!! {panda}</p>;
}
//export default PandaPics;

//Here is an example of using lists in JSX - basically a list is a list of elements
//(essentially an array). Let's display the list of items using the map() method
//Key: a key is an attribute, basically a unique identifier for elements in a list (the same
//concepet as the id attribute). Keys are used internally to keep track of lists; it's 
//only really necessary to use keys if the list items order is important, or if the 
//list items have "memory" from one render to the next (for example: if I have a to-do list
// and I need to keep track of the tasks I have completed)
export function Diet() {
  const foodItems = ["bamboo", "watermelon", "mangoes"];

  return (
    <div>
      <h3>Panda's daily diet: </h3>
      <ol>
        {foodItems.map((item, i) => (
          <li key={'food_' + i}>{item}</li>
        ))}
      </ol>
    </div>
  );
}