"use client";

import Plotly from 'plotly.js-dist';
import { useState, useEffect } from 'react';

export default function Form() {
  const [tab, setTab] = useState(0);
  const [text, setText] = useState("default");

  return (
    <main className="text-center min-h-screen py-4">
      <p>
        <button className="m-2 p-1 ring-1"
                onClick={() => setTab(0)}>Tab 0</button>
        <button className="m-2 p-1 ring-1"
                onClick={() => setTab(1)}>Tab 1</button>
      </p>
      { (tab == 0) ? <Tab0 text={text} setText={setText} /> : <Tab1 /> }
    </main>
  );
}

function makeData(xx) {
  return [
    {
      x: ['giraffes', 'orangutans', 'monkeys'],
      y: [xx, 14, 23],
      type: 'bar'
    }
  ];
}

function Tab0({text, setText}) {
  let data = makeData(20);
  let yy = 20;

  useEffect(() => {
    Plotly.newPlot('myDiv', data);
  });

  function click(ev) {
    ev.preventDefault();
    yy = (yy + 7) % 30;
    Plotly.react('myDiv', makeData(yy));
  }

  return (
    <div>
      <p><button onClick={click}>click</button></p>
      <div id="myDiv" style={{width: '600px', height: '400px'}} />
    </div>
  );
}

function Tab1() {
  return (
    <div>
      <p>Tab 1</p>
    </div>
  );
}
