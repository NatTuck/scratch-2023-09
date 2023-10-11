
import { NextResponse } from 'next/server';

import { create_joke, delete_joke } from '@/lib/jokes';

export async function POST(request) {
  let data = await request.formData();

  let joke = Object.assign({}, {content: data.get('content')});
  console.log("create_joke", joke);

  let joke1 = await create_joke(joke);
  console.log("created", joke1);

  let resp = new Response("redirect", {
    status: 303,
    headers: {
      "Location": "/jokes",
    }
  });
  return resp;
}

export async function DELETE(request) {
  let {id} = await request.json();

  await delete_joke(id);

  return NextResponse.json({deleted: id});
}
