import './App.css';
import React from 'react';
import {Nav} from './components/nav'
import { GetSponsors, AddPosts } from './pages/quotes';
import { AnimalsToAdd } from './pages/about';
import {Section} from './components/section';
import {wrapper} from './components/wrapper'


//this is just a class for the animals we will add to the browser
class animal {
  constructor(name, url){
    this.name = name;
    this.url = url;
  }
}


export function Welcome() {
  return (
    <div>
      <h3>Animal Facts</h3>
    </div>
  );
}

function View() {
  let animals = [];
  let sections = [];
  let count = 0;

  animals.push(new animal('panda', 'https://media.istockphoto.com/photos/cute-panda-bear-climbing-in-tree-picture-id523761634?k=20&m=523761634&s=612x612&w=0&h=fycQb31QlRoNLdJWWddooJ94a-54YLYQ3ggTLPkhvmk='));
  animals.push(new animal('owl', 'https://images.pexels.com/photos/53977/eagle-owl-raptor-falconry-owl-53977.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500'));
  animals.push(new animal('manul', 'https://previews.123rf.com/images/igorpushkarev/igorpushkarev1905/igorpushkarev190500030/125775358-pallas-s-cat-otocolobus-manul-manul-is-living-in-the-grasslands-and-montane-steppes-of-central-asia-.jpg'));
  animals.push(new animal('kakapo', 'https://i.pinimg.com/originals/8d/a1/8b/8da18b11ea4c22c5479c3b9ab4e72782.jpg'));

  //this is a helper method so that we can render a new section easily and give each 
  //section the specified props 
  function renderSection(sectionId, name, url) {
    return (
      <Section
        sectionId={sectionId}
        name={name}
        url={url}
        key={count}
        buttonText={"Find out more about " + name + "s"}/>
    );
  }

  for(let a of animals){
    sections.push(renderSection(a.sectionId, a.name, a.url));
    count++;
  }

  return(
    <div className="container">
      {sections}
    </div>
  );
}



export function Site(){

const HeadingComponent = wrapper(Welcome);

  return (
    <div>
      <Nav/>
      <HeadingComponent/>
      <View/>
    </div>
  );
}

export function Shop(){
  return (
    <div>
      <Nav/>
      <p>Welcome to the shop!</p>
      <img 
      alt="shopping cart"
      src="https://th.bing.com/th/id/OIP.iDVurdWMV4YcAhqCEaT1bQHaHa?pid=ImgDet&rs=1"
      height="200px"
      width="200px"/>
    </div>
  );
}

export function AboutUs(){
  return (
    <div>
      <Nav/>
      <br/>
      <h2>About us</h2>
      <p>Our goal is to educate others about various animals' diet and behavior</p>
      <br/>
      <AnimalsToAdd/>
    </div>
  );
}

export function Sponsors(){
  return (
    <div>
      <Nav/>
      <br/>
      <AddPosts/>
      <br/>
      <GetSponsors/>
    </div>
  );
}

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
      <h1>Panda diet</h1>
      <ol>
        {foodItems.map((item, i) => (
          <li key={'food_' + i}>{item}</li>
        ))}
      </ol>
    </div>
  );
}