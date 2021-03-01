const sut = require("./index");

test.each`
  source              | expected
  ${"hello  world"}   | ${"hello world"}
  ${"hello   world"}  | ${"hello world"}
  ${"hello    world"} | ${"hello world"}
`('sut transforms "$source" to "$expected"', ({ source, expected }) => {
  const actual = sut(source);
  expect(actual).toBe(expected);
});
