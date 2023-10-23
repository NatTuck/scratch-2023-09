

How to be fast:

 - Be as close to the user as possible, physically.
 - Keep everything we need to load as small as possible:
   - External assets should be in first 16kB of HTML.
   - We care about breakpoints in file size:
     - 16k, 32k, 64k, 128k, etc
     - So splitting can help if we hit breakpoints
   - Minimize CSS and JS size so browser has info to render
