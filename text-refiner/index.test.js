const sut = require("./index");

test("sut correcty transforms source", () => {
  for (const source of ["hello  world", "hello   world", "hello    world"]) {
    expect(sut(source)).toBe("hello world");
  }
});
