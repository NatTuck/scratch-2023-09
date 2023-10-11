
import Link from 'next/link';

import { list_jokes } from '@/lib/jokes';
import DeleteJoke from '@/components/delete_joke.js';

export default async function Jokes() {
  let jokes = await list_jokes();

  let joke_rows = jokes.map((joke) => (
    <tr key={joke.id}>
      <td>{joke.content}</td>
      <td>
        <DeleteJoke joke_id={joke.id} />
      </td>
    </tr>
  ));

  return (
    <main className="text-center min-h-screen">
      <h1 className="text-2xl py-8">List Jokes</h1>
      <p><Link className="text-sky-700 underline" href="/joke/new">New Joke</Link></p>
      <table className="table table-striped">
        <tbody>
          {joke_rows}
        </tbody>
      </table>
    </main>
  );
}
