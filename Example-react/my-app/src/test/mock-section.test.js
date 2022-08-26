/**
 * Do note that the extension for a Jest file is '.test.js'
 * 
 * Jest follows a BDD (Behavior Driven Development) style of testing. BDD emphasizes the behavior that is
 * tested by allowing us to specify at a high level what we are testing before we actually write our tests. 
 * This is useful for nontechnical members of dev teams (like business analysts) as BDD makes it easy
 * to understand what is being tested.
 * 
 */
import { screen } from "@testing-library/react";
import { wrapper } from "../components/wrapper";

/**
 * Mocking refers to creating dummy data to be used for testing purposes. You can mock entire modules in Jest
 * For example: if I wanted to test API, I could say: 
 * jest.mock('axios')
 * 
 */

//this is how we use the mock() method to mock a component
//keep in mind that this syntax is to be used specifically for named export components
//Note: there are 2 kinds of exports: named and default
//a default export is restrictuve, and there can only be one export per file
//a named export is an exportcan be used to export as many bindings as you want 
jest.mock('../App', () => ({
  Welcome: () => {
    const MockWelcome = "named-welcome-component-mock";
    return <MockWelcome id="mock123"/>
  }
}))

it('should receive the component', () => {
  wrapper(
    jest.mock('../App', () => ({
      Welcome: () => {
        const MockWelcome = "named-welcome-component-mock";
        return <MockWelcome id="mock123"/>
      }
    }))
  )
  const id = screen.findByTestId('mock123')
  expect(id).toBe;
})

