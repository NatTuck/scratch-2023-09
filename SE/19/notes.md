
## React

Functional-reactive programming:

 - User interfaces in a functional style

Functional programming, a style that focues on:

 - Immutable data
 - Pure functions
 
### Immutable data

 - Objects that don't change after creation.
 - These act like mathematical values

### Pure Functions

 - Don't have side effects
   - Don't do I/O.
   - Doesn't mutate global state
   - Doesn't even examine mutable global state
 - Look at arguments.
 - Return a value.

benefits:

 - Can cache (memoize) results.
 - Are allowed to recalculate several times.

## How FRP works:

Runtime loop:

 - Maintain a single (immutable) global state value.
 - programmer provides a render function
   - function converts (state) -> current display
 - programmer provides event handler(s) functions
   - function converts (state, event) -> new state

React:

 - The current display is an HTML document 
 - So render function goes from (state) -> shadow DOM
 - Runtime is going to generate an optimial set of changes
   to update the real page

 - React splits up render function into many components
 - React has many event handler functions

