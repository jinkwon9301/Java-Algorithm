const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
let input = fs.readFileSync(filePath).toString().trim().split('\n');
const [width, height] = input[0].split(' ').map(v => +v);
const matrix = input.slice(1).map(v => v.split(' ').map(v => +v));
const queue = [];
for (let y = 0; y < height; y++) {
  for (let x = 0; x < width; x++) {
    if (matrix[y][x] === 1) queue.push([y, x]);
  }
}

const sol = (width, height, matrix, queue) => {
  let day = 0;
  const dx = [0, 0, 1, -1];
  const dy = [1, -1, 0, 0];
  let count = 0;
  let head = 0;
  let tail = queue.length;

  const checkRange = (y, x) => {
    if (y >= 0 && x >= 0 && y < height && x < width) return true;
    else return false;
  };

  while (head !== tail) {
    for (let i = head; i < tail; i++) {
      const [y, x] = queue[i];
      for (let j = 0; j < 4; j++) {
        const nx = x + dx[j];
        const ny = y + dy[j];

        if (checkRange(ny, nx) && !matrix[ny][nx]) {
          matrix[ny][nx] = 1;
          queue.push([ny, nx]);
        }
      }
    }
    head = tail;
    tail = queue.length;
    day++;
  }
  for (let y = 0; y < height; y++) {
    for (let x = 0; x < width; x++) {
      if (!matrix[y][x]) return -1;
    }
  }
  return day - 1;
};

console.log(sol(width, height, matrix, queue));