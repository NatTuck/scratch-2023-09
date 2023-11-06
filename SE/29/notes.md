

# User Authentication

We want: User account = One Person

 - When someone logs into an account, they're the right person.
   - We don't want arbitrary other person to authenticate
   - We don't want account sharing with permission
   - etc
 - This is generally impossible

Authenticaiton ideas:

 - Link our app's user account to existing account
   - Log in with: Facebook, Google, Github, etc.
   - Get a token sent to your email, SMS
 - Crytographic keys
   - Very secure
   - Still not a person
   - Too technical for anyone to actually do it
 - Use a password
   - User selects password when they register
   - We assume anyone who knows the password is that person

What are the security issues with building password authentication?

**Threat 1: Online Attacks**

 - Attacker tries to guess passwords to log in to app
 - Manual guessing isn't super effective,
   but scripts exist
 - Easy to guess: 1000 guesses/second

How many possiblities for a password:

 - lowercase letters: 26^n
 - 4 character password, 1k guesses/second: 7 minutes
 - 6 character password: 3 days
 - 8 character password: 6 years

Limit tries to 100/hour; as long as users have slightly reasonable
passwords.

**Threat 2: Offline Attacks**

The user sends the password to log in - we need to be able
to check if they got it right.

Bad Plan A: Store the password in your DB

 - If someone gets the DB, they have everyone's password.
   - And they're definitely going to log in to some user's
     bank account with that password.
 
Bad Plan B: Store a cryptographic hash (e.g. SHA256) of the
    password in the DB.

 - Attacker can still try to guess and check.
 - We can test about a billion hashes per second on a
   mid-range GPU.
 - Passwords are random lowercase letters.
 - How long to guess an 8 character password? 3.5 minutes
 - How about 8 characters with lower, upper, number, and 20 symbols?
   - 82^8 = 34k minutes = 567 hours = a month
 - How about a 12 character password with lowercase letters? 3 years

Attack: Storing Passwords

 - Store password hashes for common passwords.

Mitigation: Salt

 - When the user submits a password, we generate a random
   64-bit number S.
 - We hash(S + password), store salt and hash.

Good plan: Password hashing function (e.g. argon2)

 - This makes time to test a password tunable.
 - You can get back to the 1000/second rate as if an
   offline attack were an online attack.
 - Still need a salt.
 - Still want to suggest good passwords, at least 10 characters

Password requirements?

 - Good: Your password must be 10 characters.
 - Bad: It must contain a letter, a number, an emoji, and a katakana,
   hiragana, and kanji character.
 - Awful: You must change your password every 21 days.
   
Two factor authentication:

 - Usually, an app on the user's phone.
   - Proprietary app
   - Standards-based app
 - Sometimes an SMS or email
 - A physical token
 - Smart card
