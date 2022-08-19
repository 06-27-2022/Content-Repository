import * as React from 'react';
import {Link} from 'react-router-dom';
//in react router - the Link element replaces the anchor tag
export function Nav(){
    return (
        <nav>
            <div>
                <ul className="navbar-nav">
                    <li className="nav-item">
                        <Link to="/">Home</Link>
                    </li>
                    <li className="nav-item">
                        <Link to="/shop">Shop</Link>
                    </li>
                    <li className="nav-item">
                        <Link to="/about">About Us</Link>
                    </li>
                </ul>
            </div>
        </nav>
    );
}