
# Monitoring

Plan A: Look manually

 - $8/hour

Plan B: Have a bot do it

 - Need another VPS to run the bot on
 - Checks:
   - Does DNS work
   - What happens if we load the home page
   - Try to order a fake product
 - Notifications:
   - Email
   - Text message or phone call
     - Service like Twilio
     - Use a SIP trunk / direct SMS gateway
   - IM
     - Discord
     - XMPP
   - Write a mobile app
     - Does web notifications API actually work

Plan C: Pay for a service

 - Apparently uptimerobot is bad 


## Async Requests

Talk to server from browser code.

 - Full page loads
 - Asynchronous requests 
   - JSON api
 - Websockets

**Websockets**

 - HTTP is a request / response protocol
 - Built on top of TCP which connection / stream.
 - Websockets lets you switch back to a connection / stream protocol
   from HTTP.

Why?

 - Network security people like to block things.
 - They discovered network ports.
   - HTTP uses port 80 and port 443.
 - So they close all the other ports.
 - Browser developers figured the same thing - JavaScript can
   only make HTTP connections
 - So having every protocol pretend to be HTTP is the only way
   browser apps can work.

Why?

 - Normal HTTP requests can only be initiated by the browser.
 - If server wants to send a message, it can't.
   - We could have the browser poll every 100ms.
   - But we don't want that.
 - So having a websocket connection open lets the server send
   messages.

