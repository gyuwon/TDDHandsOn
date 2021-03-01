function refineText(s, options) {
  s = s
    .replace("    ", " ")
    .replace("\t ", " ")
    .replace(" \t", " ")
    .replace("  ", " ")
    .replace("  ", " ")
    .replace("  ", " ")
    .replace("mockist", "*******")
    .replace("purist", "******");

  if (options) {
    for (const bannedWord of options.bannedWords) {
      const mask = "*".repeat(bannedWord.length);
      s = s.replace(bannedWord, mask);
    }
  }

  return s;
}

module.exports = refineText;
