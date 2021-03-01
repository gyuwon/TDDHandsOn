import { v4 as uuidv4 } from "uuid";

function commentComposerFactory({ commentRefiner }) {
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
