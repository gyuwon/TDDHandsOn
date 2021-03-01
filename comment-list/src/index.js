import React from "react";
import ReactDOM from "react-dom";
import App from "./App";
import commentRefiner from "./content-refiners/trimWhitespaces";
import commentComposerFactory from "./commentComposerFactory";

const commentComposer = commentComposerFactory({ commentRefiner });

ReactDOM.render(
  <React.StrictMode>
    <App commentComposer={commentComposer} />
  </React.StrictMode>,
  document.getElementById("root")
);
