
# Our Workflow

 - Story on Kanban board, marked "in progress"
   - What needs to be done is clearly defined
   - Acceptance critera for manual testing define
 - Create feature branch
 - Write code and tests
 - Make pull request
 - Code review
 - Deployed automatically

Plan: Write Tests First

This is Test Driven Development

 - Feature needs to be clearly defined
 - You can't add features you don't know how to test
 - This incentivizes writing the simplest code that passes
   the test

Specifically, the sequence is:

 - Write one new test (for a part of the feature).
 - Run the test suite and confirm you have exactly one test failure.
 - Make the minimum change needed to pass the test.
 - Run the test suite again, no failures.
 - Do any needed refactoring to make this code good.
 - Run the test suite again, no failures.
 - Repeat until feature complete.
 - Pull request.
