import logo from './logo.svg';
import './App.css';
import Header from './Header';
import Footer from './Footer';
import LeftMenu from './LeftMenu';
import { Routes, Route } from 'react-router-dom';
import Feed from './Feed';
import 'bootstrap/dist/css/bootstrap.min.css';

function App() {
  return (
    <div className="d-flex flex-column min-vh-100">
      <Header />
      <div className="d-flex flex-grow-1">
      <LeftMenu />
        <div className="flex-grow-1 p-3" id="mainComponent">
          <Routes>

            <Route exact path="/" element={ <Feed />} />
            <Route exact path="/posts" element={ <Feed />} />
          </Routes>
        </div>
      </div>
      <Footer />
    </div>
  );
}

export default App;
