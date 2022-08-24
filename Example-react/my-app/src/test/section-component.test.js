//Jest: Jest is a JS testing framework
import React from 'react';
//react-test-renderer is a useful library that allows us to simulate rendering a react component,
//fire off events, and even unmount the component (with cleanup method) after running tests.
import {cleanup, render, screen} from '@testing-library/react';
import {Section} from '../components/section';

const TestComponent = () => {
    return (
        <Section sectionId="1" name="fillerName" url="fakeUrl" buttonText="Learn More"></Section>
    );
}

//"it" is just an alias for test, you can say either
//this test will be used to ascertain that the component renders properly
it('should render properly', () => {
    render(TestComponent())
    const button = screen.getByText('Learn More')
    expect(button).toBeVisible()
})
