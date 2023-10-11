
export default async function NewJoke() {
  return (
    <main className="text-center min-h-screen">
      <h1 className="text-2xl py-8">New Joke</h1>
      <form action="/joke" method="post">
        <label htmlFor="content" className="my-2">
          Content <br/>
          <textarea rows="4" cols="40" name="content"></textarea>
        </label>
        <div className="my-2">
          <button className="bg-blue-600 text-white py-2 px-4 rounded"
                  type="Submit">
            Save
          </button>
        </div>
      </form>
    </main>
  );
}
