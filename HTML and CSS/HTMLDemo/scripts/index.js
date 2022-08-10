/**
 * We want to add our event listener to our h1 again, but this time, we want to do so by creating variables and functions in this script so that they exist every single time we load the index.html file in the browser.
 */

 //Selecting the h1 element on DOM (Document Object Model)
 let h1 = document.querySelector('h1')

 //Adding an event listener to that h1 to respond to a user's click on the frontend

 let hasBeenClicked = false

 h1.addEventListener('click', () => {
     if(!hasBeenClicked){
        h1.style.color = 'green'
        h1.innerText = 'We swapped it!'
     }else{
         h1.style.color = "red"
         h1.innerText = "Welcome To Polkaman!"
     }

     hasBeenClicked = !hasBeenClicked
 })

 /**
  * We want to give the end user the ability to submit a
  * new Polkaman using our newly added form. This means
  * that we should isolate our steps to figure out what
  * we need. We need:
  * 
  * 1) An event listener on our "Submit Polkaman" button
  * so that when it is clicked we can invoke some sort of
  * function in response to the click.
  * 
  * 2) We need to select the DOM elements that will be
  * altered after the user clicks the button.
  * 
  * 3) If your intention is to add new objects to the
  * DOM, you need to create those using JS as there is
  * a way to create elements using JS.
  */

  //Isolating the elements I need to alter/interact with:
  let table_body = document.getElementById('polka_table_body')

  let submit_button = document.querySelector('[type=button')

//Let's attach the event listener:
submit_button.addEventListener('click', () => {

    //Creating the elements I would like to attach to the table body.
    let table_row = document.createElement('tr')
    let name_data = document.createElement('td')
    let ability_data = document.createElement('td')

  //I have to create a relationship between these elements. The idea is that tds go inside of a tr.

    table_row.append(name_data)
    table_row.append(ability_data)

    //add a new row to the table when the button is
    //clicked, first filling out the tds with whatever
    //values are present in the input boxes.
    let inputBoxes = document.querySelectorAll('[type=text]')

    let polka_name = inputBoxes[0].value
    let polka_ability = inputBoxes[1].value

    name_data.innerText = polka_name
    ability_data.innerText = polka_ability

    table_body.append(table_row)

})

/**
 * Let us add another event listener to an element on this
 * page. We will add event listeners to our ol (ordered list).
 * We'll add 2 events.
 */

 let first_li = document.getElementById('food')
 let ordered_list = document.querySelector('ol')

 /**
  * Note that is impossible to click on the first li
  * without clicking on the ordered list itself. If
  * both elements have event listeners attached to them,
  * clicking on the li will actually dispatch 2 events.
  * 
  * The order in which this is going to naturally occur
  * is from the innermost element to the outermost
  * element. This is called "bubbling".
  * 
  * It is possible to reverse this order; if you want
  * the outermost events to be dispatched first, you 
  * can do so. In order to do, you can pass in an optional
  * 3rd argument to the addEventListener function. This
  * reverses the order in which events are dispatched.
  * This is called "capturing".
  */

 first_li.addEventListener('click', () => {
   window.alert('You clicked the first list item!')
 })

 ordered_list.addEventListener('click', () => {
   window.alert('You clicked the ordered list!')
 }, true)

