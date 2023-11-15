

# No class friday

 - Report still due Monday
 - Talk to team mates at some point

# More security

## Sessions

 - HTTP is stateless
   - Nowadays we have cookies
   - Server sends "cookie" header to browser.
   - Browser sends back the same header on each subsequent request.
   - e.g. "cookie: user_id=5"
   - My browser will send "cookie: user_id=1"
   - Better plans:
     - session_id: b5bb9d8014a0f9b1d61e21e796d78dccdf1352f23cd32812f4850b878ae4944c
     - session_id: ```{user_id: 5, serial_num: 3, sig: "b5bbb..."}```
     - Problem: Hard to force-expire cryptographically signed sessions.

## API Authentication

API keys:

 - Long string of opaque text
 - Maybe this is effectively a username/password.
 - Maybe it's a crypto-signed token.
 - Generally access API via HTTPS
 - Send on every request

What if we want to allow an app to access our service
as a user? (e.g. third party mobile app client)

Why?

 - You want to be able to figure out if the user is abusing your
   service.
 - You want to be able to separately figure out if the app is abusing
   your service.

Process: OAuth (currently OAuth2)

 - App constructs link that the user clicks.
 - This brings the user to service web site in browser.
 - The user authenticates themseves to the service.
 - Do you want to allow this third party app to access this
   service as you with the following permisisons?
   - yes / no
 - This sends the user to the App's website, with a code.
 - The app website will directly contact the service, passing
   the code and a private API key.
 - The service sends the app back an authentication token.

# Your Web App is Network Accessible

 - Over a billion people can send arbitrary network requests
   to your web server.
 - You run your web server, you get to decide how it responds
   to requests.

## Attacks

 - Too broad an API

```html
<form action="/download" method="post">
    <select name="file">
        <option id="1">foo.txt</option>
        <option id="2">bar.jpg</option>
    </select>
    <button>Download</button>
</form>
```

## Cross-Site Request Forgery

http://192.168.1.1/

Log in with: admin / admin

Options:

 - Change the admin password
 - Port forwarding
 - Port blocking
 - etc

```html
<form action="http://192.168.1.1/new_port_forward" method="post">
    <input type="hidden" name="port" value="22" />
    <button>Download Movie</button>
</form>
```

```html
<form action="/new_port_forward" method="post">
    <input type="hidden" name="xsrf-token" value="...sessoin_id" />
    <input type="text" name="port" value="22" />
    <button>New Port Forward</button>
</form>

## Cross-Site Scripting Attacks

 - We have a website where users post comments.

A user types in a comment:

```html
<span id="worm">
  <p>See this cool picture: <a href="javascript:foo" onclick="bad javascript">
    picture</a></p>
  <p>Buy discount rolex watches at discountrolx.fi!</p>
  <script>
   function () { fetch(... path: "/create_message", method: "post",
   data: getElementById('worm').innerHTML) }();
  </script>
</span>
```

 - Don't allow any HTML
 - Only allow sanitized HTML. (Are you sure you got everything?)
   - better to list what you allow rather than what you block


