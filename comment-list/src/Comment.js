function Comment({ comment }) {
  return (
    <div>
      <input readOnly value={comment.content} />
      <div>{comment.author}</div>
      <div>{comment.createdTime.toString()}</div>
    </div>
  );
}

export default Comment;
