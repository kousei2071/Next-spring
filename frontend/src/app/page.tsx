const API_URL = process.env.API_URL ?? "http://localhost:8080";

async function getHello(): Promise<string | null> {
  try {
    const res = await fetch(`${API_URL}/api/hello`, { cache: "no-store" });
    if (!res.ok) {
      return null;
    }
    const data: { message: string } = await res.json();
    return data.message;
  } catch {
    return null;
  }
}

export default async function Home() {
  const message = await getHello();

  return (
    <main className="flex min-h-full flex-1 flex-col items-center justify-center px-6">
      <p className="text-sm tracking-wide text-zinc-500">Next.js × Spring Boot</p>
      <h1 className="mt-3 text-3xl font-semibold tracking-tight">環境構築チェック</h1>
      {message ? (
        <p className="mt-6 text-lg text-emerald-700">{message}</p>
      ) : (
        <p className="mt-6 max-w-md text-center text-lg text-zinc-600">
          Spring Boot に接続できません。別ターミナルで
          <code className="mx-1 rounded bg-zinc-100 px-1.5 py-0.5 font-mono text-[0.9em]">
            ./mvnw spring-boot:run
          </code>
          を実行してください。
        </p>
      )}
    </main>
  );
}
