//Node: a JS runtime environment that allows you to execute JS code outside of a 
//web browser. It is built on a google Chrome V8 JS runtime environment which basically
//takes JS and translates it in the same way that the JVM translates Java into bytecode
//Node Package manager (npm): which has a library of thousands of packages (modules)
//basically it is a tool to help you build your projects, as it has everything from libraries
//to frameworks that you can use. These packages typically come in a folder called
//node_modules. Npm uses the command line to both install and manage packages

//What is React: it's a JS library (made by facebook) 
//it's used for creating front end UI for web apps
//Why React? One reason is because React renders elements on the page in a much more
//efficient way than direct DOM manipulation. It's more efficient because for every DOM
//object, in React there is a virtual DOM object. When you make a change to the DOM
//with React, React changes the virtual DOM object, then it compares the entire virtual DOM
//to a snapshot of the pre-updated version of the DOM, sees what is different, and then
//only updates those object that need to be changed on the real DOM. 


//import React from 'react';
import React from 'react';
import ReactDOM from 'react-dom/client';
//we need to import ReactDOM beacuse it contains necessary method to manipulate the DOM
//In other words, this library is how we will be able to render our react app to the 
//Browser. Just to clarify - the DOM is used in Reacts apps, but it's not part of React
import './index.css';
import { WeLovePandas } from './App';
import {PandaPics} from './App';
import { Diet } from './App';
// import App from './App';
// import reportWebVitals from './reportWebVitals';

// // If you want to start measuring performance in your app, pass a function
// // to log results (for example: reportWebVitals(console.log))
// // or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
// reportWebVitals();

//this is a library that contains react-specific methods that all interact with the DOM
//in various ways
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <div>
    <WeLovePandas/> 
    <PandaPics/>
    <h1>I am a header element</h1>
    <Diet/>
  </div>
);
//instantiating my class component: <WeLovePandas/>

//when using JSX there can only be 1 parent (outer) element. If you don't want to nest
//your elements in an outer div or span, or other parent element, you can use 
//<React.Fragment></React.Fragment>

//JSX: JavaScript XML: it's a syntax extension for JS, written specifically to be
//used with React. Basically it allows us to write HTML in React. It's not necessary to
//to use this syntax, but it makes your life easier. 
//It's an extension of JS, and is thus translated (compiled) into JS at runtime
//meaning, JSX is not valid JS - the web browser can't read it. JSX creates React "elements"


