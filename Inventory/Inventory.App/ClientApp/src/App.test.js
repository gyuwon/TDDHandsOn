import React from "react";
import {
  render,
  waitForElementToBeRemoved,
  screen
} from "@testing-library/react";
import { MemoryRouter } from "react-router-dom";
import App from "./App";

test("sut renders without crashing", async () => {
  render(
    <MemoryRouter>
      <App services={{ fetchProducts: () => Promise.resolve([]) }} />
    </MemoryRouter>
  );
  await waitForElementToBeRemoved(() => screen.getByText(/Loading.../i));
});
