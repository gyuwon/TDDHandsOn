function maskBannedWords(value) {
  return ["mockist", "purist"].reduce(maskBannedWord, value);
}

function maskBannedWord(value, bannedWord) {
  return value.replace(bannedWord, "*".repeat(bannedWord.length));
}

export default maskBannedWords;
