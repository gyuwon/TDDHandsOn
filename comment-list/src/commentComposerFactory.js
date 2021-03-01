import { v4 as uuidv4 } from "uuid";
import commentRefiner from "./content-refiners/trimWhitespaces";

function commentComposerFactory() {
  return ({ author, content }) => {
    return {
      id: uuidv4(),
      author,
      content: commentRefiner(content),
      createdTime: new Date(),
    };
  };
}

export default commentComposerFactory;
