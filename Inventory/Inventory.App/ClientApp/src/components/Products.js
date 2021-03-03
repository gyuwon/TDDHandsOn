import React, { useState, useEffect } from "react";

export function Products({ fetchProducts }) {
  const [products, setProducts] = useState([]);
  const [loading, setLoading] = useState(true);

  async function fetch() {
    setProducts(await fetchProducts());
    setLoading(false);
  }

  useEffect(() => {
    fetch();
  }, [fetchProducts]);

  return (
    <div>
      <h1 id="tabelLabel">Products</h1>
      {loading ? renderLoadingIndicator() : renderProducts(products)}
    </div>
  );
}

function renderLoadingIndicator() {
  return (
    <p>
      <em>Loading...</em>
    </p>
  );
}

function renderProducts(products) {
  return (
    <table className="table table-striped" aria-labelledby="tabelLabel">
      <thead>
        <tr>
          <th>Supplier Name</th>
          <th>Product Code</th>
          <th>Product Name</th>
          <th>List Price</th>
          <th>Discount</th>
          <th>Selling Price</th>
        </tr>
      </thead>
      <tbody>{products.map((product) => renderProduct(product))}</tbody>
    </table>
  );
}

function renderProduct(product) {
  return (
    <tr key={product.id}>
      <td>{product.supplierName}</td>
      <td>{product.productCode}</td>
      <td>{product.productName}</td>
      <td>{product.listPrice}</td>
      <td>{product.discount}</td>
      <td>{product.sellingPrice}</td>
    </tr>
  );
}
