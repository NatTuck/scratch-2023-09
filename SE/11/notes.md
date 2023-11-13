
# We Have Customers

Customers:

 - Shawn Case, Math Prof - Team Rails
   - Point of Sale
 - Jason Charette, Poli Sci Prof - Team Next
   - Browser-heavy simulation

# Initial customer meeting

 - No later than October 6th
 - Contact customer by end of next week 
 - In person, no Zoom nonsense
 - Customer and whole team, in room with whiteboard
 - Try to schedule an hour or so

Meeting notes will be due with Week 6 Team Report

## At the meeting

Outline project constraints:

 - You're a small team
 - You have about 8 weeks to work on the project
 - You can do something meaningful, but not a huge project
 - Start with minimum demo
   - One step past a webpage with the words "coming soon"
 - Iterate into something more complicated.
   - (Minimum viable product, then enhancements)

Let the customer explain what they want in their words:

 - Understand what they think they want.
 - Try to find assumptions that they're making.

Taking notes:

 - Write and draw on whiteboard
 - take cell phone pictures


## Design from UI / Screens

What does the user see when they visit the app site?

Example: Web email

 - Login
   - An HTML form
   - Register link?
 - Inbox
   - Table: From and Subject
   - Folders?
 - View Email
   - From, Subject, Body
 - Compose Email
   - HTML Form
   - To, Subject, Body
   

## Design from DB schema

Again, an email client

 - Users table
   - email
   - hashed password
 - messages tables
   - Subject
   - To
   - From
   - body
   - Duplicates? Duplicates across users?
   - A message belongs to a user, duplicates except for
     user_id are fine.
 - Folders table

## Schedule going Forward

 - Week 4: 
   - Finishing that right now
 - Week 5 - Starts Sep 25: 
   - Get quiz app working and tested
   - Schedule meeting with customer
 - Week 6: 
   - Get quiz app continuously tested & deployed
   - Meet with customer
 - Week 7: 
   - Start on project app
   - Minimum demo deployed and shared with customer
 - Week 8 - Starts Oct 16: 
   - Start iterating



