import React from "react";
import ReactDOM from "react-dom";
import App from "./App";
import commentComposerFactory from "./commentComposerFactory";

ReactDOM.render(
  <React.StrictMode>
    <App commentComposer={commentComposerFactory()} />
  </React.StrictMode>,
  document.getElementById("root")
);
