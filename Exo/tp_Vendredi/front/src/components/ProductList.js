import React, { useEffect, useState } from 'react';
import { productService } from '../services/productService';
import { useNavigate } from 'react-router-dom'; 

function ProductList() {
  const [products, setProducts] = useState([]);
  const [error, setError] = useState('');
  const navigate = useNavigate();
  useEffect(() => {
    productService.getAllProducts()
      .then(response => {
        console.log(response)
        setProducts(response.data);
      })
      .catch(error => {
        setError('Erreur lors de la récupération des produits.');
      });
  }, []);

  const handleDeleteProduct = async (id) => {
    try {
      await productService.deleteProduct(id);
      console.log('Product deleted successfully');

      // Fetch the product list again to reflect the deletion
      const updatedProducts = await productService.getAllProducts();
      setProducts(updatedProducts);

      // Optionally, redirect the user after deletion
     
      navigate('/products'); // Example using React Router
    } catch (error) {
      console.error('Error deleting product:', error);
      // Handle errors (display message, etc.)
    }
  };

  const handleUpdateProduct = (id) => {
    // Navigate to update product form component with product ID
  
    navigate(`/products/${id}`); // Example using React Router
  };

  return (
    <div className="container mt-5">
      <h2>Product List</h2>
      {error && <div className="alert alert-danger" role="alert">
        {error}
      </div>}
      <table className="table">
        <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Price</th>
            <th scope="col">Actions</th> {/* Added Actions column */}
          </tr>
        </thead>
        <tbody>
          {products.map((product, index) => (
            <tr key={product.id}>
              <th scope="row">{index + 1}</th>
              <td>{product.name}</td>
              <td>{product.price}</td>
              <td>
                <button onClick={() => handleDeleteProduct(product.id)}>Supprimer</button>
                <button onClick={() => handleUpdateProduct(product.id)}>Modifier</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default ProductList;
