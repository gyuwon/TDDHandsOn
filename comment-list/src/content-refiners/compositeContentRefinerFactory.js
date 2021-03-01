function compositeContentRefinerFactory(refiners) {
  return (source) =>
    refiners.reduce((value, refiner) => refiner(value), source);
}

export default compositeContentRefinerFactory;
