import React from "react";
import ReactDOM from "react-dom";
import App from "./App";
import compositeContentRefinerFactory from "./content-refiners/compositeContentRefinerFactory";
import compactWhitespaces from "./content-refiners/compactWhitespaces";
import trimWhitespaces from "./content-refiners/trimWhitespaces";
import maskBannedWords from "./content-refiners/maskBannedWords";
import commentComposerFactory from "./commentComposerFactory";

const commentRefiner = compositeContentRefinerFactory([
  compactWhitespaces,
  trimWhitespaces,
  maskBannedWords,
]);

const commentComposer = commentComposerFactory({ commentRefiner });

ReactDOM.render(
  <React.StrictMode>
    <App commentComposer={commentComposer} />
  </React.StrictMode>,
  document.getElementById("root")
);
