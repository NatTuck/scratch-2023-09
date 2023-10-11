
import { PrismaClient } from '@prisma/client';

const prisma = new PrismaClient();

export async function list_jokes() {
  let jokes = await prisma.joke.findMany();
  return jokes;
}

export async function get_joke(id) {
  let joke = await prisma.joke.findUnique({
    where: { id }
  });
  return joke;
}

export async function create_joke(joke) {
  let joke1 = await prisma.joke.create({ data: joke });
  return joke1;
}

export async function update_joke(joke) {
  await prisma.joke.update({
    where: { id: joke.id },
    data: joke
  });
}

export async function delete_joke(id) {
  await prisma.joke.delete({
    where: { id }
  });
}
