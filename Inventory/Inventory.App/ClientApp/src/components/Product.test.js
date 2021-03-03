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
    sellingPrice: 90000,
  },
  {
    id: "STARK:STARK-002",
    supplierName: "STARK",
    productCode: "STARK-002",
    productName: "Stark product 002",
    listPrice: 200000,
    discount: 10000,
    sellingPrice: 190000,
  },
  {
    id: "WAYNE:WAYNE-001",
    supplierName: "WAYNE",
    productCode: "WAYNE-001",
    productName: "Wayne product 001",
    listPrice: 150000,
    discount: 15000,
    sellingPrice: 135000,
  },
  {
    id: "WAYNE:WAYNE-002",
    supplierName: "WAYNE",
    productCode: "WAYNE-002",
    productName: "Wayne product 002",
    listPrice: 250000,
    discount: 20000,
    sellingPrice: 230000,
  },
];

async function renderThenFetch(products) {
  const result = render(
    <Products fetchProducts={() => Promise.resolve(products)} />
  );
  await waitForElementToBeRemoved(() => screen.getByText(/Loading.../i));
  return result;
}

test("sut renders all products", async () => {
  const { container } = await renderThenFetch(products);

  const rows = container.querySelectorAll("table.table tbody tr");
  expect(rows).toHaveLength(products.length);
});

test("sut renders selling price header", async () => {
  const { container } = await renderThenFetch(products);

  const selector = "table.table thead tr th";
  const headers = Array.from(container.querySelectorAll(selector));
  expect(headers.map((h) => h.innerHTML)).toContain("Selling Price");
});

test("sut renders product name header", async () => {
  const { container } = await renderThenFetch(products);

  const selector = "table.table thead tr th";
  const headers = Array.from(container.querySelectorAll(selector));
  expect(headers.map((h) => h.innerHTML)).toContain("Product Name");
})

test.each(products)(
  "sut correctly renders selling price cell",
  async (product) => {
    const { container } = await renderThenFetch([product]);

    const selector = "table.table tbody tr td";
    const cells = Array.from(container.querySelectorAll(selector));
    expect(cells).toHaveLength(6);
    expect(cells[5].innerHTML).toBe(product.sellingPrice.toString());
  }
);
