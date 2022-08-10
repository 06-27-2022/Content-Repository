/**
 * We previously used AJAX to make HTTP requests from within
 * our JS files. That said, AJAX is not the most modern
 * away of making HTTP requests with JavaScript. One of
 * the modern approaches is the "Fetch API".
 * 
 * We'll be using the same URL we used in the AJAX example.
 */

let url = 'https://pokeapi.co/api/v2/pokemon?limit=100&offset=0'

/**
 * In order to use Fetch, there is a basic function called
 * "fetch" which abstracts away a lot of the boilerplate
 * code we used with AJAX.
 */

//  fetch(url)
//     .then((response) => {return response.json()})
//     .then((data) => {console.log(data)})
//     .catch(() => {console.log("Ooops! Something went wrong!")})

/**
 * Technically speaking, when you use fetch, you're also
 * using JS Promises. Promises aim is to help developers
 * handle asynchronous operations more cleanly as the syntax
 * provides a clear way of handling data that that has been
 * asynchronously retrieved and handling any errors that might
 * occur. Also note that a Promise, as it handles async
 * data, simply promises that a value will exist at some point.
 * As such, we often say that Promises represent an eventual value.
 * 
 * Technically, we can "promisify" our AJAX HTTP requests.
 * Note that Fetch has actually promisified the HTTP request
 * we made for us.
 */

 let promise = new Promise(((resolve) => {

 }, (reject) => {}))

 /**
  * If you don't like Promises, you can avoid explicitly
  * dealing with them in JS by using async-await. These two
  * keywoards (async AND await) are used to remove the need
  * to explicitly call then() and catch(). In fact, using
  * async await allows for your code to read as if it is
  * truly synchronous.
  * 
  * In order to use the await keyword, you must be working within
  * the context of a function that is marked as async. An
  * async function performs some task asynchronously.
  */

  async function findAllPolkamans(){

    let response = await fetch(url)
    let data = await response.json()
    console.log(data)
  }


  //As a bonus for you, the onload property of the window object
  //in JS allows you to define actions that will immediately
  //take place whenever the window is loaded.
  window.onload = function(){
      this.findAllPolkamans()
  }

 