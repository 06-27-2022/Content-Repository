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

// /
//  * Single Page Applications: 
//  * A single page appliaciton is just an app that loads a single HTML page and all the 
//  * neccessary files, or assets (like JS or CSS) which a re needed for the app to run are
//  * all loaded at once. Rather than having or requesting different HTML files from the server,
//  * React will swap out the existing HTML on the page with other content that has been
//  * pre-loaded. THis gives the illusion of page navigation without actually having to make
//  * another request to the server. This tends to be the fast way, because you don't have to wait
//  * for the request to be received, since all the data the app needs is already pre-loaded.
//  * React Router is a way you can creat the navigation between these different views in React. 
//  * React Router is a declarative model for navigational components in you app - we will be using
//  * react-router-dom which is specific support for web apps
//  * /


//import React from 'react';
import React from 'react';
import ReactDOM from 'react-dom/client';
import {Routes, Route, BrowserRouter} from 'react-router-dom';
//we need to import ReactDOM beacuse it contains necessary method to manipulate the DOM
//In other words, this library is how we will be able to render our react app to the 
//Browser. Just to clarify - the DOM is used in Reacts apps, but it's not part of React
import './index.css';
import { AboutUs, Shop, Sponsors } from './App';
import { Site } from './App';
// import App from './App';
// import reportWebVitals from './reportWebVitals';

// // If you want to start measuring performance in your app, pass a function
// // to log results (for example: reportWebVitals(console.log))
// // or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
// reportWebVitals();

//this is a library that contains react-specific methods that all interact with the DOM
//in various ways

//React apps are not by default single page appliactions - if you want to make your react
//app a SPA, there are various ways - the way I chose is to use React Router
//The BrowserRouter uses the HTML5 history API to keep the UI in sync with the URL
//Each Route tag represnts a renderable component
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <div>
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Site/>}/>
        <Route path="/shop" element={<Shop/>}/>
        <Route path="/about" element={<AboutUs/>}/>
        <Route path="/sponsors" element={<Sponsors/>}/>
      </Routes>
    </BrowserRouter>
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


