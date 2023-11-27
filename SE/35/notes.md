
# Lecture 35: Vendor Risk

Today's report:

 - You should have setup docs.

(Before) Next week's report:

 - Each team member will spin up a VPS and do a test deploy
 - You can use subdomains or top level domains
 - Should work with customer to get customer accounts set up
   and start work on customer deploy.

Today:

 - Two examples of managing vendor risk
 - The examples are politically charged, but the point shouldn't
   be.

Example: Parler

 - Was a social networking app
 - Founded in 2018
 - "A social network for conservatives"
 - By 2020, had become popular for a niche social networking app
   - They had gotten major political figures to sign up.
   - e.g. Ted Cruz
 - January 6th, 2021: Parler was widely reported as being
   an organization point for the events in DC
 - Soon there were widespread calls for the app to be shut down,
   including by its service providers.

Mostly on Jan 9th, service providers shut them down:

 - Google and Apple app stores.
   - This is approximately 100% of mobile app distribution.
   - Sideloading isn't possible on Apple.
   - On Android, sideloading is possible, but even Epic Games
     can't really make it work.
 - Twilio ended service, which killed SMS 2FA
 - ScyllaDB ended service (SaaS DB)
 - Finally, Amazon AWS froze their account
   - The app had been built such that it was tied closely to
     the AWS platform.
   - Moving it to another cloud provider was a porting task,
     not just a redeployment task.

Why didn't the developers consider this risk?

 - They built the app with a particular strategy:
   - Get a MVP up and running ASAP
   - Put all their effort into marketing to get users
   - Worry about the details later
 - That didn't work great.


**Example 2: The Pirate Bay**

The Pirate Bay launched in 2003.

It's mostly been up the whole time.

It's probably illegal under US law, and there's certainly a lot
of money in killing it.

The site was built with infrastructure resilliency from the beginning.
They *knew* they had vendor risk.

There have been plenty of attempts to take it down:

 - In 2006 the cops showed up at their main data center and
   took all their servers. They were down for three days.
 - In 2009 the site founders were found guilty of criminal copyright
   infringement and sent to jail. The site stayed up.

Some techniques they use:

 - They mostly run their own servers, colocated in data centers
   around the world.
 - They currently use Cloudflare.
   - This reduces bandwith costs.
   - This hides the location of servers.
 - Torrents aren't distributed through the site. Instead, they
   are distributed via the P2P "magnet" protocol.
 - They have multiple domain names in case of domain seisures.
   - But the origional .org domain is still up.

## Why might a vendor stop providing service?

 - Political - specific to you
 - Go out of business
 - Stop providing that service (like they're Google)
 - The whole service could be a political risk
 - Vendor gets bought out by Oracle
 - They change their pricing model in a way that no
   longer works with your buisness plan

So it's worth considering, for each vendor you use:

 - Is this service mandatory for my app?
 - Is this vendor mandatory?
 - What's the backup plan?
 - Is it possible to have a hot spare?

Data-lock in:

 - If you have 500 PB of data in Amazon S3 buckets...
 - It may not matter that other vendors also offer S3 compatible
   block storage.


