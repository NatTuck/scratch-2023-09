
# Continuous Integration

Github Actions

Lets us run code when PR is created or merged.

Lets us do two things:

 - CI: Run tests automatically on PR creation.
   - Maybe don't merge PR if tests fail.
 - CD: Automatic deployment.
   - After PR is merged.


## HTML Rendering

 - Browser is going to get the start of an HTML
   page as part of an HTTP response.
 - Uses an incremental parser.
   - Starts rendering immediately.
 - External assets trigger more HTTP requests.
   - Stylesheets, JavaScript, images, video
 - JavaScript is initially executed *synchronously* 
   with HTML parsing / rendering.




