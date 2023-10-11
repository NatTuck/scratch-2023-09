"use client";

import { useState } from 'react';

export default function Root() {
  const [count, setCount] = useState(0);

  function update(change) {
    return (ev) => {
      ev.preventDefault();
      setCount(change(count));
    };
  }

  return (
    <main className="text-center min-h-screen py-4">
      <Counter count={count} update={update} />
    </main>
  );
}

function Counter({count, update}) {
  return (
    <div>
      <p>Count: {count}</p>
      <p><button onClick={update((x) => x + 1)}>++</button></p>
      <p><button onClick={update((x) => x - 1)}>--</button></p>
    </div>
  );
}
