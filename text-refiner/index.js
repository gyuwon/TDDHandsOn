function refineText(s) {
  return s.replace("    ", " ").replace("  ", " ");
}

module.exports = refineText;
