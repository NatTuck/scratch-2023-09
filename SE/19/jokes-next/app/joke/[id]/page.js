
import Link from 'next/link';

import { get_joke } from '@/lib/jokes';

export default async function ShowJoke({params}) {
  let {id} = params;
  let joke = await get_joke(parseInt(id));

  return (
    <main className="text-center min-h-screen">
      <h1 className="text-2xl py-8">Joke #{id}</h1>
      <p>{joke.content}</p>
      <p><Link className="text-sky-700 underline" href="/jokes">Back</Link></p>
    </main>
  );
}
