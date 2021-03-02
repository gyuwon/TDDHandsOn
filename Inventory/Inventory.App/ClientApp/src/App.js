import React from "react";
import { Route } from "react-router";
import { Layout } from "./components/Layout";
import { Products } from "./components/Products";

import "./custom.css";

export default function App({ services: { fetchProducts } }) {
  return (
    <Layout>
      <Route
        exact
        path="/"
        render={() => <Products fetchProducts={fetchProducts} />}
      />
    </Layout>
  );
}
