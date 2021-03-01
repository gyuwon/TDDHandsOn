import { useState } from "react";

function Form({ commentComposer, onNewComment }) {
  const [author, setAuthor] = useState("");
  const [content, setContent] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    const newComment = commentComposer({ author, content });
    onNewComment(newComment);
    setAuthor("");
    setContent("");
  };

  return (
    <form onSubmit={handleSubmit}>
      <input
        name="author"
        value={author}
        type="text"
        onChange={(e) => setAuthor(e.currentTarget.value)}
        placeholder="작성자"
      />
      <input
        name="content"
        value={content}
        type="text"
        onChange={(e) => setContent(e.currentTarget.value)}
        placeholder="내용"
      />
      <button name="submit">입력</button>
    </form>
  );
}

export default Form;
