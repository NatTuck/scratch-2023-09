
# Continuous Deployment

 - Makes things easier
 - Automatic deployment encourages not breaking your
   main branch

Deploy to where?

"Every project has a testing environment. Some projects also
have a separate production environment."

Are there real users yet?

 - If the app breaks for users is that bad? How bad?
 - If you delete the production database, how do you recover? 

Pick any of:

 - Automatically deploy to productoin
 - Automatically deploy to testing environment
 - neither, both

How?

 - Github Actions
 - Just write a custom script (maybe even in Python)

**Secrets**

 - secret-key-base

Rails app with auto-deployment working:

https://github.com/NatTuck/jokes-rails
