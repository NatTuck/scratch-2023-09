
# Tasks:

 - Look at persistent chat services.
 - Doesn't cost money, self-hosted is OK.
 - Examples: Gitter, Rocket.Chat, Slack
 - Be ready to recommend one in your personal report

--

 - Take a look at different web frameworks.
 - Be ready to recommend one for your team to start the semester
   with.
   
--

 - Get a Github account.

# Web Applications

## Web Page

 - An HTML Document
   - Associated CSS, JS, (images, etc)
   - Has a URL
 - Static - Doesn't change unless a person changes it

## Web Site

 - A bunch of web pages
 - They share a URL prefix
 - Traditoinally stored as a directory full of pages and
   stuff.

## Web Server

 - Computer Program
 - Accepts HTTP requests
 - Sends responses

traditional case:

 - HTTP requests have a file path
 - Server find a file at that relative path 
   (under a document root)
 - Reads that file and sends it as the response

## Web Application

 - Dynamic web site
 - That means the same request may produce different responses
 - Could be a server plugin: e.g. PHP files are run instead of
   just sent.
 - Or, could be a custom webserver with arbitrary logic.
   - Given HTTP request, run code, produce HTTP response

## Web Frameworks

 - Tools and libraries to provide structure and common
   functionality for web app

Common framework elements:

 - Router - maps paths to implementation logic
 - Controller - code to take a request and generate a response
 - ORM (Object Relational Mapping) - Abstracts over SQL DB
   - Our framework should support (SQLite or H2) and 
     (PostgreSQL or MariaDB)
 - Template - Generates HTML outputs
 - Asset Pipeline - Some way to deal with NPM modules for JS and CSS

## Example Frameworks:

 - Ruby on Rails
 - Python / Django
 - Next JS
 - Remix JS
 - Elixir / Phoenix
 - Scala / Lift
 - ...
 
 - Optimally you'll learn a new programming language.

## Ruby on Rails example
