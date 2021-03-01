const sut = require("./index");

test('sut transforms "hello  world" to "hello world"', () => {
  expect(sut("hello  world")).toBe("hello world");
});

test('sut transforms "hello    world" to "hello world"', () => {
  expect(sut("hello    world")).toBe("hello world");
});
