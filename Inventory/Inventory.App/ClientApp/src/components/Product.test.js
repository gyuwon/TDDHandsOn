import React from "react";
import { Products } from "./Products";
import {
  render,
  waitForElementToBeRemoved,
  screen,
} from "@testing-library/react";

const products = [
  {
    id: "STARK:STARK-001",
    supplierName: "STARK",
    productCode: "STARK-001",
    productName: "Stark product 001",
    listPrice: 100000,
    discount: 10000,
  },
  {
    id: "STARK:STARK-002",
    supplierName: "STARK",
    productCode: "STARK-002",
    productName: "Stark product 002",
    listPrice: 200000,
    discount: 10000,
  },
  {
    id: "WAYNE:WAYNE-001",
    supplierName: "WAYNE",
    productCode: "WAYNE-001",
    productName: "Wayne product 001",
    listPrice: 150000,
    discount: 15000,
  },
  {
    id: "WAYNE:WAYNE-002",
    supplierName: "WAYNE",
    productCode: "WAYNE-002",
    productName: "Wayne product 002",
    listPrice: 250000,
    discount: 20000,
  },
];

test("sut renders all products", async () => {
  const { container } = render(
    <Products fetchProducts={() => Promise.resolve(products)} />
  );
  await waitForElementToBeRemoved(() => screen.getByText(/Loading.../i));

  const rows = container.querySelectorAll("table.table tbody tr");
  expect(rows).toHaveLength(products.length);
});
