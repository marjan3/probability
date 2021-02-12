// from functional.js
const pipe = (...fns) => (x) => fns.reduce((y, f) => f(y), x);

/**
 * Get a random number between min and max (inclusive)
 * @param {*} min
 * @param {*} max
 */
function getRandom(min, max) {
  min = Math.ceil(min);
  max = Math.floor(max);
  return Math.floor(Math.random() * (max - min + 1) + min);
}

function getRandomNumbers(size) {
  return () => {
    const arr = [];
    for (let i = 0; i < size; i++) {
      arr.push(getRandom(0, 1));
    }
    return arr;
  };
}

// the game
function empty() {
  const result = {};
  return result;
}

function flipCoin(result) {
  result.area = ['head', 'tail'];
  result.pick = result.area[getRandom(0, 1)];
  return result;
}

function win(result) {
  result.win = result.win = result.pick == 'head' ? 1 : 0;
  return result;
}

const spin = pipe(empty, flipCoin, win);

const game = {
  spin,
};

// simulation

function simulate(game, numberOfSimulations) {
  let balance = numberOfSimulations;
  const bet = 1;
  for (let i = 0; i < numberOfSimulations; i++) {
    balance -= bet;
    const result = game.spin();
    balance += result.win * bet;
    if (i === numberOfSimulations - 1) {
      console.log(JSON.stringify(result));
    }
  }
  const rtp = (balance / numberOfSimulations) * 100;
  return { balance, numberOfSimulations, rtp };
}

const result = simulate(game, 1000000000);

console.log(result);
