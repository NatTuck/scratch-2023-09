'use client';

export default function DeleteJoke({joke_id}) {
  function click_delete(ev) {
    ev.preventDefault();
    if (confirm("Really delete?")) {
      send_delete_joke(joke_id).then(() => {
        console.log("Deleted joke #" + joke_id);
      });
    }
  }

  return (
    <button onClick={click_delete}
            className="bg-red-600 text-white py-2 px-4 rounded">
      Delete
    </button>
  );
}

async function send_delete_joke(id) {
  let resp = await fetch('/joke', {
    method: 'DELETE',
    mode: 'same-origin',
    headers: {
      'content-type': 'application/json',
    },
    body: JSON.stringify({id}),
  });
  let _body = await resp.json();
  window.location.reload();
}
