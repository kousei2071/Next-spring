# Next.js × Spring Boot

```
Next-spring/
├── backend/    Spring Boot 4.1（Java 17, ポート 8080）
└── frontend/   Next.js 16（React 19, ポート 3000）
```

## 必要なもの

| ツール | この環境 |
| --- | --- |
| Java 17+ | インストール済み |
| Node.js 20+ | インストール済み |
| Maven | 不要（`./mvnw` を使う） |

## 起動

ターミナルを 2 つ開く。

**1. API（Spring Boot）**

```bash
cd backend
./mvnw spring-boot:run
```

確認: http://localhost:8080/api/hello

**2. UI（Next.js）**

```bash
cd frontend
npm run dev
```

確認: http://localhost:3000

フロントはサーバー側で `http://localhost:8080/api/hello` を呼びます。ブラウザから直接呼ぶ場合は、`backend` 側の CORS 設定（`localhost:3000`）が効きます。
