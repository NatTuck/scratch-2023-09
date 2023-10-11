"use client";

import { useState } from 'react';

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

function Tab0({text, setText}) {
  return (
    <div>
      <p><input type="text" value={text}
                onChange={(ev) => setText(ev.target.value)} /></p>
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
