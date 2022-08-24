import React from 'react';

//Context: provides a way to pass data between components without having to 
//pass down props manually at every level in the component tree simply referring to the 
//component hierarcy (parent and child components)
//Usually data is passed top-down from parent to child via props, but we don't always necessarily
//want to follow this hierarchy, especially if what we want is to send data between many components
//Context provides a way to share values between components without having to explicitly
//pass a prop through every level  of the tree

//Just to add a note here about how data normally flows in a react app: In React normally data
//flows in only one direction, from parent to child down the heirarchy (the component tree)
//But just a brief reminder, we have seen a few ways to circumvent the usual data flow. Using 
//context or lifting state, for example, we can get around the usual data flow and pass info
//to unrelated components (as in they don't have a parent-child relationship) or from child
//to parent. Aside from these 2 techniques, there are other ways you can do the same thing 

export const buttonThemes = {
    primary: {
        color: "white",
        background: "#45c496"
    },
    secondary: {
        color: "white",
        background: "#d91b42"
    }
}

export const ButtonThemeContext = React.createContext(
    buttonThemes.primary
)

//context provider - as the name implies this component is what we will use to implement
//the context in our app
export function ButtonColorChange() {
    //local state variable buttonTheme; users will be able to change the theme color of the button
    //the change is tied to the changeTheme() method
    const [buttonTheme, setButtonTheme] = React.useState(buttonThemes.primary);

    function changeTheme() {
        setButtonTheme(
            buttonTheme === buttonThemes.primary ? buttonThemes.secondary : buttonThemes.primary
        )
    }

    //The important point is the value we pass to the ButtonThemeContext.Provider. 
    //when the value changes, the entire component within the provider re-renders. This calue
    //is tied to the atte variable buttonTheme
    return (
        <div>
            <ButtonThemeContext.Provider value={buttonTheme}>
                <ButtonContainer/>
            </ButtonThemeContext.Provider>
            <button onClick={changeTheme}>Click here!</button>
        </div>
    );
}

//container for the themed button 
function ButtonContainer() {
    return (
        <React.Fragment>
            <ThemedButton/>
        </React.Fragment>
    );
}

//THis is known as the react context consumer - here is where we use the useContext react hook
//to access the current context value. useCOntext hook returns the value of the context. This hook also
//re-renders the component when the value of the context changes, so that the change can be seen on the browser. 
//We will use it to dynamically style the button
function ThemedButton() {
    const theme = React.useContext(ButtonThemeContext);
    return (
        <button style={{backgroundColor: theme.background, 
        color: theme.color}}>My favorite animal</button>
    );
}
