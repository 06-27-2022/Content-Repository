import React from 'react';

/*
Props: basically just properties - it's a way for components to pass info to
other components. Something to now is that every component has props - because
props are just objects that hold info about that component.
*/

export function Section(props) {
    //State: State is something that inherent to the component, similar to a property, 
    //but the state is decided by the component itself - you would want to use state
    //when you might want the info that is being used to change. 
    const [showInfo, setShowInfo] = React.useState(false);
    //What is Hook: Hook is a special function that lets you "hook into" react features that
    //you otherwise would not be able to use. For example, useState is a hook that let's you add
    //state to function components. One thing to note about hooks is that you can only
    //call hooks from react functions.
    //useState declares a "state variable" - this gives us a way to preserve this value between 
    //function calls. Normally variables "disappear" when the function exits but state variables
    //are preserved.
  
    function toggleInfo(){
      setShowInfo(!showInfo);
    }
  
    if(!showInfo){
      return (
        <div id={props.sectionId} className="section">
          <h2>{props.name}</h2>
          <img src={props.url} height="200px" width="200px"/>
          <button onClick={toggleInfo} type="button">{props.buttonText}</button>
        </div>
      );
    } else {
      return (
        <div>
          <p>Additional info!</p>
        </div>
      );
    }
  
  }