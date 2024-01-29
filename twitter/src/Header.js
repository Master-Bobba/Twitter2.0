import React from 'react';
import { Link } from 'react-router-dom';

const Header = () => {
  return (
    <header className="bg-dark text-light p-3">
      <h1><Link to="/">Twitter 2.0</Link></h1>
    </header>
  );
};

export default Header;