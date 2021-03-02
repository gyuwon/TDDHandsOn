async function fetchProducts() {
  const response = await fetch("api/products");
  return await response.json();
}

export default {
  fetchProducts,
};
