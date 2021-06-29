import { useState } from "react";
import CommentList from "./CommentList";
import Form from "./Form";

function App({ commentComposer }) {
  const [comments, setComments] = useState([]);

  return (
    <div>
      <Form
        commentComposer={commentComposer}
        onNewComment={(newComment) =>
          setComments([...comments, newComment])
        }
      />
      <CommentList comments={comments} />
    </div>
  );
}

export default App;
