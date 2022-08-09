/**
 * You can (and will have to) use JavaScript to make HTTP
 * requests. For instance, we used Postman for the last
 * project to grab our JSON data. This time around, we'll
 * be using JavaScript to do so.
 * 
 * One of the most basic ways of making an HTTP request
 * with JavaScript entails using AJAX (Asynchronous JavaScript
 * and XML). Note that even thought AJAX can use XML to
 * exchange data between services, we will be using JSON.
 * 
 * When we use AJAX, we typically perform operations in
 * an asynchronous way; this means that the end user can
 * keep performing whatever operation they were performing
 * while we wait for a response from our server.
 * 
 * The core object that you will use with AJAX is called
 * the XMLHttpRequest.
 */

 /**
  * When making an XMLHttpRequest, there are 5 states in
  * which the request can exist:
  * 
  * 0: The XMLHttpRequest object has been created.
  * 1: The request has been opened
  * 2: The request has been sent
  * 3: The request has been received by the server
  * 4: The server has processed the request and that we are receiving a response
  */
 let xhr = new XMLHttpRequest() //state 0

 let url = 'https://pokeapi.co/api/v2/pokemon?limit=100&offset=0'

 /**
  * Once the request has been sent, we are simply waiting
  * for the response from the server. This means that we
  * are primarly concerned with ready state 4.
  */

  xhr.onreadystatechange = function() {

    if(xhr.readyState === 4 && xhr.status === 200){
        //JSON.parse takes JSON and turns it into a JS object for you.
        console.log(JSON.parse(xhr.response))
        let data = JSON.parse(xhr.response)
        //This is an array of Polkamans
        let polkamans = data.results
        //Isolating a single polkaman:
        console.log(polkamans[0].name)
        
    }
  }

 xhr.open('GET', url) //state 1
 xhr.send() //state 2




