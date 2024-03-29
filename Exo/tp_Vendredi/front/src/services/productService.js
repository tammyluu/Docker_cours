import api from './api';
import { authHeader } from '../helpers/auth-header';

const getAllProducts = () => {
  return api.get('/products', { headers: authHeader() });
};


const createProduct = (product) => {
  return api.post('/products/admin/post', product, { headers: authHeader() });
};
const updateProduct = (id,product) => {
  return api.put(`/products/${id}`,id, product, { headers: authHeader() });
};

const deleteProduct = (id) => {
  return api.delete(`/products/${id}`, { headers: authHeader() })
};


export const productService = { getAllProducts, createProduct, updateProduct, deleteProduct };
