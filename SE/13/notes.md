
## Local Navigation

Traditionally:

 - Click a link: Browser goes to the URL
   - Loads a new page
   - Does the whole request / render sequence
   - Creates a new JS context
   - Avoid global state because it seems to be unreliable,
     is lost on every link

New modern way:

 - Clicking a link *simulates* going to the URl
   - Doesn't really load a new page.
   - Custom router on React
   - Under Rails, "turbolinks"
   - Doesn't create a new JS context
   - Avoid global state because it lasts too long, and it's
     hard to reason about what code has run

## Package Manager & Dependencies

**left-pad**

A bunch of libs broke, including React.

left_pad("hello", " ", 8) => "   hello"

## Software Licensing

Free software

 - Same as open source, but hippier

Open Source Software?

 - Software that you're allowed to use and change
 
Two kinds of open source software:

 - Permissive - Lets developers do whatever they want,
   as long as they don't plagarize. Maybe attribution
   requirements.
   - MIT
   - Apache 2
 - Copyleft 
   - GNU GPLv3
   - Requires that all copies you distribute include
     source code.
   - Requires that derivitive works be licensed under
     the (same) copyleft license.
