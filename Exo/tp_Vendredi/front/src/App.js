import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Login from './components/Login';
import Register from './components/Register';
import ProductList from './components/ProductList';
import Header from './shared/Header';
import CreateProduct from './components/CreateProduct';

function App() {
  return (
    <Router>
      <Header />
      <Routes>
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} />
        <Route path="/products" element={<ProductList />} />
        <Route path="/create-product" element={<CreateProduct />} />
        <Route path="/" element={<Login />} />
      </Routes>
    </Router>
  );
}

export default App;

