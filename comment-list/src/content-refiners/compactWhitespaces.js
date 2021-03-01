function compactWhitespaces(value) {
  return value.indexOf("  ") < 0
    ? value
    : compactWhitespaces(value.replace("  ", " "));
}

export default compactWhitespaces;
