

# Redux

 - Our entire in-browser state is one value (immutable js object).
 - That value lives in and is managed by an object called the store.
 - We can get the current value from the store at any time.
 - To update our state, we dispatch an action.
   - This is an object representing a state change.
 - We get to write code to combine the old state with the action
   to generate the new state.
 - Objects like react components can subscribe to changes to
   our state - and then they can rerender.

# Lecture code:

github: https://github.com/NatTuck/cart\_demo

branch: lecture1

