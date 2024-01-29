import React from 'react';
import { Link } from 'react-router-dom';


const LeftMenu = () => {

    return (
        <aside className="bg-secondary text-light p-3">
        <h2>Left Menu</h2>
        <ul>
            <li><Link to="/posts">Posts</Link></li>
        </ul>
        </aside>
    );
};

export default LeftMenu;