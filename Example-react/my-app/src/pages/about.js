import React from 'react';

export function AnimalsToAdd() {
  const [animalToAdd, setAnimalList] = React.useState([]);    
    
  return (
    <>
      <AnimalList animalToAdd={animalToAdd}/>
      <AddAnimal setAnimalList={setAnimalList}/>
    </>
  );
}

// function TodoCount() {
//   return <div>What animals would you like to see on our site?</div>;
// }

function AnimalList({animalToAdd}) {

  return (
    <ul>
      {animalToAdd.map((anim, i) => (
        <li key={"item" + i}>{anim}</li>
      ))}
    </ul>
  );
}

//Lifting state: 
/*
When thinking about state, it is encapuslated by the component that contains it - it normally cannot be accessed
by another component directly. But, there is a way to pass state from one component to another (parent to child).
Using this method we'll have components that can share data 
*/

function AddAnimal({setAnimalList}) {
  function handleSubmit(event) {
    event.preventDefault();
    const animal = event.target.elements.animal.value;
    setAnimalList(prevAnimals => [...prevAnimals, animal]);
  }

  return (
    <form onSubmit={handleSubmit}>
      <input type="text" id="animal" />
      <button type="submit">Add Animal</button>
    </form>
  );
}

