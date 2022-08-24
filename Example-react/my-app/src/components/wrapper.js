/*
High Order Components: just a fancy way to say passing a component as a property (prop) - or passing a 
component to another component and returning a new component. 

With the components you pass into the high order component, you can format the component with props
and you can also change the functionality of whatever component you pass in. 
*/

import React from 'react';

export const wrapper = (Component) => ({...props}) => (
    <div style={{border: '2px solid blue', borderRadius: '3px'}}>
        <Component {...props}/>
    </div>

);