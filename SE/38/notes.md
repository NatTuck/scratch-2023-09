
## Lecture 38: Server-Side State

Old state, in Redux:

```js
{
    secret: ["word", ...],
    guesses: Set["a", "b", ...],
    score: 5,
} 
```

Multiplayer, server state:

```js
{
    secret: ["word", ...],
    guesses: Set["a", "b", ...],
    players: [
       { name: "Alice", score: 5 },
       { name: "Bob", score: 9 } 
    ],
    active: "Alice",
} 
```

That makes our in-browser view (browser state):

```js
{
    puzzle: "----- ----",
    guesses: Set["a", "b", ...],
    players: [
       { name: "Alice", score: 5 },
       { name: "Bob", score: 9 } 
    ],
    active: "Alice",
    name: "Alice",
} 
```

## How to handle server-side state

Plan A: e.g. Rails, Next.js

 - App server is stateless
 - All state goes in DB or other external state service
 - Advantages: Then we can have one OS process per request,
   Scales in concurrency and parallelism through multiple servers
 - Disadvantage: Inconvenient when you really do want
   application state

Plan B: e.g. A typical frameworkless Java app

 - App server is stateful
 - Concurrent requests are handled by multiple threads
 - We can store state in shared memory
   - e.g. A global variable / singleton class
   - Need to manage synchronizaiton (e.g. "synchronized keyword")
 - Advantages: Fast, follows conventional pattterns
 - Disavanatages: Issues with threads/locks, doesn't scale to
   multiple machines without distributed systems patterns.

Plan C: e.g. the Erlang VM

 - App server is stateful
 - Concurrent requests are handled by Erlang processes
 - We can store state using Erlang patterns (e.g. GenServer)
 - Advantages: Well defined patterns, scales to multiple machines,
      forced to deal with distributed systems stuff from the start
 - Disavantages: Less common programming style,
      forced to deal with distributed systems stuff from the start
     
